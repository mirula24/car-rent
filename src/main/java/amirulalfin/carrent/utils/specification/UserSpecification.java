package amirulalfin.carrent.utils.specification;

import amirulalfin.carrent.model.User;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class UserSpecification {
    public static Specification<User> byUsername(String username) {

        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (username != null && !username.isEmpty()) {
                predicates.add(criteriaBuilder.like(root.get("name"),
                        "%"+username+"%"));
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));

        };

    }
}
