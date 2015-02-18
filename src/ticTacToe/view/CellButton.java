//------------------------------------------PACKAGE--------------------------------------
package ticTacToe.view;
//------------------------------------------ENDOF PACKAGE--------------------------------

//------------------------------------------IMPORT---------------------------------------
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
//------------------------------------------ENDOF IMPORT---------------------------------

//##########################################CLASS CELLBUTTON#############################
/**
 * This class contains visual configuration of the JButtons contained in the BoardPanel
 * class. everything is contained in the constructor and some private vars. To change 
 * the config, change/add method calls in the constructor.
 * @author {}rpheus
 */
public class CellButton extends JButton 
{
	//***************************************PUBLIC**************************************
	/**
	 * Everything is set from this constructor, its a constructor....it initialises stuff!
	 * @param text string to be displayed on button 
	 */
	public CellButton(int i, int j) //-------------CTOR(string)--------------------------
	{
		this.coords = new int[]{i,j};
		this.setPreferredSize(size);
		this.setBackground(bckGrnd);
		this.setForeground(frGrnd);
		this.setFocusable(false);
	}//-------------------------------------------ENDOF CTOR(string)----------------------
	
	/**
	 * get the coordinates of this button
	 * @return int[] array representation of button coords {x,y}
	 */
	public int[] getCoords()
	{//--------------------------------------------------------------------------------------------
		return coords;
	}//--------------------------------------------------------------------------------------------
	//****************************************ENDOF PUBLIC********************************
	
	
	
	//****************************************PRIVATE*************************************
	/** java moans if i dont put this in */
	private static final long serialVersionUID = -7352189898617907443L;
	/** represents the size */
	private Dimension size = new Dimension(98,98);
	/** represents the Background Colour */
	private Color bckGrnd = new Color(60,60,60);
	/** represents the Foreground Colour */
	private Color frGrnd = new Color(200,200,200);
	/**Coordinates of this button*/
	private int[] coords;
	//****************************************ENDOF PRIVATE*******************************
}//###########################################ENDOF CLASS#################################
