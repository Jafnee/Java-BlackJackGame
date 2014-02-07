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
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JPanel;

/**
 *
 * @author Jafnee
 */
public final class ContainerPanel extends JPanel
{
    private Frame frame;
    private final PlayerHandPanel pHandPanel;
    private final ComputerHandPanel cHandPanel;
    private final ButtonPanel buttonPanel;
    
    public ContainerPanel(Frame f)
    {
        setFrame(f);
        pHandPanel = new PlayerHandPanel(this);
        cHandPanel = new ComputerHandPanel(this);
        buttonPanel = new ButtonPanel(this);
        createPanel();
    }
    
    public void createPanel()
    {
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 10;
        c.weighty = 10;
        c.gridx = 0;
        c.gridy = 2;
        this.add(pHandPanel, c);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 10;
        c.weighty = 10;
        c.gridx = 0;
        c.gridy = 1;
        this.add(buttonPanel, c);
        
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 10;
        c.weighty = 10;
        c.gridx = 0;
        c.gridy = 0;
        this.add(cHandPanel, c);
        
        this.setBackground(new Color(22,122,9));
    }
    
    ///////////////////////////////
    public void setFrame(Frame f)
    {
        frame = f;
    }
    
    public Frame getFrame()
    {
        return frame;
    }
    
    public PlayerHandPanel getPHandPanel()
    {
        return pHandPanel;
    }
    
    public ComputerHandPanel getCHandPanel()
    {
        return cHandPanel;
    }
    
    public PlayerHandPanel getPlayerHandPanel()
    {
        return pHandPanel;
    }
    
    public ButtonPanel getButtonPanel()
    {
        return buttonPanel;
    }
}
