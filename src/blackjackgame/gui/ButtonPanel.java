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
    private JButton hit, stay;
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
        pValue = new JLabel("Player hand value: ");
        cValue = new JLabel("Computer hand value: ");
        this.setLayout(new GridLayout(2,2));
        add(hit);
        add(stay);
        add(pValue);
        add(cValue);
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        
    }
    
    ///////////////////////////////////////
    public void setContainerPanel(ContainerPanel cp)
    {
        containerPanel = cp;
    }
}
