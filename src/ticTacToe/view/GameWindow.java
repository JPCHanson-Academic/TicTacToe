//------------------------------------------PACKAGE--------------------------------------
package ticTacToe.view;
//------------------------------------------ENDOF PACKAGE--------------------------------

//------------------------------------------IMPORT---------------------------------------
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

import ticTacToe.controller.PlayerContext;

//##########################################CLASS GAME WINDOW############################
/**
* This class draws the main GameWindow, with the board and the state passed to it by the
* controller. This class acts as the main access to the 'view' in an MVC type setup. it
* provides all the function to manipulate the view.
* @author {}rpheus
*/
public class GameWindow extends JFrame 
{
	//***************************************PUBLIC**************************************
	/**
	 * default constructor sets some basic properties of itself, then adds its components
	 */
	public GameWindow()
	{//--------------------------------------------CTOR()--------------------------------
		startMenu = new StartMenu(this);
		board = new BoardPanel(this);
		boardSideBar = new SideBar(this);
		this.frameProperties();
		this.frameComponents();
	}//--------------------------------------------ENDOF CTOR()--------------------------
	
	/**
	 * enable the start menu
	 */
	public void enableMenu()
	{//--------------------------------------------------------------------------------------------
		startMenu.setEnabled(true);
		startMenu.setVisible(true);
	}//--------------------------------------------------------------------------------------------
	
	/**
	 * disable the start menu
	 */
	public void disableMenu()
	{//--------------------------------------------------------------------------------------------
		startMenu.setVisible(false);
		startMenu.setEnabled(false);
	}//--------------------------------------------------------------------------------------------
	
	/**
	 * register a controller with this view
	 * @param controller PlayerContext representing the controller in an MVC style setup
	 */
	public void attachController(PlayerContext controller)
	{//--------------------------------------------------------------------------------------------
		board.attachController(controller);
	}//--------------------------------------------------------------------------------------------
	
	/**
	 * enable the board
	 */
	public void enableBoard()
	{//--------------------------------------------------------------------------------------------
		boardSideBar.setEnabled(true);
		boardSideBar.setVisible(true);
		board.setEnabled(true);
		board.setVisible(true);
		board.addbuttonListeners();
	}//--------------------------------------------------------------------------------------------
	
	/**
	 * disable the board
	 */
	public void disableBoard()
	{//--------------------------------------------------------------------------------------------
		board.removebuttonListeners();
		boardSideBar.setVisible(false);
		boardSideBar.setEnabled(false);
		board.setVisible(false);
		board.setEnabled(false);
		
	}//--------------------------------------------------------------------------------------------
	
	/**
	 * switch to end-game mode
	 * @param token of the player who caused the end-game
	 * @param state the type of end-game
	 */
	public void endGame(String token,String state)
	{//--------------------------------------------------------------------------------------------
		board.setVisible(false);
		boardSideBar.swapLabel(token+" "+state);
		contentPane.remove(board);
		//contentPane.add(new JLabel(token+" "+state+""));
	}//--------------------------------------------------------------------------------------------
	
	/**
	 * updates the BoardPanel
	 * @param board a string array containing letters representing the player tokens
	 */
	public void updateBoard(String[][] boardView)
	{//--------------------------------------------------------------------------------------------
		for(int row = 0; row <= 2; ++row)
		{
			for(int column = 0; column <=2; column++)
			{
				board.getButton(row,column).setText(boardView[row][column]);
			}
		}
	}//--------------------------------------------------------------------------------------------
	
	/**
	 * update the active player
	 * @param token the token of the new active player
	 */
	public void updateActivePlayer(String token)
	{//--------------------------------------------------------------------------------------------
		boardSideBar.setActivePlayer(token);
	}//--------------------------------------------------------------------------------------------
	//****************************************ENDOF PUBLIC*******************************

	
	//****************************************PRIVATE************************************
	//---------------------------------------------VARS--------------------------------------------
	/** java moans if this isnt here */
	private static final long serialVersionUID = 6764144041303956911L;
	/** window title */
	private static final String title = "Noughts & Crosses";
	/** starting location for window */
    private static final int locX = 300,locY = 250;
    /** background window color */
    private static final Color black = new Color(0,0,0);
    /** for storing an instance of BoardPanel component */
    private static  BoardPanel board;
    /** reference to sideBar */
    private static SideBar boardSideBar;
    /**reference to start menu*/
    private static StartMenu startMenu;
    /**reference to component container*/
    private Container contentPane;
    //---------------------------------------------ENDOF VARS--------------------------------------
    
    /**
	 * used by constructor<br>
	 * contains all the attributes that customise gameWindow
	 */
	private void frameProperties()
	{//--------------------------------------------FRAME PROPERTIES----------------------
		this.setTitle(title);
		this.setLocation(locX,locY);
		this.setResizable(false);
		this.setVisible(true);
		this.setBackground(black);
		this.setLayout(new FlowLayout());
	}//--------------------------------------------ENDOF FRAME PROPERTIES----------------
    
	/**
	 * used by constructor<br>
	 * contains all the components that make up the GameWindow
	 */
	private void frameComponents()
	{//--------------------------------------------FRAME COMPONENTS----------------------
		addWindowListener(new WindowClose());
		contentPane  = getContentPane();
		contentPane.add(board);	
		contentPane.add(boardSideBar);
		contentPane.add(startMenu);
		this.pack();
	}//--------------------------------------------ENDOF FRAME COMPONENTS----------------
	//****************************************ENDOF PRIVATE******************************
}//###########################################ENDOF CLASS#################################