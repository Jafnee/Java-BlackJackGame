/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package blackjackgame.model.cards;

import blackjackgame.main.Game;

/**
 *
 * @author Jafnee
 */
public final class Deck 
{
    private final String[] deck;
    private Game game;
    
    public Deck(Game g)
    {
        setGame(g);
        deck = new String[52];
    }
    
    public void populateDeck()
    {
       
    }
    //////////////////////////////
    public void setGame(Game g)
    {
        game = g;
    }
    /////////////////////////////For Tests
    public void printDeck()
    {
        
    }
}
