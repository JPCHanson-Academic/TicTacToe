//------------------------------------------PACKAGE--------------------------------------
package ticTacToe.view;
//------------------------------------------ENDOF PACKAGE--------------------------------

//------------------------------------------IMPORT---------------------------------------
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
//------------------------------------------ENDOF IMPORT---------------------------------

import ticTacToe.controller.PlayerContext;

//##########################################CLASS BOARD PANEL############################
/**
* A BoardPanel object IS a Jpanel, it just specifies a little bit how the JPanel should
* look. A BoardPanel is a Jpanel populated by buttons(CellButton). Most Work is done in 
* the default constructor(and some private helper methods). It does have a method to set
* The text of a button.
* @author {}rpheus
*/
public class BoardPanel extends JPanel 
{
	//***************************************PUBLIC**************************************
	/**
	 * Constructor uses some private helper methods to initialise the BoardPanel object,
	 * the helper methods: defineButtons(), addButtons() and addActionListner() deal with
	 * the buttons. the rest is visual config for the JPanel.
	 */
	public BoardPanel(GameWindow window ) 
	{//--------------------------------------------------------------------------------------------
		BoardPanel.window = window;
		this.setVisible(true);
		this.defineButtons();
		this.addButtons();
		this.setBackground(black);
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		this.setLayout(new GridLayout(3,3,7,7));	
	}//--------------------------------------------------------------------------------------------
	
	/**
	 * register a controller with this panel.
	 * @param controller an instance of the PlayerContext class.
	 */
	public void attachController(PlayerContext controller)
	{//--------------------------------------------------------------------------------------------
		BoardPanel.controller = controller;
	}//--------------------------------------------------------------------------------------------

	/**
	 * this function returns the cellButton at a specified position in the array
	 * @param row the target row
	 * @param column the target column
	 */
	public CellButton getButton(int row, int column)
	{//--------------------------------------------------------------------------------------------
		return buttons[row][column];
	}//--------------------------------------------------------------------------------------------
	
	/**
	 * register button Listeners with correct buttons
	 */
	public void addbuttonListeners()
	{//--------------------------------------------------------------------------------------------
		topLeft.addActionListener(new PlayerContext(window, topLeft));
		topCenter.addActionListener(new PlayerContext(window, topCenter));
		topRight.addActionListener(new PlayerContext(window, topRight));
		middleLeft.addActionListener(new PlayerContext(window, middleLeft));
		middleCenter.addActionListener(new PlayerContext(window, middleCenter));
		middleRight.addActionListener(new PlayerContext(window, middleRight));
		bottomLeft.addActionListener(new PlayerContext(window, bottomLeft));
		bottomCenter.addActionListener(new PlayerContext(window, bottomCenter));
		bottomRight.addActionListener(new PlayerContext(window, bottomRight));
	}//--------------------------------------------------------------------------------------------
	
	/**
	 * remove the button Listeners making the buttons inert.
	 */
	public void removebuttonListeners()
	{//--------------------------------------------------------------------------------------------
		topLeft.removeActionListener(new PlayerContext(window, topLeft));
		topCenter.removeActionListener(new PlayerContext(window, topCenter));
		topRight.removeActionListener(new PlayerContext(window, topRight));
		middleLeft.removeActionListener(new PlayerContext(window, middleLeft));
		middleCenter.removeActionListener(new PlayerContext(window, middleCenter));
		middleRight.removeActionListener(new PlayerContext(window, middleRight));
		bottomLeft.removeActionListener(new PlayerContext(window, bottomLeft));
		bottomCenter.removeActionListener(new PlayerContext(window, bottomCenter));
		bottomRight.removeActionListener(new PlayerContext(window, bottomRight));
	}//--------------------------------------------------------------------------------------------
	//****************************************ENDOF PUBLIC********************************

	
	//****************************************PRIVATE*************************************
	/** java moans if this isnt here */
	private static final long serialVersionUID = 1575240141703690071L;
	/** buttons to populate the board with */
	private static CellButton topLeft, topCenter, topRight, middleLeft, middleCenter;
	/** more buttons to populate the board with */
	private static CellButton middleRight, bottomLeft, bottomCenter, bottomRight;
	/** the colour black */
	private static Color black = new Color(0,0,0);
	/** an array to store the buttons in, makes it easier to index the buttons */
	private static CellButton[][] buttons;
	/**internal reference to the view*/
	private static GameWindow window;
	/**internal reference to the controller*/@SuppressWarnings("unused")
	private static PlayerContext controller;
	
	/**
	 * used by the constructor<br> defines and initialises the JButtons
	 */
	private void defineButtons()
	{//--------------------------------------------DEFINE BUTTONS-------------------------
		buttons = new CellButton[][]
		{{topLeft   =new CellButton(0,0),topCenter   =new CellButton(0,1)   ,topRight=new CellButton(0,2)},
		 {middleLeft=new CellButton(1,0),middleCenter=new CellButton(1,1),middleRight=new CellButton(1,2)},
		 {bottomLeft=new CellButton(2,0),bottomCenter=new CellButton(2,1),bottomRight=new CellButton(2,2)}};
	}//--------------------------------------------ENDOF DEFINE BUTTONS-------------------
	
	/**
	 * used by constructor<br> adds the buttons to the JPanel
	 */
	private void addButtons()
	{//--------------------------------------------ADD BUTTONS----------------------------
		this.add(topLeft);   this.add(topCenter);   this.add(topRight);
		this.add(middleLeft);this.add(middleCenter);this.add(middleRight);
		this.add(bottomLeft);this.add(bottomCenter);this.add(bottomRight);	
	}//--------------------------------------------ENDOF ADD BUTTONS----------------------
	//****************************************ENDOF PRIVATE*******************************
}//###########################################ENDOF CLASS#################################