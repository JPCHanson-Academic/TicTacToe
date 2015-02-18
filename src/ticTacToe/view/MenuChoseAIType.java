//------------------------------------------PACKAGE------------------------------------------------
package ticTacToe.view;
//------------------------------------------ENDOF PACKAGE------------------------------------------
//------------------------------------------IMPORT-------------------------------------------------
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import ticTacToe.controller.CPUPlayer;
import ticTacToe.model.MiniMaxEngine;
import ticTacToe.model.RandomEngine;
//------------------------------------------ENDOF IMPORT-------------------------------------------
/**
 * class provides both the graphical attributes and the behaviour of the comboBox responsible for 
 * chosing the type of AI to play.
 * @author {}rpheus
 *
 */
//##########################################CLASS #################################################
public class MenuChoseAIType extends JComboBox<Object> implements ActionListener
{
	//*********************************************PUBLIC******************************************
	/**
	 * default constructor initialises the list to chose from
	 */
	public MenuChoseAIType()
	{//--------------------------------------------------------------------------------------------
		this.setName("AI Type");
		for(String gameEngine: gameEngines)
		{
			this.addItem(gameEngine);
		}
	}//--------------------------------------------------------------------------------------------
	
	/**
	 * provides behaviour for the combo box by setting the game engine to the appropriate one from
	 * the list
	 */
	@Override
	public void actionPerformed(ActionEvent e) 
	{//--------------------------------------------------------------------------------------------
		if (this.getSelectedItem().toString() == "MiniMax(Broken)")
		{
			CPUPlayer.setGameEngine(new MiniMaxEngine());
			System.out.println("this algorithm is currently broken, "
					+ "I suspect the problem is in the evaluation function\n"
					+ " as it appears to be calculating an identical score "
					+ "for all moves considered by it.");
		}

		if (this.getSelectedItem().toString() == "Random")
		{
			CPUPlayer.setGameEngine(new RandomEngine());
		}
	}//--------------------------------------------------------------------------------------------
	//*********************************************ENDOF PUBLIC************************************
	
	//*********************************************PRIVATE*****************************************
	/**list of game engines to chose from*/
	private static String[] gameEngines = 	{
											"MiniMax(Broken)",//miniMax Player
											"Random",//random Player
											};
	//*********************************************ENDOF PRIVATE***********************************	
}//#########################################ENDOF CLASS############################################