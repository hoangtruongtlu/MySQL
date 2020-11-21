package main.java.com.vti.entity;

import java.awt.List;
import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.CONSTRUCTOR, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
//@Repeatable
public @interface AgeAnnotation {
	String message() default ("Tuoi lon hon 18 {value}");
	long value();
	Class<?>[] groups() default {};
}
