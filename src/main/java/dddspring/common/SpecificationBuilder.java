package dddspring.common;

import org.springframework.data.jpa.domain.Specification;
import java.util.ArrayList;
import java.util.List;

public abstract class SpecificationBuilder {

    private final List<FilterCriteria> params;
    private String orPredicate;
    private String key;
    private Operation operation;
    private String prefix;
    private Object value;
    private String suffix;

    public SpecificationBuilder() {
        params = new ArrayList<>();
    }

    public SpecificationBuilder or(String orPredicate) {
        this.orPredicate = orPredicate;
        return this;
    }

    public SpecificationBuilder key(String key) {
        this.key = key;
        return this;
    }

    public SpecificationBuilder operation(String operation) {
        this.operation = Operation.getSimpleOperation(operation.charAt(0));
        return this;
    }

    public SpecificationBuilder prefix(String prefix) {
        this.prefix = prefix;
        return this;
    }

     public SpecificationBuilder value(Object value) {
         if(!value.toString().equalsIgnoreCase("NULL"))
            this.value = value;
        return this;
     }

     public SpecificationBuilder suffix (String suffix) {
        this.suffix = suffix;
        return this;
     }

     public SpecificationBuilder applyCriteria() {
       if (this.operation != null) {
            if (this.operation == Operation.EQUALITY) { // the operation may be complex operation
                final boolean startWithAsterisk = prefix != null && prefix.contains(Operation.ZERO_OR_MORE_REGEX);
                final boolean endWithAsterisk = suffix != null && suffix.contains(Operation.ZERO_OR_MORE_REGEX);

                if (startWithAsterisk && endWithAsterisk) {
                    this.operation = Operation.CONTAINS;
                } else if (startWithAsterisk) {
                    this.operation = Operation.ENDS_WITH;
                } else if (endWithAsterisk) {
                    this.operation = Operation.STARTS_WITH;
                }
            }
            params.add(new FilterCriteria(orPredicate, key, this.operation, value));
        }
        return this;
    }

    public Specification<?> build() {

        if (params.size() == 0) {
            return null;
        }
        System.out.println(params);
        Specification<?> result = getNewInstance(params.get(0));

        for (int i = 1; i < params.size(); i++) {
            result = params.get(i).isOrPredicate()
                ? Specification.where(result).or(getNewInstance(params.get(i)))
                : Specification.where(result).and(getNewInstance(params.get(i)));
        }
        return result;
    }

    protected abstract Specification getNewInstance(FilterCriteria filterCriteria);
}
