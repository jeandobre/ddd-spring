package dddspring.common;

import com.google.common.base.Joiner;
import org.springframework.data.jpa.domain.Specification;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class RegexFilter {

    private final SpecificationBuilder builder;

    public RegexFilter(SpecificationBuilder builder) {
        this.builder = builder;
    }

    public Specification<?> getSpecFromFilter(String filter) {
        String operationSetExper = Joiner.on("|")
                .join(Operation.SIMPLE_OPERATION_SET);

        Pattern pattern = Pattern.compile("(OR| ?)(\\w+?)("
                + operationSetExper
                + ")(\\*?)(\\w+?)(\\*?);");
        Matcher matcher = pattern.matcher(filter);

        while (matcher.find()) {
            builder.or(matcher.group(1))
                    .key(matcher.group(2))
                    .operation(matcher.group(3))
                    .prefix(matcher.group(4))
                    .value(matcher.group(5))
                    .suffix(matcher.group(6))
                    .applyCriteria();
        }
        return builder.build();
    }
}
