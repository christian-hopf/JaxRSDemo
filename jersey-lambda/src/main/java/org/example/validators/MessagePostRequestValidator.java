package org.example.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.Annotation;

public class MessagePostRequestValidator implements ConstraintValidator<MessagePostRequest, org.example.model.MessagePostRequest> {
    @Override
    public void initialize(MessagePostRequest constraintAnnotation) {

    }

    @Override
    public boolean isValid(org.example.model.MessagePostRequest value, ConstraintValidatorContext context) {
        // Message text must exist and not be empty
        if (value.getText() == null || value.getText().isEmpty()) {
            return false;
        }
        return true;
    }


}
