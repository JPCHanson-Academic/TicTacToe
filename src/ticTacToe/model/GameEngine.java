//------------------------------------------PACKAGE------------------------------------------------
package ticTacToe.model;
//------------------------------------------ENDOF PACKAGE------------------------------------------
/**
 * Any game engine needs to generate moves, and so that is the method that this interface ensures
 * @author {}rpheus
 */
//##########################################INTERFACE##############################################
public interface GameEngine 
{
	/**
	 * generates a move automagically given the current state of the board and the player token 
	 * provided
	 * @param board the current state of the board
	 * @param Token the player token for the player requesting a move
	 * @return (a 'Move' object)
	 */
	public Move generateMove(Board board, String token);

}//##########################################ENDOF INTERFACE#######################################
