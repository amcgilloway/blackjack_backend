package com.codeclan.example.blackjackService.models;

import com.codeclan.example.blackjackService.repositories.CardRepository;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cascade;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name="decks")
public class Deck {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnoreProperties({"decks"})
    @ManyToMany
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(
            name = "deck_cards",
            joinColumns = {@JoinColumn(name = "deck_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "card_id", nullable = false, updatable = false)}
    )
    private List<Card> cards;

    public Deck(){
        cards = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public void addCard(Card card){
        this.cards.add(card);
    }

}
