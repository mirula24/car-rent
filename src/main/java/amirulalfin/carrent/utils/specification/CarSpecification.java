package amirulalfin.carrent.utils.specification;

import amirulalfin.carrent.model.Car;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class CarSpecification {
    public static Specification<Car> carSpecification(String name,
                                                      Boolean available) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (name != null && !name.isEmpty() && available) {
                predicates.add(criteriaBuilder.like(root.get("name"),
                        "%" + name + "% is availble" ));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
