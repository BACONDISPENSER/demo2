package pl.coderslab.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import pl.coderslab.entity.Offer;
import pl.coderslab.repository.OfferRepository;

import java.util.List;

@Controller
public class HomeController {
    private final OfferRepository offerRepository;

    public HomeController(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    @GetMapping("/")
    public String home(){
        return "home/home";
    }
    @ModelAttribute("topFiveOffers")
    public List<Offer> topFiveOffers(){
        return offerRepository.findTop5();
    }

    @ModelAttribute("allOffers")
    public List<Offer> allOffers(){
        return offerRepository.AllAllOffers();
    }

    @GetMapping("/all/notloggedoffers")
    public String displayAllOffers(){
        return "home/alloffers";
    }


}
