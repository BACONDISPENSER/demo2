package pl.coderslab.validators;

import pl.coderslab.services.UserService;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailExistanceValidator implements ConstraintValidator<EmailExistance,String> {

    UserService userService;

    public EmailExistanceValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void initialize(EmailExistance constraintAnnotation) {

    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
         String oldEmail = userService.getUserFromContext().getEmail();
         if(oldEmail.equals(email)){
             return true;
         }
        return userService.findUserByMail(email) == null;

    }
}
