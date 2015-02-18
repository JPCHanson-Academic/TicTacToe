//------------------------------------------PACKAGE------------------------------------------------
package ticTacToe.model;
import java.util.ArrayList;
//------------------------------------------ENDOF PACKAGE------------------------------------------
//------------------------------------------IMPORT-------------------------------------------------
import java.util.Arrays;
//------------------------------------------ENDOF IMPORT-------------------------------------------
/**
 * this is the entry point into the model of the tic tac toe game. It provides methods to manipulate
 * the board and play the game of ticTacToe.
 * @author {}rpheus
 *
 */
	//#########################################CLASS###############################################
public class Board 
{
	//*********************************************PUBLIC******************************************
	/**
	 * sets a cell of the board to the value of the token carried by the move
	 * @param move (contains the coords and token for the move to be played)
	 */
	public void play(Move move)//make return type 
	{//--------------------------------------------------------------------------------------------
		Board.move = move;
		board[move.getXcoord()][move.getYcoord()] = move.getToken();
		
		//check to see if win or draw
		if(Rules.isWin(this, move.getToken())==true)
		{System.out.println("you win "+move.getToken()+"!!!");}
		else if (Rules.isDraw(this, move.getToken())==true)
		{System.out.println("its a draw");}
		
		//Board.token = move.getToken();
	}//--------------------------------------------------------------------------------------------
	
	/**
	 * gets the state at coordinates (i,j) on the board.
	 * @param i (row of the board)
	 * @param j (column of the board)
	 * @return String (state of that particular cell)
	 */
	public String getCell(int i, int j)
	{//--------------------------------------------------------------------------------------------
		return board[i][j];
	}//--------------------------------------------------------------------------------------------
	
	/**
	 * return a String representation of the board
	 * @return String (representation of the board)
	 */
	public String toString()
	{//--------------------------------------------------------------------------------------------		
		return Arrays.deepToString(board);
	}//--------------------------------------------------------------------------------------------
	
	/**
	 * get the whole board
	 * @return String[][] (2-D array representation of the board)
	 */
	public static String[][] getBoard()
	{//--------------------------------------------------------------------------------------------		
		return board;
	}//--------------------------------------------------------------------------------------------
	
	/**
	 * provides an arrayList of moves still available on the board
	 * @return ArrayList conatining all legal available 'Move's
	 */
	public static ArrayList<Move> getAvailableMoves()
	{//--------------------------------------------------------------------------------------------
		ArrayList<Move> result = new ArrayList<Move>();
		for(int row = 0; row <= 2; ++row)
		{
			for (int column = 0; column <= 2; ++column)
			{
				if(board[row][column] == " ")
				{
					Move availableMove = new Move(row,column,Board.token);
					result.add(availableMove);
				}
			}
		}
		return result;
	}//--------------------------------------------------------------------------------------------
	
	/**
	 * reInitialises the board.
	 */
	public static void reset()
	{//--------------------------------------------------------------------------------------------
		for(int row=0;row<=2;++row)
		{
			for(int column = 0; column<=2; ++column)
			{
				board[row][column] = " ";
			}
		}
	}//--------------------------------------------------------------------------------------------
	//*********************************************ENDOF PUBLIC************************************
	
	
	//*********************************************PRIVATE*****************************************
	/** the internal representation of the board */
	private static String[][] board = new String[][]{{" " , " " , " "},
													 {" " , " " , " "},
													 {" " , " " , " "}};
	/** move to be played */@SuppressWarnings("unused")
	private static Move move;
	/** the rules for terminating the game */@SuppressWarnings("unused")
	private static Rules rules;
	/** token of the current player */
	private static String token="X";
	//*********************************************ENDOF PRIVATE***********************************
}//#########################################ENDOF CLASS############################################
