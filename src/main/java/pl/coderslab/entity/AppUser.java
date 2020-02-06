package pl.coderslab.entity;


import lombok.Data;
import pl.coderslab.validators.*;

import javax.persistence.*;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.List;
import java.util.Set;

@Data
@UserExistance(groups = {LoginGroupValidation.class})
@Entity
@Table(name = "users")
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(groups = {RegisterGroupValidation.class, UserEditValidationGroup.class})
    private String login;
    @NotBlank(groups = {LoginGroupValidation.class, RegisterGroupValidation.class})
    @Pattern(regexp = "^(?=.*\\d).{4,20}$",groups = {RegisterGroupValidation.class, LoginGroupValidation.class})
    private String password;


    @EmailExistance(groups = {UserEditValidationGroup.class})
    @NotBlank(groups = {LoginGroupValidation.class, RegisterGroupValidation.class, UserEditValidationGroup.class})
    @EmailMatches(groups = {RegisterGroupValidation.class})
    @Email(groups = {LoginGroupValidation.class, RegisterGroupValidation.class, UserEditValidationGroup.class})
    private String email;
    private int pp = 0;
    @AssertTrue(groups = {RegisterGroupValidation.class})
    private boolean termsAccept;
    @Pattern(regexp = "([^\\s]+(\\.(?i)(jpg|png|gif|bmp))$)", groups = {EditPhotoValidationGroupName.class})
    private String photo = "defaultuserimg.png";
    private int admin = 0;
    private int enable = 1;
    @OneToMany
    @JoinColumn(name = "user_id")
    private List<Offer> offers;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Role> roles;


}
