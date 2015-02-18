//------------------------------------------PACKAGE--------------------------------------
package ticTacToe.view;
//------------------------------------------ENDOF PACKAGE--------------------------------

//------------------------------------------IMPORT---------------------------------------
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
//------------------------------------------ENDOF IMPORT---------------------------------

//##########################################CLASS WINDOW CLOSE###########################
/**
* Window close behaviour
* @author {}rpheus
*/
public class WindowClose extends WindowAdapter 
{
	//***************************************PUBLIC**************************************
	/**
	 * inherited from superClass, use this to define behaviour when the window is closed
	 * by using the window decoration.
	 */
	public void windowClosing(WindowEvent e)
	{
		System.exit(0);
	}
	//****************************************ENDOF PUBLIC*******************************
}//###########################################ENDOF CLASS################################
