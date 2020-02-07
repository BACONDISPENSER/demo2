package pl.coderslab.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.entity.Offer;
import pl.coderslab.repository.OfferRepository;

import javax.servlet.http.HttpServletRequest;
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
    public String displayAllOffers(Model model){
        model.addAttribute("allTest",offerRepository.AllAllOffers());
        return "home/alloffers";
    }
    @GetMapping("/search")
    public String searchResult() {
        return "home/searchresult";
    }

    @PostMapping("/search")
    public String searchByTitle(HttpServletRequest request, @RequestParam(required = false) String searchOffer){

        request.getSession().setAttribute("searchResult", offerRepository.findAllByTitleContaining(searchOffer));

        return "redirect:/search";
    }



}
