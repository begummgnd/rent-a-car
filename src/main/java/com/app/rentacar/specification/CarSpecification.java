package com.app.rentacar.specification;

import com.app.rentacar.model.Car;
import com.app.rentacar.model.enums.FuelType;
import com.app.rentacar.model.enums.GearType;
import com.app.rentacar.specification.criteria.SearchCriteria;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarSpecification {

    private Predicate predicate;

    public CarSpecification() {
    }

    public CarSpecification(Predicate predicate) {
        this.predicate = predicate;
    }

    public Predicate getPredicate() {
        return predicate;
    }

    public void setPredicate(Predicate predicate) {
        this.predicate = predicate;
    }

    public Specification<Car> createSpecification(List<SearchCriteria> criteria) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            for (SearchCriteria searchCriteria : criteria) {
                switch (searchCriteria.getOperation()) {
                    case ">":
                        predicate = criteriaBuilder.greaterThan(root.get(searchCriteria.getKey()), searchCriteria.getValue().toString());
                    case "<":
                        predicate = criteriaBuilder.lessThan(root.get(searchCriteria.getKey()), searchCriteria.getValue().toString());
                    case ":":
                        if (root.get(searchCriteria.getKey()).getJavaType() == String.class) {
                            predicate = criteriaBuilder.like(root.get(searchCriteria.getKey()), "%" + searchCriteria.getValue() + "%");
                        } else if (root.get(searchCriteria.getKey()).getJavaType() == FuelType.class) {
                            switch ((String) searchCriteria.getValue()) {
                                case "GAS":
                                    predicate = criteriaBuilder.equal(root.get(searchCriteria.getKey()), FuelType.GAS);
                                    break;
                                case "DIESEL":
                                    predicate = criteriaBuilder.equal(root.get(searchCriteria.getKey()), FuelType.DIESEL);
                                    break;
                                case "HYBRID":
                                    predicate = criteriaBuilder.equal(root.get(searchCriteria.getKey()), FuelType.HYBRID);
                                    break;
                                case "GASOLINE":
                                    predicate = criteriaBuilder.equal(root.get(searchCriteria.getKey()), FuelType.GASOLINE);
                                    break;
                            }
                        } else if (root.get(searchCriteria.getKey()).getJavaType() == GearType.class) {
                            switch ((String) searchCriteria.getValue()) {
                                case "MANUAL":
                                    predicate = criteriaBuilder.equal(root.get(searchCriteria.getKey()), GearType.MANUAL);
                                    break;
                                case "AUTOMATIC":
                                    predicate = criteriaBuilder.equal(root.get(searchCriteria.getKey()), GearType.AUTOMATIC);
                                    break;
                            }
                        } else {
                            predicate = criteriaBuilder.equal(root.get(searchCriteria.getKey()), searchCriteria.getValue());
                        }
                }
                predicates.add(predicate);
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
        };
    }
}
