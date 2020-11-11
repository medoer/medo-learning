package medo.demo.spring.jsr303;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: Bryce
 * @Date: 2020/11/11 07:35
 */
public class StatusValidator implements ConstraintValidator<Status, String> {

    private final List<String> ALL_STATUS = Arrays.asList("CREATE", "PENDING");

    @Override
    public void initialize(Status constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return ALL_STATUS.contains(value);
    }
}
