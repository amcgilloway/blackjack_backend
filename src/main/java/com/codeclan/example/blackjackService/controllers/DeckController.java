package com.codeclan.example.blackjackService.controllers;

import com.codeclan.example.blackjackService.models.DeckBuilder;
import com.codeclan.example.blackjackService.repositories.CardRepository;
import com.codeclan.example.blackjackService.repositories.DeckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeckController {

    @Autowired
    DeckRepository deckRepository;

    @Autowired
    CardRepository cardRepository;

    @GetMapping(value = "/decks")
    public ResponseEntity getDeck(){
        return new ResponseEntity(deckRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping(value="/decks/new")
    public ResponseEntity newDeck(){
        deckRepository.deleteAll();
        cardRepository.deleteAll();
        DeckBuilder.buildDeck(deckRepository, cardRepository);
        return new ResponseEntity(HttpStatus.OK);
    }
}

