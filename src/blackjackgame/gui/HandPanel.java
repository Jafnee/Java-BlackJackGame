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

package blackjackgame.gui;

import blackjackgame.model.cards.Card;
import blackjackgame.model.cards.Enums.Suit;
import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import sun.awt.SunHints.Value;

/**
 *
 * @author Jafnee
 */
public class HandPanel extends JPanel
{
    protected ContainerPanel containerPanel;
    JLabel[] cards;
    int noOfCards = 5;
    
    public void createHand()
    {

        cards = new JLabel[noOfCards];
        setLayout(new GridLayout(1,noOfCards));
        ImageIcon image = new ImageIcon(getClass().getResource("/blackjackgame/gui/images/e.png"));
        for (int i=0;i<noOfCards;i++) {
                cards[i] = new JLabel(image);
                this.add(cards[i]);
            }
    }
    
    public ImageIcon imageSelector(Suit s, Value v)
    {
        return null;
        
    }
    
    public void changeIcon()
    {
        ImageIcon image2 = new ImageIcon(getClass().getResource("/blackjackgame/gui/images/sk.png"));
        cards[3].setIcon(image2);
    }
    
    public void displayCard(String target,int index)
    {
        ImageIcon image;
        String imagePath;
        String suit;
        String value;
        Card card;
        if (target == "p")
        {
           card =  containerPanel.getFrame().getGame().getPlayerHand().getCard().get(index);
        }
        else
        {
            card =  containerPanel.getFrame().getGame().getComputerHand().getCard().get(index);
        }
        
        //Checking the card's suit
        suit = getCardSuit(card);
        
        //Checking the card's value
        value = getCardValue(card);
        
        //set image path;
        imagePath = "/blackjackgame/gui/images/"+suit+value+".png";
        image = new ImageIcon(getClass().getResource(imagePath));
        cards[index].setIcon(image);
    }
    
    public String getCardSuit(Card card)
    {
        String suit = null;
        
        if ("DIAMOND".equals(card.getSuit().toString()))
        {
            suit = "d";
        }
        else if ("CLUB".equals(card.getSuit().toString()))
        {
            suit = "c";
        }
        else if ("HEART".equals(card.getSuit().toString()))
        {
            suit = "h";
        }
        else if ("SPADE".equals(card.getSuit().toString()))
        {
            suit = "s";
        }
        return suit;
    }
    
    public String getCardValue(Card card)
    {
        String value = null;
        
        if ("ACE".equals(card.getValue().toString()))
        {
            value = "1";
        }
        else if ("ACE".equals(card.getValue().toString()))
        {
            value = "1";
        }
        else if ("TWO".equals(card.getValue().toString()))
        {
            value = "2";
        }
        else if ("THREE".equals(card.getValue().toString()))
        {
            value = "3";
        }
        else if ("FOUR".equals(card.getValue().toString()))
        {
            value = "4";
        }
        else if ("FIVE".equals(card.getValue().toString()))
        {
            value = "5";
        }
        else if ("SIX".equals(card.getValue().toString()))
        {
            value = "6";
        }
        else if ("SEVEN".equals(card.getValue().toString()))
        {
            value = "7";
        }
        else if ("EIGHT".equals(card.getValue().toString()))
        {
            value = "8";
        }
        else if ("NINE".equals(card.getValue().toString()))
        {
            value = "9";
        }
        else if ("TEN".equals(card.getValue().toString()))
        {
            value = "10";
        }
        else if ("JACK".equals(card.getValue().toString()))
        {
            value = "j";
        }
        else if ("QUEEN".equals(card.getValue().toString()))
        {
            value = "q";
        }
        else if ("KING".equals(card.getValue().toString()))
        {
            value = "k";
        }
        return value;
    }
    
    ///////////////////////////
    public void setContainerPanel(ContainerPanel cp)
    {
        containerPanel = cp;
    }
}
