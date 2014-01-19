/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package blackjackgame.model.cards;

import blackjackgame.main.Game;
import java.util.ArrayList;

/**
 *
 * @author Jafnee
 */
public abstract class Hand 
{
    private ArrayList<Card> cards;
    protected Game game;
    
    public Hand()
    {
        
    }
    
    public void clearHand()
    {
        cards.clear();
    }
    
    public void addCard(Card card)
    {
        cards.add(card);
    }
    
    public int getHandValue()
    {
        return 2;
    }
    
    //////////////////////////////////
    public void setGame(Game g)
    {
        game = g;
    }
}
