package medo.demo.spring.jsr3031;

import lombok.Data;
import medo.demo.spring.jsr303.Status;
import org.junit.Assert;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

/**
 * @Author: yangcj
 * @Date: 2020/11/11 07:54
 */
public class StatusTest {

    @Test
    public void testStatusAnnotation() {

        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();

        Domain domain1 = new Domain();
        domain1.setStatus("CREATE");
        Set<ConstraintViolation<Domain>> violations = validator.validate(domain1);
        Assert.assertTrue(violations.isEmpty());

        Domain domain2 = new Domain();
        domain2.setStatus("ERROR");
        Set<ConstraintViolation<Domain>> violations1 = validator.validate(domain2);
        Assert.assertTrue(!violations1.isEmpty());
        violations1.forEach(violation -> {
            String message = violation.getMessage();
            Assert.assertEquals(message, "Error Status!");
        });
    }

    @Data
    public class Domain {
        @Status
        private String status;
    }

}
