package com.ddd.spring.common;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public final class FilterCriteria {
    private String key;
    private Operation operation;
    private Object value;
    private boolean orPredicate;

    public FilterCriteria(final String orPredicate, String key, Operation operation, Object value) {
        this.orPredicate = (orPredicate != null && orPredicate.equals(Operation.OR_PREDICATE_FLAG));
        this.key = key;
        this.operation = operation;
        this.value = value;
    }

    public boolean isEqual() {
        return this.operation.equals(Operation.EQUALITY);
    }

    public boolean isGreaterThen() {
        return this.operation.equals(Operation.GREATER_THAN);
    }

    public boolean isLessThen() {
        return this.operation.equals(Operation.LESS_THAN);
    }

    public String key() {
        return key;
    }

    public Object value() {
        return value;
    }

    public boolean isOrPredicate() {
        return this.orPredicate;
    }

    public Operation operation() {
        return operation;
    }

    public Predicate getPredicateByBuilder(final Root root, final CriteriaBuilder builder) {
        switch (operation()) {
            case EQUALITY:
                return builder.equal(
                        root.get(key()), value());
            case NEGATION:
                return builder.notEqual(root.get(key()), value());
            case GREATER_THAN:
                return builder.greaterThan(root.get(key()), value().toString());
            case LESS_THAN:
                return builder.lessThan(root.get(key()), value().toString());
            case LIKE:
                return builder.like(root.get(key()), value().toString());
            case STARTS_WITH:
                return builder.like(root.get(key()), value() + "%");
            case ENDS_WITH:
                return builder.like(root.get(key()), "%" + value());
            case CONTAINS:
                return builder.like(root.get(key()), "%" + value() + "%");
            default:
                return null;
        }
    }

    @Override
    public String toString() {
        return "key='" + key + '\'' +
                ", operation=" + operation +
                ", value=" + value +
                ", orPredicate=" + orPredicate;
    }
}
