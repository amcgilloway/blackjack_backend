package com.codeclan.example.blackjackService.repositories;

import com.codeclan.example.blackjackService.models.Deck;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeckRepository extends JpaRepository<Deck, Long> {

}
