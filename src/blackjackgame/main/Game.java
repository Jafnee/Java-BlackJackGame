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
    private PlayerHand pHand;
    private ComputerHand cHand;
    private Deck deck;
    
    public Game()
    {
        pHand = new PlayerHand(this);
        cHand = new ComputerHand(this);
        deck = new Deck(this);
        
    }

    public void startGame() 
    {
        System.out.println("Game Started");
    }
}
