package com.codeclan.example.blackjackService.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="cards")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(value = EnumType.STRING)
    private Rank rank;

    @Enumerated(value = EnumType.STRING)
    private Suit suit;

    @Column(name="image")
    private String image;

    @JsonBackReference
    @ManyToMany
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(
            name = "deck_cards",
            joinColumns = {@JoinColumn(name = "card_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "deck_id", nullable = false, updatable = false)}
    )
    private List<Deck> decks;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
        this.decks = new ArrayList<>();
    }

    public Card() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    public List<Deck> getDecks() {
        return decks;
    }

    public void setDecks(List<Deck> decks) {
        this.decks = decks;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void addDeck(Deck deck){
        this.decks.add(deck);
    }
}
