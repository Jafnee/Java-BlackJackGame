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

import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Jafnee
 */
public class HandPanel extends JPanel
{
    protected ContainerPanel containerPanel;
    JLabel[] cards;
    int noOfCards = 4;
    
    public void createHand()
    {
//        cards[0] = new JLabel();
//        setLayout(new GridLayout(1,5));
//        cards[0].setText("SUP YO");
//        this.add(cards[0]);
//        cards[1].setText("SUP Y232O");
//        this.add(cards[1]);
//        cards[2].setText("11");
//        add(cards[2]);
//        add(cards);
//        add(cards);
        cards = new JLabel[noOfCards];
        setLayout(new GridLayout(1,noOfCards));
        ImageIcon image = new ImageIcon(getClass().getResource("/blackjackgame/gui/images/b1fv.png"));
        for (int i=0;i<noOfCards;i++) {
                cards[i] = new JLabel(image);
//                cards[i].setText("Hi");
//                cards[i].setVerticalAlignment(JLabel.CENTER);
//                cards[i].setHorizontalAlignment(JLabel.CENTER);
//                cards[i].setFont(cards[i].getFont().deriveFont(39.0f));
                this.add(cards[i]);
            }
    }
    
    ///////////////////////////
    public void setContainerPanel(ContainerPanel cp)
    {
        containerPanel = cp;
    }
}
