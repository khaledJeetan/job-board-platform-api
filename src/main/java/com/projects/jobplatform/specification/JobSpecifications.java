package com.projects.jobplatform.specification;

import com.projects.jobplatform.modles.Job;
import org.springframework.data.jpa.domain.Specification;

public class JobSpecifications {

    public static Specification<Job> withTitle(String title){
        return (root, query, builder) -> builder.like(root.get("title"),title);
    }

    public static Specification<Job> withSalaryRange(double min, double max){
        return ((root, query, criteriaBuilder) -> criteriaBuilder.between(root.get("rangeSalary"),min,max));
    }
    public static Specification<Job> withLocation(String location){
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("location"),location);
    }

}
