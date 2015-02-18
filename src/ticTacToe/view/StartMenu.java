//------------------------------------------PACKAGE--------------------------------------
package ticTacToe.view;
//------------------------------------------ENDOF PACKAGE--------------------------------
//------------------------------------------IMPORT---------------------------------------
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
//------------------------------------------ENDOF IMPORT---------------------------------
/**
 * This class defines the sideBar of the gameWindow, it is just a container for two buttons and
 * two combo boxes. this provides the graphical attributes for the start menu.
 * @author {}rpheus
 *
 */
//##########################################CLASS #################################################
public class StartMenu extends JPanel
{
	//*********************************************PUBLIC******************************************
	/**
	 * initialises two buttons and two combo boxes.
	 * @param view
	 */
	public StartMenu(GameWindow view)
	{//--------------------------------------------------------------------------------------------
		this.view = view;
		this.defineButtons();
		this.addButtons();
		this.addActionListeners();
		this.setName("Start Menu");
		this.setVisible(false);
	}//--------------------------------------------------------------------------------------------
	//*********************************************ENDOF PUBLIC************************************
	
	//*********************************************PRIVATE*****************************************
	/**the view that this belongs to*/
	private static GameWindow view;
	/**start button*/
	private static MenuStartButton start;
	/** quit button*/
	private static MenuQuitGame quit;
	/**player select combo box*/
	private static MenuChosePlayer choseToken;
	/**chose AI type combo box*/
	private static MenuChoseAIType choseAIType;
	
	/**
	 * used by the constructor<br> defines and initialises the JButtons
	 */
	private void defineButtons()
	{//--------------------------------------------DEFINE BUTTONS-------------------------
		start = new MenuStartButton(view,"Start Game");
		choseToken = new MenuChosePlayer();
		choseAIType = new MenuChoseAIType();
		quit = new MenuQuitGame("Quit");
	}//--------------------------------------------ENDOF DEFINE BUTTONS-------------------
	
	/**
	 * used by constructor<br> adds the buttons to the JPanel
	 */
	private void addButtons()
	{//--------------------------------------------ADD BUTTONS----------------------------
		this.add(start);
		this.add(choseToken);
		this.add(choseAIType);
		this.add(quit);
	}//--------------------------------------------ENDOF ADD BUTTONS----------------------
	
	/**
	 * add action listeners for the components
	 */
	private void addActionListeners()
	{//--------------------------------------------------------------------------------------------
		start.addActionListener(start);
		quit.addActionListener(quit);
		choseToken.addActionListener(choseToken);
		choseAIType.addActionListener(choseAIType);
	}//--------------------------------------------------------------------------------------------
	//*********************************************ENDOF PRIVATE***********************************	
}//#########################################ENDOF CLASS############################################
