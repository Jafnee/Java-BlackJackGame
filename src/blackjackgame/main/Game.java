package blackjackgame.main;

import blackjackgame.gui.Frame;
import blackjackgame.model.cards.Card;
import blackjackgame.model.cards.Deck;
import blackjackgame.model.player.PlayerHand;
import blackjackgame.model.computer.ComputerHand;

/**
 *Game needs to be updated to follow a proper set of Blackjack rules:
 * http://www.blackjackinfo.com/blackjack-rules.php
 * 
 * @author Jafnee
 */
public class Game 
{
    private final Frame myFrame;
    private final PlayerHand pHand;
    private final ComputerHand cHand;
    private final Deck deck;
    private final Score score;
    private int noOfDecks;
    
    //Card conditions
    public static final int SAFE = 1;
    public static final int BLACKJACK = 2;
    public static final int FIVE = 3;
    public static final int BUST = 4;
    
    public Game()
    {
        myFrame = new Frame(this);
        pHand = new PlayerHand(this);
        cHand = new ComputerHand(this);
        deck = new Deck(this);
        score = new Score(this);        
    }

    public void startGame() 
    {
        myFrame.getContainerPanel().getButtonPanel().disableButton("h");
        myFrame.getContainerPanel().getButtonPanel().disableButton("s");
        myFrame.getContainerPanel().getButtonPanel().disableButton("n");
        
        deck.populateDeck(1);        
        firstDraw();
        mainGame();
        
        myFrame.getContainerPanel().getButtonPanel().setFocusable(true);
        myFrame.getContainerPanel().getButtonPanel().requestFocusInWindow();
    }
    
    public void mainGame()
    {
        disableStay();
        myFrame.getContainerPanel().getButtonPanel().updateScore(score.getPlayerScore(), score.getComputerScore());
        myFrame.getContainerPanel().getButtonPanel().setHandValue("p", pHand.getHandValue());
        myFrame.getContainerPanel().getButtonPanel().setHandValue("c", cHand.getHandValue());
        myFrame.getContainerPanel().getButtonPanel().disableButton("n");
        this.checkHands();
    }
    
    public void checkHands()
    {
        if (pHand.checkHand() == BUST)
        {
            score.incrementComputerScore();
            myFrame.getContainerPanel().getButtonPanel().enableButton("n");
        }
        else if (pHand.checkHand() == BLACKJACK)
        {
            score.incrementPlayerScore();
            myFrame.getContainerPanel().getButtonPanel().enableButton("n");
        }
        else if (pHand.checkHand() == FIVE)
        {
            score.incrementPlayerScore();
            myFrame.getContainerPanel().getButtonPanel().enableButton("n");
        }
        if (cHand.checkHand() == BLACKJACK)
        {
            myFrame.getContainerPanel().getButtonPanel().enableButton("n");
            score.incrementComputerScore();
        }
    }
    
    public boolean isCHigherthanP()
    {
        boolean t = false;
        if (cHand.getHandValue() >= pHand.getHandValue())
        {
            t = true;
        }
        return t;
    }
    
    public void disableStay()
    {
        if (this.isCHigherthanP())
        {
            myFrame.getContainerPanel().getButtonPanel().disableButton("s");
        }
        else
        {
            myFrame.getContainerPanel().getButtonPanel().enableButton("s");
        }
    }
    
    public void restartGame()
    {
        pHand.clearHand();
        cHand.clearHand();
        deck.clearDeck();
        myFrame.getContainerPanel().getCHandPanel().clearHand();
        myFrame.getContainerPanel().getPHandPanel().clearHand();
        startGame();
    }
    
    public void playerTurn()
    {
        transferCard("p",deck.randomCardIndex());
        mainGame();
    }
    
    public void computerTurn()
    {
        myFrame.getContainerPanel().getButtonPanel().disableButton("s");
        myFrame.getContainerPanel().getButtonPanel().disableButton("h");
        myFrame.getContainerPanel().getButtonPanel().disableButton("n");
        while (cHand.getHandValue() <= pHand.getHandValue() && cHand.getHandValue() <= 21 && cHand.getCards().size() <= 5)
        {
            transferCard("c",deck.randomCardIndex());
            myFrame.getContainerPanel().getButtonPanel().setHandValue("c",cHand.getHandValue());
        }
        if (cHand.checkHand() != Game.BUST && pHand.getHandValue() < cHand.getHandValue())
        {
            score.incrementComputerScore();
        }
        else if (cHand.checkHand() == Game.BUST)
        {
            score.incrementPlayerScore();
        }
        myFrame.getContainerPanel().getButtonPanel().enableButton("n");
    }
    
    public void firstDraw()
    {
        transferCard("p",deck.randomCardIndex());
        transferCard("p",deck.randomCardIndex());
        transferCard("c",deck.randomCardIndex());
        transferCard("c",deck.randomCardIndex());
        myFrame.getContainerPanel().getButtonPanel().enableButton("h");
        myFrame.getContainerPanel().getButtonPanel().enableButton("s");   
    }
    
    public void transferCard(String target, int index)
    {
        Card c = deck.getCard(index);
        int index2 = 0;
        if ("p".equals(target) || "player".equals(target))
        {
            pHand.addCard(c);
            index2 = pHand.getCards().size() - 1;
            myFrame.getContainerPanel().getPHandPanel().displayCard(target, index2);
        }
        else
        {
            cHand.addCard(c);
            index2 = cHand.getCards().size() - 1;
            myFrame.getContainerPanel().getCHandPanel().displayCard(target, index2);
        }
        deck.removeCardWithIndex(index);
        
        
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
