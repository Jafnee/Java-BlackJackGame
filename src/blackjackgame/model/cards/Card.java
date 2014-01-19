/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package blackjackgame.model.cards;

import blackjackgame.model.cards.Enums.*;

/**
 *
 * @author Jafnee
 */
public class Card {
    private final Suit suit;
    private final Value value;
    
    public Card(Suit s, Value v)
    {
        suit = s;
        value = v;
    }
    
    public String GetSuit()
    {
        return suit.name();
    }
    
    public String GetValue()
    {
        return value.name();
    }
}
