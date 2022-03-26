package com.ddd.spring.common;

import org.springframework.data.jpa.domain.Specification;
import java.util.List;

public abstract class SpecificationBuilder<T> {

    private final List<FilterCriteria> params;

    public SpecificationBuilder(String filter) {
        RegexFilter regexFilter = new RegexFilter(filter);
        params = regexFilter.params();
    }

    public Specification<T> build() {

        if (params.size() == 0) {
            return null;
        }
        System.out.println(params);
        Specification<T> result = getNewInstance(params.get(0));

        for (int i = 1; i < params.size(); i++) {
            result = params.get(i).isOrPredicate()
                ? Specification.where(result).or(getNewInstance(params.get(i)))
                : Specification.where(result).and(getNewInstance(params.get(i)));
        }
        return result;
    }

    protected abstract Specification getNewInstance(FilterCriteria filterCriteria);
}
