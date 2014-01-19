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

package blackjackgame.model.cards;

/**
 *
 * @author Jafnee
 */
public class Enums 
{
    public enum Suit
    {
        DIAMOND, CLUB, HEART, SPADE; 
    }
    
    public enum Value
    {
       ACE(11),
       TWO(2),
       THREE(3),
       FOUR(4),
       FIVE(5),
       SIX(6),
       SEVEN(7),
       EIGHT(8),
       NINE(9),
       TEN(10),
       JACK(10),
       QUEEN(10),
       KING(10); 
       
       int value;
       Value(int i)
       {
           value = i;
       }
       
       public int getValue()
       {
           return value;
       }
    }
}
