package com.dogfoot.insurancesystemserver.global.config.security;

import com.dogfoot.insurancesystemserver.global.config.security.exception.CustomAuthenticationEntryPoint;
import com.dogfoot.insurancesystemserver.global.config.security.jwt.JwtAuthenticationFilter;
import com.dogfoot.insurancesystemserver.global.config.security.jwt.JwtAuthorizationFilter;
import com.dogfoot.insurancesystemserver.global.config.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.context.SecurityContextPersistenceFilter;
import org.springframework.web.filter.CorsFilter;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CorsFilter corsFilter;
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .formLogin().disable()
                .httpBasic().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilterBefore(corsFilter, SecurityContextPersistenceFilter.class)
                .addFilter(new JwtAuthenticationFilter(authenticationManager(), jwtTokenProvider))
                .addFilter(new JwtAuthorizationFilter(authenticationManager(), jwtTokenProvider))
                .exceptionHandling()
                .authenticationEntryPoint(new CustomAuthenticationEntryPoint());

        http
                .authorizeRequests()
                .antMatchers("/api/v1/user/**")
                .hasAnyRole("USER", "INSURANCE_SELLER", "ADMIN")
                .antMatchers("/api/v1/uw/**")
                .hasAnyRole("UW", "ADMIN")
                .antMatchers("/api/v1/seller/**")
                .hasAnyRole("INSURANCE_SELLER", "ADMIN")
                .antMatchers("/api/v1/planner/**")
                .hasAnyRole("INSURANCE_PLANNER", "ADMIN")
                .antMatchers("/api/v1/financial/supervisory/**")
                .hasAnyRole("FINANCIAL_SUPERVISORY_SERVICE", "ADMIN")
                .antMatchers("/api/v1/admin/**")
                .hasRole("ADMIN")
                .anyRequest()
                .permitAll();
    }

}
