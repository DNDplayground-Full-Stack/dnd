package com.codeup.playground.Controllers;

import com.codeup.playground.Models.Characters;
import com.codeup.playground.Models.User;
import com.codeup.playground.Repositories.CampaignRepo;
import com.codeup.playground.Repositories.UserRepo;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class CharacterController {
    private UserRepo userDoa;
    private CampaignRepo campaignDao;

    public CharacterController(UserRepo userDoa, CampaignRepo campaignDao) {
        this.userDoa = userDoa;
        this.campaignDao = campaignDao;
    }

    @GetMapping("/characters/create")
    public String GetCharacterCreate(Model model){
        if (SecurityContextHolder.getContext().getAuthentication().getPrincipal() != "anonymousUser") {
            User loggedIn = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            model.addAttribute("user", loggedIn);
        }
        Characters character = new Characters();
        model.addAttribute("character", character);
        return "characters/create";
    }

    @PostMapping("/characters/create")
    public String postCharacterCreate(Model model){
        Characters character = new Characters();
        User u = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        character.setAlignment();
//        character.setArmourClass();
//        character.setBackground();
//        character.setBiography();
//        character.setCampaign();
//        character.setCharisma();
//        character.setConstitution();
//        character.setCurrentHitDice();
//        character.setDexterity();
//        character.setCurrentHitPoints();
//        character.setInitiative();
//        character.setName();
//        character.setRace();
//        character.setPlayerClass();
//        character.setLevel();
//        character.setUser();
//        character.setXp();
//        character.setProficiencyBonus();
//        character.setStrength();
//        character.setIntelligence();
//        character.setWisdom();
//        character.setMovement();
//        character.setMaxHitDice();
//        character.setTemporaryHitPoints();
//        character.setMaxHitpoints();
        return "redirect:/profile";
    }
}
