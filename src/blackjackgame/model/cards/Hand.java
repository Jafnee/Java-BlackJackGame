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
import java.util.ArrayList;

/**
 *
 * @author Jafnee
 */
public abstract class Hand 
{
    private final ArrayList<Card> cards;
    protected Game game;
    
    public Hand()
    {
        cards = new ArrayList();
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
        int total = 0;
        int aces = 0;
        for (Card c : cards)
        {
            if (c.getValue().getValue() == 11)
            {
                aces++;
            }
            else
            {
            total += c.getValue().getValue();
            }
        }
        for (int i = 0; i < aces; i++)
            {
                if (total + 11 <= 21)
                {
                    total += 11;
                }
                else
                {
                    total +=1;
                }
            }
        return total;
    }
    
    public String checkHand()
    {
        String status;
        status = "";
        if (getHandValue() >21 )
        {
            status = "bust";
        }
        else if (getHandValue() == 21)
        {
            status = "blackjack";
        }
        else
        {
            status = "safe";
        }
        return status;
    }
    
    //////////////////////////////////
    public void setGame(Game g)
    {
        game = g;
    }
    
    public ArrayList<Card> getCard()
    {
        return cards;
    }
    /////////////////////////////////TEST
    public void printHand()
    {
        for (Card c : cards)
        {
            System.out.println(c.getSuit().name()+" "+c.getValue().name());
        }
    }
}
