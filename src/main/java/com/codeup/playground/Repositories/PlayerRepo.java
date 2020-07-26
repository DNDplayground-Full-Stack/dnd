package com.codeup.playground.Repositories;

import com.codeup.playground.Models.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepo extends JpaRepository<Player, Long> {
}