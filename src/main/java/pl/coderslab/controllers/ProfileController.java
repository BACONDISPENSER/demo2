package pl.coderslab.controllers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.entity.AppUser;
import pl.coderslab.entity.CurrentUser;
import pl.coderslab.entity.Offer;
import pl.coderslab.repository.OfferRepository;
import pl.coderslab.services.OfferService;
import pl.coderslab.services.UserService;
import pl.coderslab.validators.EditPhotoValidationGroupName;
import pl.coderslab.validators.UserEditValidationGroup;

import java.util.List;

@Controller
@RequestMapping("/profile")
public class ProfileController {

    private final UserService userService;
    private final OfferRepository offerRepository;
    private final OfferService offerService;

    public ProfileController(UserService userService, OfferRepository offerRepository, OfferService offerService) {
        this.userService = userService;
        this.offerRepository = offerRepository;
        this.offerService = offerService;
    }

    @GetMapping("/edit")
    public String editUserData(@AuthenticationPrincipal CurrentUser customUser, Model model) {
        model.addAttribute("appUser", userService.findUserByMail(customUser.getAppUser().getEmail()));
        model.addAttribute("appUserPhoto", new AppUser());
        model.addAttribute("appUserPassword", new AppUser());
        return "profile/edituser";
    }

    @PostMapping("/edit/changeUserData")
    public String editUserDataInDatabase(Model model, @Validated({UserEditValidationGroup.class}) AppUser appUser,
                                         BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute("appUserPhoto", new AppUser());
            model.addAttribute("appUserPassword", new AppUser());
            return "profile/edituser";
        }
        userService.userUpdate(appUser);
        return "redirect:/profile";
    }

    @PostMapping("/edit/changePhoto")
    public String editUserPhotoInDatabase(@AuthenticationPrincipal CurrentUser customUser, Model model,
                                          @ModelAttribute(value = "appUserPhoto")
                                          @Validated({EditPhotoValidationGroupName.class}) AppUser appUser,
                                          BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute("appUserPassword", new AppUser());
            model.addAttribute("appUser", userService.findUserByMail(customUser.getAppUser().getEmail()));
            return "profile/edituser";
        }
        userService.updateUserPhoto(appUser);
        return "redirect:/profile";
    }


    @ModelAttribute("userOffers")
    public List<Offer> offerList(@AuthenticationPrincipal CurrentUser customUser) {
        AppUser userToGetIdFrom = userService.findUserByMail(customUser.getAppUser().getEmail());
        return offerRepository.findAllByUserId(userToGetIdFrom.getId());
    }


    @GetMapping
    public String profile() {
        return "profile/profile";
    }

    @ModelAttribute("offerQuantity")
    public int offerQuantity(){
     return offerService.findAllByUserId().size();
    }


}

