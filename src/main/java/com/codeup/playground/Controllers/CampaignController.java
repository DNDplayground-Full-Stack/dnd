package com.codeup.playground.Controllers;

import com.codeup.playground.Models.Campaign;
import com.codeup.playground.Models.User;
import com.codeup.playground.Repositories.CampaignRepo;
import com.codeup.playground.Repositories.UserRepo;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CampaignController {

    private UserRepo userDoa;
    private CampaignRepo campaignDao;

    public CampaignController(UserRepo userDoa, CampaignRepo campaignDao) {
        this.userDoa = userDoa;
        this.campaignDao = campaignDao;
    }

    @GetMapping("/campaigns")
    public String welcome(Model model) {
        if (SecurityContextHolder.getContext().getAuthentication().getPrincipal() != "anonymousUser") {
            User loggedIn = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            model.addAttribute("user", loggedIn);
        }
        List<Campaign> campaigns = campaignDao.findAll();
        model.addAttribute("campaigns", campaigns);
        return "campaigns/index";
    }

    @GetMapping("/campaign/create")
    public String createPostForm(Model model) {
        if (SecurityContextHolder.getContext().getAuthentication().getPrincipal() != "anonymousUser") {
            User loggedIn = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            model.addAttribute("user", loggedIn);
        }
        model.addAttribute("campaign", new Campaign());
        return "campaigns/create";

    }

    @PostMapping("/campaign/create")
    public String SubmitPost(@RequestParam(name = "description") String description, @RequestParam(name = "name") String name) {
        Campaign campaign = new Campaign();
        User u = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        campaign.setDescription(description);
        campaign.setDm(u);
        campaign.setName(name);
        campaignDao.save(campaign);
        return "redirect:/campaigns";
    }

    @GetMapping("/campaign/{id}/edit")
    public String EditPost(@PathVariable long id, Model model) {
        model.addAttribute("campaign", campaignDao.getOne(id));
        return "campaigns/edit";
    }

    @PostMapping("/campaign/{id}/edit")
    public String editPostFrom(@ModelAttribute Campaign campaign, @PathVariable long id, @RequestParam(name = "description") String description, @RequestParam(name = "name") String name) {
        Campaign campaignToEdit = campaignDao.getOne(id);
        User u = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        campaign.setDescription(description);
        campaign.setDm(u);
        campaign.setName(name);
        campaignDao.save(campaignToEdit);
        return "redirect:/users/profile";
    }

    @PostMapping("/campaign/{id}/delete")
    public String deletePost(@PathVariable long id) {
        campaignDao.deleteById(id);
        return "redirect:/campaigns/index";
    }

//    @PostMapping("/campaign/{id}")
//    public String viewIndividualPost(@PathVariable long id, Model model) {
//        Campaign campaign = campaignDao.getOne(id);
//        model.addAttribute("campaign", campaign);
//        return "campaign";
//    }
    @GetMapping("/campaigns/{id}")
    public String getIndividualPost(Model model, @PathVariable long id) {
        if (SecurityContextHolder.getContext().getAuthentication().getPrincipal() != "anonymousUser") {
            User loggedIn = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            model.addAttribute("user", loggedIn);
        }
        Campaign campaign = campaignDao.getOne(id);
        model.addAttribute("campaign", campaign);
        return "campaigns/individualCampaign";
    }
}
