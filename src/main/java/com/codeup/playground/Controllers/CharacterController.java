package com.codeup.playground.Controllers;

import com.codeup.playground.Models.Characters;
import com.codeup.playground.Models.User;
import com.codeup.playground.Repositories.CampaignRepo;
import com.codeup.playground.Repositories.CharacterRepo;
import com.codeup.playground.Repositories.UserRepo;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class CharacterController {
    private UserRepo userDoa;
    private CampaignRepo campaignDao;
    private CharacterRepo characterDao;

    public CharacterController(UserRepo userDoa, CampaignRepo campaignDao, CharacterRepo characterDao) {
        this.userDoa = userDoa;
        this.campaignDao = campaignDao;
        this.characterDao = characterDao;
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
    public String postCharacterCreate(
            @RequestParam(name = "alignment") String alignment, @RequestParam(name = "armourClass") int armourClass,
            @RequestParam(name = "background") String background, @RequestParam(name = "biography") String biography,
            @RequestParam(name = "charisma") int charisma, @RequestParam(name = "constitution") int constitution,
            @RequestParam(name = "currentHitDice") int currentHitDice, @RequestParam(name = "dexterity") int dexterity,
            @RequestParam(name = "currentHitPoints") int currentHitPoints, @RequestParam(name = "initiative") int initiative,
            @RequestParam(name = "name") String name, @RequestParam(name = "race") String race,
            @RequestParam(name = "playerClass") String playerClass, @RequestParam(name = "level") String level,
            @RequestParam(name = "xp") int xp, @RequestParam(name = "proficiencyBonus") int proficiencyBonus,
            @RequestParam(name = "strength") int strength, @RequestParam(name = "intelligence") int intelligence,
            @RequestParam(name = "wisdom") int wisdom, @RequestParam(name = "movement") int movement,
            @RequestParam(name = "maxHitDice") int maxHitDice, @RequestParam(name = "temporaryHitPoints") int temporaryHitPoints,
            @RequestParam(name = "maxHitPoints") int maxHitPoints){
        //@RequestParam(name = "campaign") Campaign campaign,
        Characters character = new Characters();
        User u = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        character.setAlignment(alignment);
        character.setArmourClass(armourClass);
        character.setBackground(background);
        character.setBiography(biography);
        character.setCampaign(campaignDao.getOne(1L));
        character.setCharisma(charisma);
        character.setConstitution(constitution);
        character.setCurrentHitDice(currentHitDice);
        character.setDexterity(dexterity);
        character.setCurrentHitPoints(currentHitPoints);
        character.setInitiative(initiative);
        character.setName(name);
        character.setRace(race);
        character.setPlayerClass(playerClass);
        character.setLevel(level);
        character.setUser(u);
        character.setXp(xp);
        character.setProficiencyBonus(proficiencyBonus);
        character.setStrength(strength);
        character.setIntelligence(intelligence);
        character.setWisdom(wisdom);
        character.setMovement(movement);
        character.setMaxHitDice(maxHitDice);
        character.setTemporaryHitPoints(temporaryHitPoints);
        character.setMaxHitPoints(maxHitPoints);
        characterDao.save(character);
        return "redirect:/profile";
    }
}
