package com.dogfoot.insurancesystemserver.global.util;

import com.dogfoot.insurancesystemserver.domain.productdevelopment.domain.DevelopmentState;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class ListSpecification<T> {

    public Specification<T> equalToType(String type) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("dtype"), type);
    }

    public Specification<T> equalToState(DevelopmentState state) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("state"), state);
    }

    public Specification<T> equalToAvailable() {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("availableSale"), true);
    }

    public Specification<T> equalToUnAvailable() {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("availableSale"), false);
    }

}
