/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package blackjackgame.main;

import blackjackgame.model.cards.Card;
import blackjackgame.model.cards.Deck;
import blackjackgame.model.cards.Enums.*;//TEST
import blackjackgame.model.player.PlayerHand;
import blackjackgame.model.computer.ComputerHand;

/**
 *
 * @author Jafnee
 */
public class Game 
{
    private final PlayerHand pHand;
    private final ComputerHand cHand;
    private final Deck deck;
    private int noOfDecks;
    //TEST
    Suit s;Value v;
    
    public Game()
    {
        pHand = new PlayerHand(this);
        cHand = new ComputerHand(this);
        deck = new Deck(this);
        
    }

    public void startGame() 
    {
        System.out.println("Game Started");
        //tests
        s = s.CLUB ; v = v.ACE;
        noOfDecks = 1;
        deck.populateDeck(noOfDecks);
        deck.printDeck();
        deck.removeCard(s,v);
        deck.printDeck();
    }
    
    public void trasferCard(String target, int index)
    {
        Card c = deck.getCard(index);
        if ("p".equals(target) || "player".equals(target))
        {
            pHand.addCard(c);
        }
        else
        {
            cHand.addCard(c);
        }
        deck.removeCardWithIndex(index);
    }
}
