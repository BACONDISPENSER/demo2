package pl.coderslab.services;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.coderslab.entity.AppUser;
import pl.coderslab.entity.CurrentUser;
import pl.coderslab.entity.Role;
import pl.coderslab.repository.RoleRepository;
import pl.coderslab.repository.UserRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;


    public AppUser getUserFromContext() {
        CurrentUser currentUser = (CurrentUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return currentUser.getAppUser();
    }


    public UserService(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void addUser(AppUser appUser) {
        appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
        Role userRole = roleRepository.findByName("ROLE_USER");
        appUser.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        userRepository.save(appUser);

    }

    public void userUpdate(AppUser appUser) {
        AppUser userToEdit = userRepository.findByEmail(getUserFromContext().getEmail());
        userToEdit.setLogin(appUser.getLogin());
        userToEdit.setEmail(appUser.getEmail());

        userRepository.save(userToEdit);
        getUserFromContext().setEmail(userToEdit.getEmail());
        getUserFromContext().setLogin(userToEdit.getLogin());


    }
    public void updateUserPhoto(AppUser appUser) {
        AppUser userToEdit = userRepository.findByEmail(getUserFromContext().getEmail());
        userToEdit.setPhoto(appUser.getPhoto());


        userRepository.save(userToEdit);

    }




    public AppUser findUserByMail(String email) {
        return userRepository.findByEmail(email);
    }

    public AppUser findUserByPassword(String password) {
        return userRepository.findByPassword(password);
    }

    public void saveUser(AppUser appUser) {
        appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
        appUser.setEnable(1);
        Role userRole = roleRepository.findByName("ROLE_USER");
        appUser.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        userRepository.save(appUser);
    }




}
