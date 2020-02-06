package pl.coderslab.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.entity.Category;
import pl.coderslab.entity.Offer;
import pl.coderslab.repository.CategoryRepository;
import pl.coderslab.services.OfferService;

import javax.validation.Valid;
import java.net.BindException;
import java.util.List;

@Controller
@RequestMapping("/offer")
public class OfferController {

    private OfferService offerService;

    private CategoryRepository categoryRepository;

    public OfferController(OfferService offerService, CategoryRepository categoryRepository) {
        this.offerService = offerService;
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/add")
    public String offerAdd(Model model) {
        model.addAttribute("offer",new Offer());
        return "offer/addoffer";
    }

    @PostMapping("/add")
    public String offerAddPost(@Valid Offer offer, BindingResult result) {
        if(result.hasErrors()){
            return "offer/addoffer";
        }
        offerService.addOffer(offer);

        return "redirect:/profile";
    }

    @ModelAttribute("categories")
    public List<Category> categoryList(){
        return categoryRepository.findAll();
    }

}
