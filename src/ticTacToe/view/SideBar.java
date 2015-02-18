//------------------------------------------------PACKAGE------------------------------------------
package ticTacToe.view;
//------------------------------------------------ENDOF PACKAGE------------------------------------
//------------------------------------------------IMPORT-------------------------------------------
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
//------------------------------------------------ENDOF IMPORT-------------------------------------
/**
 * This class is the sideBar during the game, it provides two JLabels (one as a player indicator
 *  and one as an endgame indicator; and methods for for manipulating them. 
 * @author {}rpheus
 *
 */
//##########################################CLASS SIDE BAR#########################################
public class SideBar extends JPanel 
{
	//*************************************************PUBLIC**************************************
	/**
	 * Takes a GameWindow(view) and creates the two labels and button
	 * @param view
	 */
	public SideBar(GameWindow view)
	{//--------------------------------------------------------------------------------------------
		activePlayer = new JLabel("X to move              ");
		endGameMessage = new JLabel();
		backButton = new BackButton(view, "quit");
		backButton.addActionListener(backButton);
	    setLayout(new GridLayout(2,1,100,250)); 
	    add(activePlayer);
	    add(endGameMessage);
	    endGameMessage.setVisible(false);
	    add(backButton);
	    this.setVisible(true);
	}//--------------------------------------------------------------------------------------------
	
	/**
	 * sets the text of the activePlayer JLabel to 'token'
	 * @param token the text to set the label to.
	 */
	public void setActivePlayer(String token)
	{//--------------------------------------------------------------------------------------------
		activePlayer.setText(token);
	}//--------------------------------------------------------------------------------------------
	
	/**
	 * Swaps the activePlayer label for the endgame label, and sets the label text to 'text'
	 * @param text the text to set the label to.
	 */
	public void swapLabel(String text)
	{//--------------------------------------------------------------------------------------------
		activePlayer.setVisible(false);
		activePlayer.setEnabled(false);
		endGameMessage.setText(text);
		endGameMessage.setVisible(true);
		
	}//--------------------------------------------------------------------------------------------
	//**************************************************ENDOF PUBLIC*******************************
	
	
	//**************************************************PRIVATE************************************
	/**player indicator JLabel*/
	private static JLabel activePlayer;
	/**back-button button*/
	private static BackButton backButton;
	/**end-game indicator JLabel*/
	private static JLabel endGameMessage;
	//**************************************************ENDOF PRIVATE******************************
}//##########################################ENDOF CLASS SIDE BAR##################################