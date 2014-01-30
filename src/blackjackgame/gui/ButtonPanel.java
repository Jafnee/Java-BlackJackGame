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

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Jafnee
 */
public class ButtonPanel extends JPanel implements ActionListener
{
    ContainerPanel containerPanel;
    private JButton hit, stay, newGame;
    private JLabel pValue;
    private JLabel cValue;

    public ButtonPanel(ContainerPanel cp) 
    {
        setContainerPanel(cp);
        createButtonPanel();
    }
    
    public void createButtonPanel()
    {
        hit = new JButton("Hit me");
        stay = new JButton("Stay");
        newGame = new JButton("New Game");
        pValue = new JLabel("Player hand value: 0");
        cValue = new JLabel("Computer hand value: 0");
        this.setLayout(new GridLayout(2,3));
        add(hit);
        add(stay);
        add(newGame);
        add(pValue);
        add(cValue);
        hit.addActionListener(this);
        stay.addActionListener(this);
        newGame.addActionListener(this);
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
}
