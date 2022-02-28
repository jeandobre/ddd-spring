package dddspring.common;

import com.google.common.base.Joiner;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class RegexFilter {
    private final String filter;
    private final List<FilterCriteria> params;

    public RegexFilter(String filter) {
        this.filter = filter;
        params = new ArrayList<>();
    }

    public List<FilterCriteria> params() {
        String operationSetExper = Joiner.on("|")
                .join(Operation.SIMPLE_OPERATION_SET);

        Pattern pattern = Pattern.compile("(OR| ?)(\\w+?)("
                + operationSetExper
                + ")(\\*?)(\\w+?)(\\*?);");
        Matcher matcher = pattern.matcher(filter);

        while (matcher.find()) {
            FilterCriteria filterCriteria = applyCriteria(
                    matcher.group(1),
                    matcher.group(2),
                    matcher.group(3),
                    matcher.group(4),
                    matcher.group(5),
                    matcher.group(6));

           if(filterCriteria != null) params.add(filterCriteria);
        }
        return params;
    }

    private FilterCriteria applyCriteria(String orPredicate, String key, String op,
                                         String prefix, String value, String suffix) {
        if (op != null) {
            Operation operation = Operation.getSimpleOperation(op.charAt(0));
            if (operation == Operation.EQUALITY) {
                final boolean startWithAsterisk = prefix != null && prefix.contains(Operation.ZERO_OR_MORE_REGEX);
                final boolean endWithAsterisk = suffix != null && suffix.contains(Operation.ZERO_OR_MORE_REGEX);

                if (startWithAsterisk && endWithAsterisk) {
                    operation = Operation.CONTAINS;
                } else if (startWithAsterisk) {
                    operation = Operation.ENDS_WITH;
                } else if (endWithAsterisk) {
                    operation = Operation.STARTS_WITH;
                }
            }
            return new FilterCriteria(orPredicate, key, operation, value);
        }
        return null;
    }
}
