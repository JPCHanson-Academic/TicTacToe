//------------------------------------------PACKAGE------------------------------------------------
package ticTacToe.view;
//------------------------------------------ENDOF PACKAGE------------------------------------------
//------------------------------------------IMPORT-------------------------------------------------
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
//------------------------------------------ENDOF IMPORT-------------------------------------------
/**
 * this class provides both the graphical attributes and the behaviour for the start game button in
 * the main menu.
 * @author {}rpheus
 *
 */
//##########################################CLASS #################################################
public class MenuStartButton extends JButton implements ActionListener 
{
	//*********************************************PUBLIC******************************************
	/**
	 * initialises the start button with some text and a view to operate on
	 * @param view the view to modify
	 * @param text the text to display on the button
	 */
	public MenuStartButton(GameWindow view, String text)
	{//--------------------------------------------------------------------------------------------
		this.view= view;
		this.setText(text);
	}//--------------------------------------------------------------------------------------------
	
	/**
	 * when this button isclicked the main menu is disabled and the board view is enabled
	 */
	@Override
	public void actionPerformed(ActionEvent e) 
	{//--------------------------------------------------------------------------------------------
	view.disableMenu();
	view.enableBoard();
	}//--------------------------------------------------------------------------------------------
	//*********************************************ENDOF PUBLIC************************************
	
	//*********************************************PRIVATE*****************************************
	/**a reference to the view that this button operates on*/
	private static GameWindow view;
	//*********************************************ENDOF PRIVATE***********************************
}//#########################################ENDOF CLASS############################################
