/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package blackjackgame.main;

import blackjackgame.model.cards.Deck;
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
    //tests
    
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
        deck.populateDeck();
        deck.printDeck();
    }
}
