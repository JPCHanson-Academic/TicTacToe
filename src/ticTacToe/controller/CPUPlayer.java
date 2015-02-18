//------------------------------------------PACKAGE------------------------------------------------
package ticTacToe.controller;
//------------------------------------------ENDOF PACKAGE------------------------------------------
//------------------------------------------IMPORT-------------------------------------------------
import ticTacToe.model.GameEngine;
import ticTacToe.model.MiniMaxEngine;
import ticTacToe.model.Move;
//------------------------------------------ENDOF IMPORT-------------------------------------------
/**
 * This class together with other concrete subclasses of 'Player', and the context class make up 
 * the "controller" of the tic tac toe game.<br><br>
 * 
 * This class, when instantiated, represents the AI player. unlike the human player it only need
 * implement the player interface (the computer doesn't need to click buttons),but it does need to be
 * a player to allow it to be interchanged with the human player at runtime.<br><br>
 * 
 * this class contains a 'gameEngine' which it uses to make its decision about what its next move
 * should be<br><br>
 * 
 * this is a concrete subclass in "state pattern" based on the GOF design patterns book. it represents a 
 * concrete state object<br>
 * @author {}rpheus
 *
 */
//##########################################CLASS #################################################
public class CPUPlayer implements Player
{
	//*********************************************PUBLIC******************************************
	/**
	 * takes a reference to the context object that called it and sets the internal context var equal
	 * to this. it then creates a new move based on coordinates stored in the CellButton and the
	 * internal 'token'(x or o) in this case o, and calls the this.setMove(), after this it sets the 
	 * active player in the context object to x, and calls the play() method of the context object (which
	 * is now pointing at the human player) and waits for a button press.
	 * @param p (the context object that will be manipulated)
	 */
	@Override
	public void play(PlayerContext p) 
	{//--------------------------------------------------------------------------------------------
		this.context = p;
		this.move = gameEngine.generateMove(context.getBoard(), token);
		//System.out.println(move.getXcoord()+""+move.getYcoord()+","+move.getToken());
		//System.out.println(move.getScore());
		context.setToX();
		this.setMove(this.move);
		
	}//--------------------------------------------------------------------------------------------
	
	/**
	 * takes a move object and passes it to the context class so it can update the model.
	 * @param move (the move to be played) 
	 */
	@Override
	public void setMove(Move move) 
	{//--------------------------------------------------------------------------------------------
		context.setMove(move);
	}//--------------------------------------------------------------------------------------------
	
	/**
	 * get the token of this player, i.e. o
	 * @return the token associated with this player
	 */
	public String getToken()
	{//--------------------------------------------------------------------------------------------
		return token;
	}//--------------------------------------------------------------------------------------------
	
	/**
	 * set the token used by this player
	 * @param newToken the new token to be used for this player
	 */
	public static void setToken(String newToken)
	{//--------------------------------------------------------------------------------------------
		token = newToken;
	}//--------------------------------------------------------------------------------------------
	
	/**
	 * set the gameEngine for the CPUPlayer
	 * @param gameEngine the GameEngine to be used as the new AI
	 */
	public static void setGameEngine(GameEngine gameEngine)
	{//--------------------------------------------------------------------------------------------
		CPUPlayer.gameEngine = gameEngine;
	}//--------------------------------------------------------------------------------------------
	//*********************************************ENDOF PUBLIC************************************
	
	
	//*********************************************PRIVATE*****************************************
	/** the token associated with this player */
	private static String token = "O";
	/** the context object that this class manipulates */
	private  PlayerContext context;
	/** Move object, stores the coordinates of the move to be made and the token */
	private Move move;
	/** internal reference to the GameEngine in use*/
	private static GameEngine gameEngine;
	//*********************************************ENDOF PRIVATE***********************************
}//#########################################ENDOF CLASS############################################