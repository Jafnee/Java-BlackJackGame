/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package blackjackgame.model.player;

import blackjackgame.main.Game;
import blackjackgame.model.cards.Hand;

/**
 *
 * @author Jafnee
 */
public class PlayerHand extends Hand
{
    
    public PlayerHand(Game g)
    {
        setGame(g);
    }
}
