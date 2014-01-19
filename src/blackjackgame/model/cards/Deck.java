/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package blackjackgame.model.cards;

import blackjackgame.main.Game;
import blackjackgame.model.cards.Enums.*;
import java.util.ArrayList;

/**
 *
 * @author Jafnee
 */
public final class Deck 
{
    private final ArrayList<Card> deck;
    private Game game;
    private Card card;
    
    public Deck(Game g)
    {
        setGame(g);
        deck = new ArrayList();
    }
    
    public void populateDeck(int n)
    {
        clearDeck();
        for (int i = 0; i < n; i++)
        {
            for (Suit s : Suit.values())
            {
                for (Value v : Value.values())
                {
                    card = new Card(s,v);
                    deck.add(card);
                }
            }
        }  
    }
    
    public void clearDeck()
    {
        deck.clear();
    }
    
    public void removeCard(Suit s, Value v)
    {
        removeCardWithIndex(getCardIndex(s,v));
    }
    
    public int getCardIndex(Suit s, Value v)
    {
        int index = 0;
        for (Card c : deck)
        {
            if (c.GetSuit() == s && c.GetValue() == v)
            {
                index = deck.indexOf(c);
            }
        }
        return index;
    }
    
    public void removeCardWithIndex(int index)
    {
        deck.remove(index);
    }
    
    public Card getCard(int index)
    {
        Card c = deck.get(index);
        return c;
    }
    //////////////////////////////
    public void setGame(Game g)
    {
        game = g;
    }
    /////////////////////////////For Tests
    public void printDeck()
    {
        for (Card c : deck)
        {
            System.out.println(c.GetSuit()+" : "+c.GetValue());
        }
        System.out.println("Number of cards: "+deck.size());
    }
}
