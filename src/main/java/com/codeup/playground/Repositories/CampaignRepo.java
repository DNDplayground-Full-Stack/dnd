package com.codeup.playground.Repositories;

import com.codeup.playground.Models.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CampaignRepo extends JpaRepository<Campaign, Long> {
}
