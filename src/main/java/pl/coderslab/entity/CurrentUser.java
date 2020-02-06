package pl.coderslab.entity;

import java.util.Collection;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

@Getter
@Setter
public class CurrentUser extends User {
    private final AppUser appUser;

    public CurrentUser(String email, String password,
                       Collection<? extends GrantedAuthority> authorities,
                       AppUser appUser) {
        super(email, password, authorities);
        this.appUser = appUser;
    }

    public AppUser getAppUser() {
        return appUser;
    }
}