package com.codeclan.example.blackjackService.models;

import com.codeclan.example.blackjackService.repositories.CardRepository;
import com.codeclan.example.blackjackService.repositories.DeckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Controller
public class DeckBuilder {


    public static void buildDeck(DeckRepository deckRepository, CardRepository cardRepository){
        List<Card> cards = new ArrayList<>();
        ArrayList<Suit> suits = new ArrayList<>(Arrays.asList(Suit.values()));
        ArrayList<Rank> ranks = new ArrayList<>(Arrays.asList(Rank.values()));
        for(Suit suit : suits){
            for(Rank rank : ranks){
                Card card = new Card(rank, suit);
                String cardImageStart = "/images/";
                String cardImageEnd = ".png";
                if((rank.getValue() == 10 || rank.getValue() == 1) && rank != Rank.TEN){
                    card.setImage(cardImageStart + suit.getName().toLowerCase() + "_" + rank.toString().toLowerCase() + cardImageEnd);
                }else {
                    card.setImage(cardImageStart + suit.getName().toLowerCase() + "_" + rank.getValue() + cardImageEnd);
                }
                cards.add(card);
            }
        }


        Deck deck = new Deck();
        deckRepository.save(deck);
        Collections.shuffle(cards);
        for (Card card : cards){
            card.addDeck(deck);
            cardRepository.save(card);
        }
    }
}
