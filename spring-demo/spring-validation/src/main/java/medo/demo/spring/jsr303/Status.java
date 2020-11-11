package medo.demo.spring.jsr303;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @Author: Bryce
 * @Date: 2020/11/11 07:46
 */
@Constraint(validatedBy = {StatusValidator.class})
@Target( { ANNOTATION_TYPE, METHOD, FIELD })
@Retention(RUNTIME)
public @interface Status {

    String message() default "Error Status!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

//    //指定多个时使用
//    @Target({FIELD, METHOD, PARAMETER, ANNOTATION_TYPE})
//    @Retention(RUNTIME)
//    @Documented
//    @interface List {
//        CannotHaveBlank[] value();
//    }


}
