package pl.coderslab.validators;


import org.springframework.beans.factory.annotation.Autowired;
import pl.coderslab.services.UserService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailMatchesValidator implements ConstraintValidator<EmailMatches, String> {

    @Autowired
    private UserService userService;


    @Override
    public void initialize(EmailMatches constraintAnnotation) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return userService.findUserByMail(s) == null;
    }
}
