/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AsianBlackJack;

import java.io.InputStream;
import java.util.Scanner;

/**
 *
 * @author hieud
 */
public class Game {

    private Player player;
    private Dealer dealer;

    public Game(Player player, Dealer dealer) {
        this.player = player;
        this.dealer = dealer;
    }


    //dealer deal cards
    public void deal() {
        dealer.setAmount(player.getAmount() * 10);

        //dealer get new deck and shuffle the deck    
        Deck deck = new Deck();
        deck.create();
        dealer.setDeck(deck);
        dealer.shuffle();

        Hand playerHand = new Hand();
        Hand dealerHand = new Hand();
        player.setHand(playerHand);
        dealer.setHand(dealerHand);
        
        //dealer deal cards
        dealer.deal(player, deck);

    }

}
