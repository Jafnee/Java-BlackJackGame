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
        transferCard("p",deck.randomCardIndex());
        transferCard("p",deck.randomCardIndex());
        transferCard("p",deck.randomCardIndex());
        pHand.printHand();
        //deck.printDeck();
//        System.out.println(deck.randomCardIndex());
//        System.out.println(deck.getCard(10).getValue().getValue());
        System.out.println(pHand.getHandValue());
        System.out.println(pHand.checkHand());
    }
    
    public void transferCard(String target, int index)
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
