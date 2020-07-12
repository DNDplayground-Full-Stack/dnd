package com.codeup.playground.Repositories;

import com.codeup.playground.Models.Characters;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterRepo extends JpaRepository<Characters, Long> {
}