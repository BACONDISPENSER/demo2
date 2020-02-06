package pl.coderslab.controllers;



import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.AppUser;
import pl.coderslab.entity.CurrentUser;
import pl.coderslab.entity.Offer;
import pl.coderslab.repository.OfferRepository;
import pl.coderslab.services.UserService;
import pl.coderslab.validators.EditPhotoValidationGroupName;
import pl.coderslab.validators.RegisterGroupValidation;
import pl.coderslab.validators.UserEditValidationGroup;

import java.util.List;


@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final OfferRepository offerRepository;

    public UserController(UserService userService, OfferRepository offerRepository) {
        this.userService = userService;
        this.offerRepository = offerRepository;
    }

    @GetMapping("/add")
    public String addUser(Model model) {
        model.addAttribute("appUser", new AppUser());


        return "user/adduser";

    }

    @PostMapping("/add")
    public String addUserPost(@Validated(RegisterGroupValidation.class) AppUser appUser, BindingResult result) {
        if(result.hasErrors()){
            return "user/adduser";
        }
        userService.addUser(appUser);
        return "redirect:/";

    }


//    @GetMapping("/login")
//    public String login() {
//        return "user/login";
//    }



//    @GetMapping("/login")
//    public String login(Model model) {
//        model.addAttribute("user", new AppUser());
//        return "user/login";
//    }
//
//    @PostMapping("/login")
//    public String loginPost(HttpServletRequest request, @Validated(LoginGroupValidation.class) AppUser appUser, BindingResult result) {
//        if(result.hasErrors()){
//            return "user/login";
//        }
//
//        request.getSession().setAttribute("userSession", userService.findUserByMail(appUser.getEmail()));
//
//        return "redirect:/";
//    }

//    @GetMapping("/edit")
//    public String editUser(HttpServletRequest request ,Model model){
//
//
//        model.addAttribute("user", (AppUser) request.getSession().getAttribute("userSession"));
//
//             return "user/edituser";
//    }
//
//    @PostMapping("/edit")
//    public String editUserPost(HttpServletRequest request,
//                               @Validated(UserEditValidationGroup.class) AppUser appUser,
//                               BindingResult result) {
//
//        if(result.hasErrors()){
//            return "user/edituser";
//        }
//
//        AppUser appUserToEdit = (AppUser) request.getSession().getAttribute("userSession");
//        appUserToEdit.setEmail(appUser.getEmail());
//        appUserToEdit.setLogin(appUser.getLogin());
//        userService.userUpdate(appUserToEdit);
//        return "redirect:/user/profile";
//
//
//    }

    /*@GetMapping("profile/edit")
    public String admin(@AuthenticationPrincipal CurrentUser customUser, Model model) {
      AppUser appUser = customUser.getAppUser();
      model.addAttribute("appUser",appUser);
      return "user/edituser";
    }

    @PostMapping("profile/edit")
    public String editUserPost(@Validated(UserEditValidationGroup.class) AppUser appUser,
                               BindingResult result) {

        if(result.hasErrors()){
            return "user/edituser";
        }


        userService.userUpdate(appUser);



        return "redirect:/user/profile";


    }*/

//    @GetMapping("/profile/edit")
//    public String editUserData(@AuthenticationPrincipal CurrentUser customUser, Model model) {
//        model.addAttribute("appUser", userService.findUserByMail(customUser.getAppUser().getEmail()));
//        model.addAttribute("appUserPhoto", new AppUser());
//        model.addAttribute("appUserPassword", new AppUser());
//        return "user/edituser";
//    }
//    @PostMapping("/profile/edit/changeUserData")
//    public String editUserDataInDatabase(Model model, @Validated({UserEditValidationGroup.class}) AppUser appUser,
//                                         BindingResult result) {
//        if (result.hasErrors()) {
//            model.addAttribute("appUserPhoto", new AppUser());
//            model.addAttribute("appUserPassword", new AppUser());
//            return "user/edituser";
//        }
//        userService.userUpdate(appUser);
//        return "redirect:/user/profile";
//    }
//    @PostMapping("/profile/edit/changePhoto")
//    public String editUserPhotoInDatabase(@AuthenticationPrincipal CurrentUser customUser, Model model,
//                                          @ModelAttribute(value = "appUserPhoto")
//                                          @Validated({EditPhotoValidationGroupName.class}) AppUser appUser,
//                                          BindingResult result) {
//        if (result.hasErrors()) {
//            model.addAttribute("appUserPassword", new AppUser());
//            model.addAttribute("appUser", userService.findUserByMail(customUser.getAppUser().getEmail()));
//            return "user/edituser";
//        }
//        userService.updateUserPhoto(appUser);
//        return "redirect:/user/profile";
//    }
    /*@PostMapping("/edit/changePassword")
    public String editUserPasswordInDatabase(@AuthenticationPrincipal CurrentUser customUser, Model model,
                                             @ModelAttribute(value = "appUserPassword")
                                             @Validated({EditPasswordValidationGroupName.class}) AppUser appUser,
                                             BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute("appUserPhoto", new AppUser());
            model.addAttribute("appUser", userService.getUserByEmail(customUser.getAppUser().getEmail()));
            return "user/editUserData";
        }
        userService.updateUserPasswordEditData(appUser);
        return "redirect:/profile";
    }*/

    ////zrobic osobny controller na akcje uzytkownika PO ZALOGOWANIU!!!!

//    @ModelAttribute("userOffers")
//    public List<Offer> offerList(@AuthenticationPrincipal CurrentUser customUser){
//       AppUser userToGetIdFrom = userService.findUserByMail(customUser.getAppUser().getEmail());
//        return offerRepository.findAllByUserId(userToGetIdFrom.getId());
//    }
//
//
//
//    @GetMapping("/profile")
//    public String profile() {
//        return "user/profile";
//    }


}
