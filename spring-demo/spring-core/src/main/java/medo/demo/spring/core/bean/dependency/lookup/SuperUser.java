package medo.demo.spring.core.bean.dependency.lookup;

import lombok.Data;
import lombok.EqualsAndHashCode;

@SuperUserAnnotation
@EqualsAndHashCode(callSuper = false)
@Data
public class SuperUser extends User{

    private String permission;

}
