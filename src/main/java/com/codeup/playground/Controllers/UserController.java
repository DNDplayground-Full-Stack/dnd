package com.codeup.playground.Controllers;


import com.codeup.playground.Models.User;
import com.codeup.playground.Repositories.CampaignRepo;
import com.codeup.playground.Repositories.CharacterRepo;
import com.codeup.playground.Repositories.UserRepo;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    private UserRepo userDoa;
    private PasswordEncoder passwordEncoder;
    private CampaignRepo campaignDao;
    private CharacterRepo characterDao;

    public UserController(UserRepo userDoa, PasswordEncoder passwordEncoder, CampaignRepo campaignDao, CharacterRepo characterDao) {
        this.userDoa = userDoa;
        this.passwordEncoder = passwordEncoder;
        this.campaignDao = campaignDao;
        this.characterDao = characterDao;
    }

    @GetMapping("/register")
    public String showSignUpForm(Model model){
        model.addAttribute("user", new User());
        return "users/sign-up";
    }

    @PostMapping("/sign-up")
    public String saveUser(@ModelAttribute User user){
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        userDoa.save(user);
        return "redirect:/login";
    }

    @GetMapping("/profile")
    public String gotToBlogger(Model model) {
        if (SecurityContextHolder.getContext().getAuthentication().getPrincipal() != "anonymousUser") {
            User loggedIn = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            model.addAttribute("user", loggedIn);
            model.addAttribute("campaigns", campaignDao.findAll());
            model.addAttribute("characters", characterDao.findAll());
            return "users/profile";
        }
        return "Login";

    }

    @GetMapping("/search")
    public String search(){
        return "Search";
    }

}

