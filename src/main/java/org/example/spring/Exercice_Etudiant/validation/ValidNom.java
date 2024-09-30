package org.example.spring.Exercice_Etudiant.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = NomValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)

public @interface ValidNom {
    public String message() default "";
    public Class<?>[] groups() default {};
    public Class<? extends Payload>[] payload() default {};
}