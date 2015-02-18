//------------------------------------------PACKAGE------------------------------------------------
package ticTacToe.model;
//------------------------------------------ENDOF PACKAGE------------------------------------------
/**
 * This class tries to encapsulate the essence of a move for the noughts and crosses game. It has a
 * X-coordinate a Y-coordinate and a player token. These are set on creation of a move object. This
 * class provides getter and setter methods for the X-coordinate, Y-coordinate, player token and
 * score.
 * 
 * @author {}rpheus
 */
//##########################################CLASS #################################################
public class Move 
{
	//*********************************************PUBLIC******************************************
	/**
	 * default constructor, initialises token to null, score to 0, and leaves the x and y coord
	 * uninitialised.
	 */
	public Move()
	{//--------------------------------------------------------------------------------------------
		this.playerToken = null;
		this.score = 0;
	}//--------------------------------------------------------------------------------------------
	
	/**
	 * initialises the Move object with an X coordinate a Y-Coordinate and a player token
	 * @param x X-coordinate
	 * @param y Y-coordinate
	 */
	public Move(int x, int y, String token)
	{//--------------------------------------------------------------------------------------------
		this.xCoordinate = x;
		this.yCoordinate = y;
		this.playerToken = token;
		this.score = 0;
	}//--------------------------------------------------------------------------------------------
	
	/**
	 * gets the Y-Coordinate
	 * @return int representing the Y-Coordinate
	 */
	public int getYcoord()
	{//--------------------------------------------------------------------------------------------
		return yCoordinate;
	}//--------------------------------------------------------------------------------------------
	
	/**
	 * Set the Y coordinate
	 * @param newYcoord new Y coordinate
	 */
	public void setYcoord(int newYcoord)
	{//--------------------------------------------------------------------------------------------
		this.yCoordinate = newYcoord;
	}//--------------------------------------------------------------------------------------------
	
	/**
	 * gets the X-Coordinate
	 * @return int representing the X-Coordinate
	 */
	public int getXcoord()
	{//--------------------------------------------------------------------------------------------
		return xCoordinate;
	}//--------------------------------------------------------------------------------------------
	
	/**
	 * Set the X coordinate
	 * @param newXcoord new X coordinate
	 */
	public void setXcoord(int newXcoord)
	{//--------------------------------------------------------------------------------------------
		this.xCoordinate = newXcoord;
	}//--------------------------------------------------------------------------------------------
	
	/**
	 * gets the Token associated with this move
	 * @return Token of the player who made the move
	 */
	public String getToken()
	{//--------------------------------------------------------------------------------------------
		return playerToken;
	}//--------------------------------------------------------------------------------------------
	
	/**
	 * Set tje token associated with this move
	 * @param newToken the new player token to be adopted
	 */
	public void setToken(String newToken)
	{//--------------------------------------------------------------------------------------------
		this.playerToken = newToken;
	}//--------------------------------------------------------------------------------------------
	
	/**
	 * get the value of the score
	 * @return int the value of the score
	 */
	public int getScore()
	{//--------------------------------------------------------------------------------------------
		return score;
	}//--------------------------------------------------------------------------------------------
	
	/**
	 * Set the value of the score
	 * @param newScore the new value of 'score' to set
	 */
	public void setScore(int newScore)
	{//--------------------------------------------------------------------------------------------
		this.score = newScore;
	}//--------------------------------------------------------------------------------------------
	//**********************************************ENDOF PUBLIC***********************************

	
	//**********************************************PRIVATE****************************************
	/** represents the X-Coordinate*/
	private int xCoordinate;
	/** represents the Y-Coordinate*/
	private int yCoordinate;
	/** token from the player making the move */
	private String playerToken;
	/** the score associated with the move*/
	private int score;
	//**********************************************ENDOF PRIVATE**********************************
}//#########################################ENDOF CLASS############################################
