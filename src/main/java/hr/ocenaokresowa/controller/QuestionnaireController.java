package hr.ocenaokresowa.controller;

import hr.ocenaokresowa.service.QuestionnaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class QuestionnaireController {

    QuestionnaireService questionnaireService;
    @Autowired
    public QuestionnaireController(QuestionnaireService questionnaireService) {
        this.questionnaireService = questionnaireService;
    }

    @GetMapping("/")
    public String home(Model model, Authentication auth){
        if(auth != null){
            UserDetails userDetails = (UserDetails) auth.getPrincipal();
            // przekazuję do widoku email zalogowanego użytkownika
            model.addAttribute("loggedEmail", userDetails.getUsername());
            model.addAttribute("isAdmin", questionnaireService.isAdmin(userDetails));
        }

//        List<Questionnaire> posts = questionnaireService.getAllPosts();

        // wydobycie listy kategorii
//        Set<CategoryEnum> categories = new HashSet<>();
//        for (Questionnaire post : posts) {
//            categories.add(post.getCategory());
//        }

        // przekazanie listy kategorii do widoku
//        model.addAttribute("categories", categories);

        // przekazanie obiektu do widoku
        // model.addAttribute(nazwa w html, obiekt przekazywany)
       // model.addAttribute("posts");

        return "home";     // zwracana nazwa widoku html

    }

    @GetMapping("/questionnaire")
    public String questionnaire(Model model){
        return "questionnaire";
    }

    @GetMapping("/testms")
    public String testms(Model model){
        model.addAttribute("info"," bedzie dobrze");
        return "index";
    }



}
