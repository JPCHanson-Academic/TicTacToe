//------------------------------------------PACKAGE------------------------------------------------
package ticTacToe.model;
//------------------------------------------ENDOF PACKAGE------------------------------------------
//------------------------------------------IMPORT-------------------------------------------------
import java.util.ArrayList;
//------------------------------------------ENDOF IMPORT-------------------------------------------
/**
 * this class generates moves by using an implementation of the minimax algorithm. Unfortunately this
 * implementation is broken and currently useless.
 * @author {}rpheus
 */
//##########################################CLASS #################################################
public class MiniMaxEngine implements GameEngine 
{
	//*********************************************PUBLIC******************************************
	/**
	 * this method generates a 'Move' object based on the current state of the board and the token 
	 * of the player requesting the move.
	 * @param board the current state of the board
	 * @param token the token for the player requesting the move
	 * @return Move (a 'Move' object)
	 */
	@Override
	public Move generateMove(Board board, String token) 
	{//--------------------------------------------------------------------------------------------
		MiniMaxEngine.cpuToken = token;
		MiniMaxEngine.humanToken = Rules.oppositeToken(cpuToken);
		//System.out.println(humanToken);
		MiniMaxEngine.board = board;
		
		//System.out.println();
		//System.out.println("evaluationFn score: "+evaluationFunction(board, token));
		//System.out.println(this.miniMax(4, cpuToken).getXcoord()+","+this.miniMax(4, cpuToken).getYcoord()+","+this.miniMax(4, cpuToken).getToken());
		Move bestMove = miniMax(4,cpuToken);
		bestMove.setToken(token);
		return bestMove;
	}//--------------------------------------------------------------------------------------------
	//*********************************************ENDOF PUBLIC************************************
	
	
	//*********************************************PRIVATE*****************************************
	//--------------------------------------------------------------------------------------------
	/**tokens for AI and Human*/
	private static String cpuToken, humanToken;
	/**Internal reference to the board*/
	private static Board board;
	//--------------------------------------------------------------------------------------------
	
	/**
	 * implementation of the miniMax algorithm takes a lookahead value(depth) and a player token.
	 * this generates a move that is then passed to generateMove().<br><br>
	 * 
	 * the minimax algorithm is an algorithm that evaluates all available moves of a particular 
	 * board-state by recursing over all available moves and scoring them based on who's turn it
	 * is, chosing the minimum score when the AI is playing and the maximum score when the human 
	 * is playing. 
	 * @param depth the number of moves to look ahead
	 * @param token the token of the player requesting the move
	 * @return Move the generated move.
	 */
	private Move miniMax(int depth, String token)
	{//--------------------------------------------------------------------------------------------
		Move result= new Move(-999,-999, token);
		ArrayList<Move> availableMoves = Board.getAvailableMoves();
		
		if(Rules.isWin(board, token) || depth == 0)
		{
			System.out.print(evaluationFunctionCPU(board, token)-(evaluationFunctionHuman(board, token)));
			result.setScore((evaluationFunctionCPU(board, token)));//-(evaluationFunctionHuman(board, token)));
			
			return result;
		}
		
		if(token == cpuToken)
		{
			result.setScore(-1000000);
			
			//for each available move
			for(Move availableMove: availableMoves)
			{
				availableMove.setScore(miniMax(depth-1, humanToken).getScore());
				if(availableMove.getScore()>result.getScore())
				{result.setXcoord(availableMove.getXcoord());
				result.setYcoord(availableMove.getYcoord());} //= availableMove;}
				//System.out.println("CPU players predicted move is:"+result.getXcoord()+","+result.getYcoord());
			}
			//System.out.println("CPU players predicted move is:"+result.getXcoord()+","+result.getYcoord());
			return result;
		}
		
		if(token == humanToken)
		{
			result.setScore(+1000000);
			
			//for each available move
			for(Move availableMove: availableMoves)
			{
				availableMove.setScore(miniMax(depth-1, cpuToken).getScore());
				if(availableMove.getScore()<result.getScore())//{result = availableMove;}
				{result.setXcoord(availableMove.getXcoord());
				result.setYcoord(availableMove.getYcoord());}
				//System.out.println("human players predicted move is:"+result.getXcoord()+","+result.getYcoord());
			}
			//System.out.println("human players predicted move is:"+result.getXcoord()+","+result.getYcoord());
			return result;
		}
		return result;
	}//--------------------------------------------------------------------------------------------
	
	/**
	 * this method evaluates a board-state based on whether a 3-length has been achieved, how many
	 * 2-lengths have been occupied and the number of 3-length that have not been blocked off. This
	 * method and the human version make up the full evaluation function.
	 * @param board board-state to be analysed
	 * @param token the token of the player who's move is being evaluated
	 * @return int representation of the score
	 */
	private static int evaluationFunctionCPU(Board board, String token)
	{//--------------------------------------------------------------------------------------------
		int result=0;
		//is a 3-length occupied
		if(Rules.isWin(board, token))
		{result = result+10000;}
		
		//number of 2-lengths occupied
		for(int n = 0; n <=7; ++n)
		{
			int[][] threeLength = Rules.getThreeLength(n);
		
			if((board.getBoard() [threeLength[0][0]] [threeLength[0][1]] ==token
			&&  board.getBoard() [threeLength[1][0]] [threeLength[1][1]] ==token)
										||
			   (board.getBoard() [threeLength[1][0]] [threeLength[1][1]] ==token
			&&  board.getBoard() [threeLength[2][0]] [threeLength[2][1]] ==token))
		{result = result+1000;}
		}
		
		//number of 3-Lengths still available
		for(int n = 0; n <=7; ++n)
		{
			int[][] threeLength = Rules.getThreeLength(n);
		
			if((board.getBoard()[threeLength[0][0]][threeLength[0][1]]==token
					|| board.getBoard()[threeLength[0][0]][threeLength[0][1]]==" ")
			 
			&& (board.getBoard()[threeLength[1][0]][threeLength[1][1]]==token
					|| board.getBoard()[threeLength[1][0]][threeLength[1][1]]==" ")
					
			&& (board.getBoard()[threeLength[2][0]][threeLength[2][1]]==token
					|| board.getBoard()[threeLength[2][0]][threeLength[2][1]]==" "))
			
				{result = result+10;}
		}
		return result;
	}//--------------------------------------------------------------------------------------------
	
	/**
	 * the same function as above called with the opposite token,together these two methods make up
	 * the full evaluation function.
	 * @param board board-state to be evaluated
	 * @param token the token of the opposing player
	 * @return int representation of score
	 */
	private int evaluationFunctionHuman(Board board, String token)
	{//--------------------------------------------------------------------------------------------
		int result = evaluationFunctionCPU(board, Rules.oppositeToken(token));
		return result;
	}//--------------------------------------------------------------------------------------------
	//*********************************************ENDOF PRIVATE***********************************
	
}//#########################################ENDOF CLASS############################################
