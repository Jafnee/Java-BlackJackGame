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

import blackjackgame.gui.Frame;
import blackjackgame.model.cards.Card;
import blackjackgame.model.cards.Deck;
import blackjackgame.model.cards.Enums.*;//TEST
import blackjackgame.model.player.PlayerHand;
import blackjackgame.model.computer.ComputerHand;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jafnee
 */
public class Game 
{
    private Frame myFrame;
    private final PlayerHand pHand;
    private final ComputerHand cHand;
    private final Deck deck;
    private int noOfDecks;
    //TEST
    Suit s;Value v;
    
    public Game()
    {
        myFrame = new Frame(this);
        pHand = new PlayerHand(this);
        cHand = new ComputerHand(this);
        deck = new Deck(this);
        
    }

    public void startGame() 
    {
//        boolean cont = true;
        System.out.println("Game Started");
        /*
        Could ask how many decks to play with.
        draw 2 cards for player and computer both visible
        asks player to hit or to stay
        game will check cards values every turn
        will check to see if bust or blackjack
        if either, it will end game
        if not, it will continue
        */
        deck.populateDeck(1);
        try 
        {
            Thread.sleep(1000);
        } catch (InterruptedException ex) 
        {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
        firstDraw();
//        while (true)
//        {
//            if ("bust".equals(pHand.checkHand()) || "blackjack".equals(pHand.checkHand()) || pHand.getCard().size() == 5)
//            {
//                break;
//            }
//        }
        mainGame();
    }
    
    public void mainGame()
    {
        pHand.printHand();
        System.out.println(pHand.getHandValue());
        System.out.println(pHand.checkHand());
    }
    
    public void playerTurn()
    {
        transferCard("p",deck.randomCardIndex());
        mainGame();
    }
    
    public void firstDraw()
    {
        transferCard("p",deck.randomCardIndex());
        transferCard("p",deck.randomCardIndex());
        transferCard("c",deck.randomCardIndex());
        transferCard("c",deck.randomCardIndex());
    }
    
    public void transferCard(String target, int index)
    {
        Card c = deck.getCard(index);
        int index2 = 0;
        if ("p".equals(target) || "player".equals(target))
        {
            pHand.addCard(c);
            index2 = pHand.getCard().size() - 1;
            myFrame.getContainerPanel().getPHandPanel().displayCard(target, index2);
        }
        else
        {
            cHand.addCard(c);
            index2 = cHand.getCard().size() - 1;
            myFrame.getContainerPanel().getCHandPanel().displayCard(target, index2);
        }
        deck.removeCardWithIndex(index);
        
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public PlayerHand getPlayerHand()
    {
        return pHand;
    }
    
    public ComputerHand getComputerHand()
    {
        return cHand;
    }
}
