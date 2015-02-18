//------------------------------------------PACKAGE------------------------------------------------
package ticTacToe.controller;
//------------------------------------------ENDOF PACKAGE------------------------------------------
//------------------------------------------IMPORT-------------------------------------------------
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ticTacToe.model.Board;
import ticTacToe.model.Move;
import ticTacToe.model.Rules;
import ticTacToe.view.CellButton;
import ticTacToe.view.GameWindow;
//------------------------------------------ENDOF IMPORT-------------------------------------------
/**
 * This class together with other concrete subclasses of 'Player' make up the "controller" of the 
 * tic tac toe game.<br><br>
 * 
 * This is the context class in a "state pattern" arrangement based on the GOF design patterns book.
 * Its public methods are defined in the 'player' and 'ActionListener' interfaces. the only public
 * method used by the concrete subclasses is the setMove() method. Otherwise the concrete subclasses
 * use only the packageScope methods.<br><br>
 * 
 * the behavior of this class is set and controlled by the concrete subclasses of player acting as 
 * state objects.<br><br>
 * 
 * this class provides public methods as described in the 'Player' Interface.<br>
 * @author {}rpheus
 *
 */
//##########################################CLASS #################################################
public class PlayerContext implements Player, ActionListener 
{	
	//*********************************************PUBLIC******************************************	
	/**
	 * constructor takes a reference to the view to update (GameWindow) and a reference to the button
	 * that is creating it. it initializes these to internal vars, and sets the default player to player1
	 * @param window, the view to be updated.
	 * @param targetButton, the CellButton that this object is responsible for.
	 */
	public PlayerContext(GameWindow window, CellButton targetButton)
	{//--------------------------------------------------------------------------------------------
		this.view = window;
		this.view.attachController(this);
		this.targetButton = targetButton;
		player = player1;
	}//--------------------------------------------------------------------------------------------
	
	/**
	 * As this object IS a player it needs a play() method, this method calls the play method in
	 * whichever concrete subclass of player is currently the active player.
	 * @param p (self reference passed by other 'state object' concrete subclasses of 'player')
	 */
	@Override
	public void play(PlayerContext p) 
	{//--------------------------------------------------------------------------------------------
		player.play(this);
	}//--------------------------------------------------------------------------------------------
	
	/**
	 * As one of the concrete subclasseses of player is an action listener this class must be too,hence
	 * this overridden method. It calls this.play() passing itself(this object) to the play method.
	 */
	@Override
	public void actionPerformed(ActionEvent e) 
	{//--------------------------------------------------------------------------------------------
		this.play(this);
	}//--------------------------------------------------------------------------------------------
	
	/**
	 * updates model(board) and the view(GameWindow), then checks for an endgame scenario, if one has
	 * been reached it calls the appropriate methods in the view and model.
	 * @param move (the move to be played)
	 */
	@Override
	public void setMove(Move move) 
	{//--------------------------------------------------------------------------------------------
		this.token=move.getToken();
		view.updateActivePlayer(token+" has moved last");
		board.play(move);
		view.updateBoard(board.getBoard());
		
		if(Rules.isWin(board, move.getToken()))
		{
			//Board.reset();
			view.endGame(move.getToken(), "wins!!!!!");
		}
		
		//if(Rules.isDraw(board, move.getToken()));
		//{
			//Board.reset();
		//	view.endGame(move.getToken(), "wins!!!!!");
		//}
		
		
		System.out.println("last move at: ["+move.getXcoord()+","+ move.getYcoord()+"] by "+move.getToken());
		System.out.println(board.toString());
	}//--------------------------------------------------------------------------------------------
	//*********************************************ENDOF PUBLIC************************************
	
	
	//*********************************************PACKAGE SCOPE***********************************
	//the following methods are mainly for the use of concrete subclasses of 'player', it allows
	//the human and computer player to take turns 
	/**
	 * For use by concrete subclasses of 'player', this method sets the active player to 'x'
	 */
	void setToX()
	{//--------------------------------------------------------------------------------------------
		player = player1;
		view.updateActivePlayer("O has moved last");
	}//--------------------------------------------------------------------------------------------
	
	/**
	 * for use by concrete subclasses of 'player', this method sets the active player to 'x'
	 */
	void setToO()
	{//--------------------------------------------------------------------------------------------
		player = player2;
		view.updateActivePlayer("X has moved last");
	}//--------------------------------------------------------------------------------------------
		
	/** 
	 * gets the button associated with this playerContext
	 * @return CellButton, a subclassed JButton
	 */
	CellButton getButton()
	{//--------------------------------------------------------------------------------------------
		return targetButton;
	}//--------------------------------------------------------------------------------------------
	
	/**
	 * gets the current state of the board
	 * @return Board the current instance of Board.board
	 */
	Board getBoard()
	{//--------------------------------------------------------------------------------------------
		return board;
	}//--------------------------------------------------------------------------------------------
	
	/**
	 * swap the players so that human player is first and cpu second or visa versus.
	 */
	public static void swapPlayers()
	{//--------------------------------------------------------------------------------------------
		Player tmpPlayer1;
		Player tmpPlayer2;
		
		tmpPlayer1 = player1;
		tmpPlayer2 = player2;
		
		player1=tmpPlayer2;
		player2=tmpPlayer1;
	}//--------------------------------------------------------------------------------------------
	
	//*********************************************ENDOF PACKAGE SCOPE*****************************
	
	//*********************************************PRIVATE*****************************************
	/** the view that the controller is updating */
	private GameWindow view;
	/** the CellButton associated with this PlayerContext */
	private CellButton targetButton;
	/** The active player */
	private static Player player;
	/** player 1,the human player */
	private static Player player1 = new HumanPlayer();
	/** player 2, the AI player*/
	private static Player player2 = new CPUPlayer();
	/** the model that this controller is updating */
	private static Board board = new Board();
	/** the token of the current player */
	private static String token;
	//*********************************************ENDOF PRIVATE************************************
}//#########################################ENDOF CLASS############################################
