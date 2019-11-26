package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * user can transmit info about methods
 */
@Target({ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface MethodInfo {

  String author() default "Artem";
  int dateOfCreation() default 2019;
  String purpose() default "Print Hello";

}
