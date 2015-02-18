//------------------------------------------PACKAGE------------------------------------------------
package ticTacToe.controller;
//------------------------------------------ENDOF PACKAGE------------------------------------------
//------------------------------------------IMPORT-------------------------------------------------
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ticTacToe.model.Move;
//------------------------------------------ENDOF IMPORT-------------------------------------------
/**
 * This class together with other concrete subclasses of 'Player', and the context class make up 
 * the "controller" of the tic tac toe game.<br><br>
 * 
 * this class when instantiated is an object that represents the human player, it implements two 
 * interfaces, 'Player' and 'ActionListener' this is so that the human player can be both a player,
 * allowing human player and the CPU player to be used polymorphically, AND it is the ActionListener
 * that controls what happens when the buttons on the board are clicked.<br><br>
 * 
 * This class provides public methods as defined in the 'Player' and 'ActionListener' Interfaces. The
 * Play() and actionPerformed() methods mirror each other so that when the button is clicked the play()
 * method is called.<br><br>
 * 
 * this is a concrete subclass in "state pattern" based on the GOF design patterns book. it represents a 
 * concrete state object<br>
 * @author {}rpheus
 *
 */
//##########################################CLASS #################################################
public class HumanPlayer implements Player, ActionListener 
{
	//*********************************************PUBLIC******************************************	
	/**
	 * method is called when a button is clicked, calls the play() method
	 */
	@Override
	public void actionPerformed(ActionEvent e) 
	{//--------------------------------------------------------------------------------------------
		this.play(context);
	}//--------------------------------------------------------------------------------------------
	
	/**
	 * takes a reference to the context object that called it and sets the internal context var equal
	 * equal to this. it then creates a new move based on coordinates stored in the CellButton and the
	 * internal 'token'(x or o) in this case x, and calls the this.setMove(), after this it sets the 
	 * active player in the context object to o.
	 * @param p (the context object that will be manipulated)
	 */
	@Override
	public void play(PlayerContext p) 
	{//--------------------------------------------------------------------------------------------
		this.context = p;
		this.move = new Move(context.getButton().getCoords()[0], context.getButton().getCoords()[1], token);
		context.setToO();
		this.setMove(move);
		System.out.println(move.getScore());
		
		context.getButton().doClick();
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
	 * returns the token associated with this player in this case 'X'
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
	//*********************************************ENDOF PUBLIC************************************
	
	
	//*********************************************PRIVATE*****************************************
	/** the token for this player */
	private static String token ="X";
	/** a reference to the context object that this class manipulates */
	private  PlayerContext context;
	/** Move object, stores the coordinates of the move to be made and the token */
	private Move move;
	//*********************************************ENDOF PRIVATE***********************************
}//#########################################ENDOF CLASS############################################
