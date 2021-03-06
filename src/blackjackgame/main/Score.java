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

/**
 *
 * @author Jafnee
 */
public final class Score {
    private Game game;
    private int playerScore;
    private int computerScore;
    
    public Score(Game g)
    {
        setGame(g);
        setupScore();
    }
    
    public int getComputerScore()
    {
        return computerScore;
    }
    
    public int getPlayerScore()
    {
        return playerScore;
    }
    
    public void incrementComputerScore()
    {
        computerScore++;
    }
    
    public void incrementPlayerScore()
    {
        playerScore++;
    }
    
    public void setupScore()
    {
        playerScore = 0;
        computerScore = 0;
    }
    
    public void setGame(Game g)
    {
        game = g;
    }
}
