/*
 * The MIT License
 *
 * Copyright 2014 Jafnee.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
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
