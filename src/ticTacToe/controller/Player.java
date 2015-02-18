//------------------------------------------PACKAGE------------------------------------------------
package ticTacToe.controller;
//------------------------------------------ENDOF PACKAGE------------------------------------------
//------------------------------------------IMPORT-------------------------------------------------
import ticTacToe.model.Move;
//------------------------------------------ENDOF IMPORT-------------------------------------------
/**
 * this interface defines a prototype for any 'Player', as we all know, players play games, and so 
 * do ours. the 'Player's act as the controller for the model and the views.<br><br>
 * 
 * Players have two functions 1) to play the game 2) to decide on a move to play. This is why there 
 * are two methods defined for this interface play() and setMove() which respectively should fulfill
 * the functions 1) and 2)<br><br>
 * 
 * alternatively between the two methods it should be possible to control everything that needs
 * manipulating in the model and view.
 * @author {}rpheus
 *
 */
//##########################################INTERFACE PLAYER#######################################
public interface Player 
{
	//*********************************************PUBLIC******************************************
	/**
	 * Play the game
	 * @param backref self reference(or reference to other controller)
	 */
	public abstract void play(PlayerContext backref);
	
	/**
	 * decide on a move to make and possibly execute it
	 * @param move
	 */
	public abstract void setMove(Move move);
	//*********************************************ENDOF PUBLIC************************************
}
//#########################################ENDOF INTERFACE PLAYER##################################
