package com.codeup.playground.Controllers;

import com.codeup.playground.Repositories.CampaignRepo;
import com.codeup.playground.Repositories.UserRepo;
import org.springframework.stereotype.Controller;


@Controller
public class CharacterController {
    private UserRepo userDoa;
    private CampaignRepo campaignDao;

    public CharacterController(UserRepo userDoa, CampaignRepo campaignDao) {
        this.userDoa = userDoa;
        this.campaignDao = campaignDao;
    }

}
