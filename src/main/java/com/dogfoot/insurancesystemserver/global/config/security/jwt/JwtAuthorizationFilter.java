package com.dogfoot.insurancesystemserver.global.config.security.jwt;

import com.auth0.jwt.exceptions.TokenExpiredException;
import com.dogfoot.insurancesystemserver.domain.user.exception.NoLoginException;
import com.dogfoot.insurancesystemserver.domain.user.exception.WithdrawalAccountException;
import com.dogfoot.insurancesystemserver.global.config.security.exception.ErrorCode;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAuthorizationFilter extends BasicAuthenticationFilter {

    private final JwtTokenProvider jwtTokenProvider;

    public JwtAuthorizationFilter(AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider) {
        super(authenticationManager);
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            String username = jwtTokenProvider.validateToken(request);
            if (!username.equals("")) {
                String token = jwtTokenProvider.createToken(username);
                response.addHeader("Authorization", "Bearer " + token);
            }
        } catch (WithdrawalAccountException e) {
            request.setAttribute("exception", ErrorCode.WITHDREW);
        } catch (NoLoginException | TokenExpiredException e) {
            request.setAttribute("exception", ErrorCode.NO_LOGIN);
        }

        chain.doFilter(request, response);
    }

}
