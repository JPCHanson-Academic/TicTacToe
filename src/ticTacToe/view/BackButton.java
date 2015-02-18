//------------------------------------------------PACKAGE------------------------------------------
package ticTacToe.view;
//------------------------------------------------ENDOF PACKAGE------------------------------------

//------------------------------------------------IMPORT-------------------------------------------
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import ticTacToe.model.Board;
//------------------------------------------------ENDOF IMPORT-------------------------------------
/**
 * this class provides both the graphical properties of the back button as well as the logic for
 * when the button is pressed.
 * @author {}rpheus
 *
 */
//##########################################CLASS BACK BUTTON######################################
public class BackButton extends JButton implements ActionListener 
{
	//*************************************************PUBLIC**************************************
	/**
	 * sets the text of the button, and the view that it refers to.
	 * @param view a reference to the view calling it
	 * @param text the button text
	 */
	public BackButton(GameWindow view, String text)
	{//--------------------------------------------------------------------------------------------
		this.view= view;
		this.setText(text);
	}//--------------------------------------------------------------------------------------------
	
	/**
	 * closes the program<br>
	 * originally this was going to take you back to the main menu so that you could
	 * play again if you wish but somethings broken in the turn taking gubbins.
	 */
	@Override
	public void actionPerformed(ActionEvent e) 
	{//--------------------------------------------------------------------------------------------
		view.disableBoard();
		view.enableMenu();

		Board.reset();
		view.updateBoard(Board.getBoard());
		System.exit(0);
	}//--------------------------------------------------------------------------------------------
	//**************************************************ENDOF PUBLIC*******************************
	
	
	//**************************************************PRIVATE************************************
	/** 
	 * internal reference to the view, for the original purpose of taking you back to the main 
	 * menu.
	 */
	private static GameWindow view;
	//**************************************************ENDOF PRIVATE******************************
}//##########################################ENDOF CLASS BACK BUTTON###############################