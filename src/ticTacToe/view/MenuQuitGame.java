//------------------------------------------PACKAGE------------------------------------------------
package ticTacToe.view;
//------------------------------------------ENDOF PACKAGE------------------------------------------
//------------------------------------------IMPORT-------------------------------------------------
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
//------------------------------------------ENDOF IMPORT-------------------------------------------
/**
 * this class provides both the graphical attributes and behaviour for a quit game button.
 * @author {}rpheus
 *
 */
//##########################################CLASS #################################################
public class MenuQuitGame extends JButton implements ActionListener 
{
	//*********************************************PUBLIC******************************************
	/**
	 * initialises the button and sets the text of the button to 'text'
	 * @param text the text to set the button text to.
	 */
	public MenuQuitGame(String text)
	{//--------------------------------------------------------------------------------------------
		this.setText(text);
	}//--------------------------------------------------------------------------------------------
	
	/**
	 * exit when button pressed
	 */
	@Override
	public void actionPerformed(ActionEvent e) 
	{//--------------------------------------------------------------------------------------------
		System.exit(0);

	}//--------------------------------------------------------------------------------------------
	//*********************************************ENDOF PUBLIC************************************
}//#########################################ENDOF CLASS############################################