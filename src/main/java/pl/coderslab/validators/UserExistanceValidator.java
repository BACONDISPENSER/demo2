package pl.coderslab.validators;

import org.springframework.security.crypto.bcrypt.BCrypt;
import pl.coderslab.entity.AppUser;
import pl.coderslab.services.UserService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UserExistanceValidator implements ConstraintValidator<UserExistance, AppUser> {

    private UserService userService;

    public UserExistanceValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void initialize(UserExistance constraintAnnotation) {

    }

    @Override
    public boolean isValid(AppUser appUser, ConstraintValidatorContext constraintValidatorContext) {
        if(userService.findUserByMail(appUser.getEmail())==null) {
            return false;
        }
        return BCrypt.checkpw(appUser.getPassword(), userService.findUserByMail(appUser.getEmail()).getPassword());

    }
}
