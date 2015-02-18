//------------------------------------------PACKAGE------------------------------------------------
package ticTacToe.model;
//------------------------------------------ENDOF PACKAGE------------------------------------------
//------------------------------------------IMPORT-------------------------------------------------
import java.util.Random;
//------------------------------------------ENDOF IMPORT-------------------------------------------
/**
 * this class generates moves by taking the available moves from a given board-instance and randomly
 * selecting one of them.
 * @author {}rpheus
 *
 */
//##########################################CLASS #################################################
public class RandomEngine implements GameEngine 
{
	//*********************************************PUBLIC******************************************
	/**
	 * Generate a random move given a particular board state
	 * @param board the board to be analysed for random available moves
	 * @param token the token of the player requesting the move
	 */
	@Override
	public Move generateMove(Board board, String token) 
	{//--------------------------------------------------------------------------------------------
		Random random = new Random();
		Move result = Board.getAvailableMoves().get(random.nextInt(Board.getAvailableMoves().size()));
		System.out.println(result.toString());
		result.setToken(token);
		return result;
	}//--------------------------------------------------------------------------------------------
	//*********************************************ENDOF PUBLIC************************************

}//#########################################ENDOF CLASS############################################
