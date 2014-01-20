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
    
    ///////////////////////////
    public void setContainerPanel(ContainerPanel cp)
    {
        containerPanel = cp;
    }
}
