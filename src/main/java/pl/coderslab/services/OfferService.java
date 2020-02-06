package pl.coderslab.services;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import pl.coderslab.entity.AppUser;
import pl.coderslab.entity.CurrentUser;
import pl.coderslab.entity.Offer;
import pl.coderslab.repository.OfferRepository;
import pl.coderslab.repository.UserRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class OfferService {

    UserRepository userRepository;
    OfferRepository offerRepository;


    public OfferService(UserRepository userRepository, OfferRepository offerRepository) {
        this.userRepository = userRepository;
        this.offerRepository = offerRepository;
    }

    public AppUser getUserFromContext() {
        CurrentUser currentUser = (CurrentUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return currentUser.getAppUser();
    }

    public void addOffer(Offer offer) {
        AppUser userToSet = userRepository.findByEmail(getUserFromContext().getEmail());
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String textDate = formatter.format(date);
        LocalDateTime dateTime = LocalDateTime.parse(textDate, formatter);


        offer.setUser(userToSet);
        offer.setCreated(dateTime);
        offerRepository.save(offer);



    }

}
