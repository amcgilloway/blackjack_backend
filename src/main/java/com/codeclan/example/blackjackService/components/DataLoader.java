package com.codeclan.example.blackjackService.components;

import com.codeclan.example.blackjackService.models.*;
import com.codeclan.example.blackjackService.repositories.CardRepository;
import com.codeclan.example.blackjackService.repositories.DeckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Profile("!test") //Run every time EXCEPT Tests
@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    DeckRepository deckRepository;

    @Autowired
    CardRepository cardRepository;

    public DataLoader() {

    }

    public void run(ApplicationArguments args) {

        DeckBuilder.buildDeck(deckRepository, cardRepository);
    }
}
