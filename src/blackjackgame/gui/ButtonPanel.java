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

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author Jafnee
 */
public class ButtonPanel extends JPanel implements ActionListener, ChangeListener, KeyListener
{
    ContainerPanel containerPanel;
    private JButton hit, stay, newGame;
    private JLabel BLANK, pValue, cValue, score, money, betAmmount;
    private JSlider betSlider;

    public ButtonPanel(ContainerPanel cp) 
    {
        setContainerPanel(cp);
        createButtonPanel();
    }
    
    public void createButtonPanel()
    {
        BLANK = new JLabel();
        hit = new JButton("Hit me");
        stay = new JButton("Stay");
        newGame = new JButton("New Game");
        pValue = new JLabel("Player hand value: 0");
        cValue = new JLabel("Computer hand value: 0");
        score = new JLabel("Player: 0 Computer: 0");
        money = new JLabel("Money: $1000");
        betSlider = new JSlider(0,1000,100);
        betAmmount = new JLabel("Bet: $100");
        this.setLayout(new GridLayout(3,3,-1,-1));
        
        hit.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        stay.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        newGame.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        pValue.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        cValue.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        score.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        money.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        betSlider.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        betAmmount.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
        add(hit);
        add(stay);
        add(newGame);
        add(pValue);
        add(cValue);
        add(score);
        add(money);
        add(betSlider);
        add(betAmmount);
        this.addKeyListener(this);
        hit.addActionListener(this);
        stay.addActionListener(this);
        newGame.addActionListener(this);
        betSlider.setMinorTickSpacing(100);
        betSlider.setMajorTickSpacing(200);
//        betSlider.setPaintLabels(true);
        betSlider.setPaintTicks(true);
        betSlider.addChangeListener(this);
        betSlider.setOpaque(false);
        this.setBackground(new Color(255,255,255));
    }
    
    @Override
            public void stateChanged(ChangeEvent e) {
                String s = "Bet: $";
                betAmmount.setText(s+betSlider.getValue());
            }
    
    public void updateScore(int pS,int cS)
    {
        String p = "Player: ";
        String c = " Computer: ";
        score.setText(p+pS+c+cS);
    }
    
    public void disableButton(String b)
    {
        switch(b)
        {
            case "h":
                hit.setEnabled(false);
                break;
            case "s":
                stay.setEnabled(false);
                break;
            case "n":
                newGame.setEnabled(false);
                break;
        }
    }
    
    public void enableButton(String b)
    {
        switch(b)
        {
            case "h":
                hit.setEnabled(true);
                break;
            case "s":
                stay.setEnabled(true);
                break;
            case "n":
                newGame.setEnabled(true);
                break;
        }
    }
    
    public void setHandValue(String target,int val)
    {
        JLabel j = null;
        String s = null;
        String p = "Player hand value: ";
        String c = "Computer hand value: ";
        if ("p".equals(target))
        {
            j = pValue;
            s = p;
        }
        else if("c".equals(target))
        {
            j = cValue;
            s = c;
        }
        
        if (val < 21 && containerPanel.getFrame().getGame().getPlayerHand().getCards().size() != 5 && "p".equals(target))
        {
            j.setText(s+val);
        }
        if (val < 21 && containerPanel.getFrame().getGame().getComputerHand().getCards().size() != 5 && "c".equals(target))
        {
            j.setText(s+val);
        }
        else if (val > 21)
        {
            j.setText(s+val+" Bust");
            hit.setEnabled(false);
            stay.setEnabled(false);
        }        
        else if (val == 21)
        {
            j.setText(s+val+" Blackjack");
            hit.setEnabled(false);
            stay.setEnabled(false);
        }
        else if (containerPanel.getFrame().getGame().getPlayerHand().getCards().size() == 5)
        {
            j.setText(s+val+" Five card win");
            hit.setEnabled(false);
            stay.setEnabled(false);
        }
        
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if (e.getSource() == hit)
        {
            containerPanel.getFrame().getGame().playerTurn();
            //hit.setEnabled(false);
        }
        else if (e.getSource() == stay)
        {
            containerPanel.getFrame().getGame().computerTurn();
        }
        else if (e.getSource() == newGame)
        {
            containerPanel.getFrame().getGame().restartGame();
        }
    }
    
    ///////////////////////////////////////
    public void setContainerPanel(ContainerPanel cp)
    {
        containerPanel = cp;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getKeyChar() == 'q')
        {
            containerPanel.getFrame().getGame().playerTurn();
        }
        else if (e.getKeyChar() == 'w')
        {
            containerPanel.getFrame().getGame().computerTurn();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
