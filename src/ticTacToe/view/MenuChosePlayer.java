//------------------------------------------PACKAGE------------------------------------------------
package ticTacToe.view;
//------------------------------------------ENDOF PACKAGE------------------------------------------
//------------------------------------------IMPORT-------------------------------------------------
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import ticTacToe.controller.CPUPlayer;
import ticTacToe.controller.HumanPlayer;
import ticTacToe.controller.Player;
import ticTacToe.controller.PlayerContext;
import ticTacToe.model.Rules;
//------------------------------------------ENDOF IMPORT-------------------------------------------
/**
 * provides both graphical attribute and behaviour for the select player combobox
 * @author {}rpheus
 *
 */
//##########################################CLASS #################################################
public class MenuChosePlayer extends JComboBox<Object> implements ActionListener 
{
	//*********************************************PUBLIC******************************************
	/**
	 * inintialises the combobox
	 */
	public MenuChosePlayer()
	{//--------------------------------------------------------------------------------------------
		for(String player: playerList)
		{
			this.addItem(player);
		}
	}//--------------------------------------------------------------------------------------------
	
	/**
	 * changes the player tokens around when item is selected
	 */
	@Override
	public void actionPerformed(ActionEvent e) 
	{//--------------------------------------------------------------------------------------------
		String userToken = this.getSelectedItem().toString();
		HumanPlayer.setToken(userToken);
		CPUPlayer.setToken(Rules.oppositeToken(userToken));
	}//--------------------------------------------------------------------------------------------
	//*********************************************ENDOF PUBLIC************************************
	
	//*********************************************PRIVATE*****************************************
	/**list of options*/
	String[] playerList = {"X","O"};
	/**place to store token*/
	String userToken;
	/**Human player whos token we shall change*/
	Player humanPlayer = new HumanPlayer();
	/**CPU player who's token we shall change*/
	Player cpuPlayer = new CPUPlayer();
	//*********************************************ENDOF PRIVATE***********************************
}//#########################################ENDOF CLASS############################################
