package com.app.rentacar.specification;

import com.app.rentacar.specification.criteria.SearchCriteria;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FiltersSpecification<T> {

    private Predicate predicate;

    public FiltersSpecification(Predicate predicate) {
        this.predicate = predicate;
    }

    public Predicate getPredicate() {
        return predicate;
    }

    public void setPredicate(Predicate predicate) {
        this.predicate = predicate;
    }

    public FiltersSpecification() {
    }
    public Specification<T> createSpecification(List<SearchCriteria> criteria){

        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            for(SearchCriteria searchCriteria : criteria){

                switch (searchCriteria.getOperation()){
                    case ">":
                        predicate = criteriaBuilder.greaterThan(root.get(searchCriteria.getKey()) , searchCriteria.getValue().toString());
                    case "<":
                        predicate = criteriaBuilder.lessThan(root.get(searchCriteria.getKey()), searchCriteria.getValue().toString());
                    case ":":
                        if(root.get(searchCriteria.getKey()).getJavaType() == String.class ){
                            predicate = criteriaBuilder.like(root.get(searchCriteria.getKey()), "%" + searchCriteria.getValue() + "%");
                        }else{
                            predicate = criteriaBuilder.equal(root.get(searchCriteria.getKey()), searchCriteria.getValue());
                        }
                }
                predicates.add(predicate);
            }
           return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
        };
    }
}
