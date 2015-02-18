//------------------------------------------PACKAGE------------------------------------------------
package ticTacToe.model;
//------------------------------------------ENDOF PACKAGE------------------------------------------
//------------------------------------------IMPORT-------------------------------------------------
import java.util.ArrayList;
//------------------------------------------ENDOF IMPORT-------------------------------------------
/**
 * this class contains methods that calculate whether a game-termination condition (such as achieving
 * a win or a draw) has been reached.
 * @author {}rpheus
 *
 */
	//#########################################CLASS###############################################
public class Rules 
{
	//*********************************************PUBLIC******************************************		
	/**
	 * this method checks to see if a win condition has been met
	 * @param board (an instance of the board to check for win conditions)
	 * @param token (the player token of the active player)
	 * @return boolean (true iff win condition met)
	 */
	public static boolean isWin(Board board, String token)
	{//--------------------------------------------------------------------------------------------
		boolean result = false;
		for(int winLength = 0; winLength<=7; ++winLength)
		{
			//code for debugging
			//System.out.print("3-length "+(winLength+1)+"   |   ");
			//System.out.print(Arrays.deepToString(getThreeLength(winLength))+"   |   ");
			//System.out.print("{"+board.getBoard() [threeLengths[winLength][0][0]] [threeLengths[winLength][0][1]]+"}");
			//System.out.print("{"+board.getBoard() [threeLengths[winLength][1][0]] [threeLengths[winLength][1][1]]+"}");
			//System.out.println("{"+board.getBoard() [threeLengths[winLength][2][0]] [threeLengths[winLength][2][1]]+"}");
			//endof debug code
			
			if(board.getBoard()[threeLengths[winLength][0][0]][threeLengths[winLength][0][1]]==token
			&& board.getBoard()[threeLengths[winLength][1][0]][threeLengths[winLength][1][1]]==token
			&& board.getBoard()[threeLengths[winLength][2][0]][threeLengths[winLength][2][1]]==token)
			{result = true;}
			
			//System.out.println();//debug
		}
		return result;
	}//--------------------------------------------------------------------------------------------
	
	/**
	 * this class checks to see if a draw has been reached
	 * @param board (instance of the board to check for stalemate)
	 * @param token (the player token of the active player)
	 * @return boolean (true iff stalemate)
	 */
	public static boolean isDraw(Board board, String token)
	{//--------------------------------------------------------------------------------------------
		boolean result = true;
		for(int winLength = 0; winLength<=7; ++winLength)
		{	
			for(int cell = 0; cell <=2; ++cell)
			{
				if(board.getBoard()[threeLengths[winLength][cell][0]]
				                   [threeLengths[winLength][cell][1]]==" "
				                &&	isWin(board,token)==false)
				{result = false;}
			}
		}
		return result;		
	}//--------------------------------------------------------------------------------------------
	
	/**
	 * gets a particular 3-length between 0 and 7
	 * @param n integer between 0 and 7
	 * @return int[][] 2-D array representation of a -3length with the data pairs it holds being
	 * 			coordinate values.
	 */
	public static int[][] getThreeLength(int n)
	{//--------------------------------------------------------------------------------------------
		if(n>7){return null;}
		int[][] threeLength = {{1,2},{3,4},{5,6}};//test example
		for(int cell = 0; cell<=2; ++cell)
		{
			threeLength[cell][0] = threeLengths[n][cell][0];
			threeLength[cell][1] = threeLengths[n][cell][1];
		}
		return threeLength;
	}//--------------------------------------------------------------------------------------------
	
	/**
	 * get the value of the opposing token to the one you pass in.
	 * @param token
	 * @return "X" if token=="O", "O" if token=="X"
	 */
	public static String oppositeToken(String token)
	{//--------------------------------------------------------------------------------------------
		String result="";
		if(token.equals("X")){result = "O";}
		if(token.equals("O")){result = "X";}
		else{/*throw exception*/}
		
		return result;
	}//--------------------------------------------------------------------------------------------	
	//*********************************************ENDOF PUBLIC************************************
		
		
	//*********************************************PRIVATE*****************************************
	/**array of 3-lengths representing all winning combinations*/
	private static final int[][][] threeLengths =	{
													{{0,0},{0,1},{0,2}},
													{{0,0},{1,0},{2,0}},
													{{1,0},{1,1},{1,2}},
													{{0,1},{1,1},{2,1}},
													{{2,0},{2,1},{2,2}},
													{{0,2},{1,2},{2,2}},
													{{0,0},{1,1},{2,2}},
													{{2,0},{1,1},{0,2}},
													};	
	//*********************************************ENDOF PRIVATE***********************************
}//#########################################ENDOF CLASS############################################
