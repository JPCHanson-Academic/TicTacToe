package ticTacToe.model;

import java.util.Arrays;

public class MiniMaxTest {

	static MiniMaxEngine gameEngine = new MiniMaxEngine();
	static Board board = new Board();
	static String cpuToken = "O";
	static String humanToken = "X";
	static Move bestMove;
	
	public static void main(String[] args) 
	{	
		System.out.println("start");
		bestMove = gameEngine.generateMove(board, cpuToken);
		board.play(bestMove);
		display();
		
		bestMove = gameEngine.generateMove(board, humanToken);
		board.play(bestMove);
		display();
		/*
		bestMove = gameEngine.generateMove(board, cpuToken);
		board.play(bestMove);
		display();
		
		bestMove = gameEngine.generateMove(board, humanToken);
		board.play(bestMove);
		display();
		*/
			
	}
	
	public static void display()
	{
		System.out.println();
		System.out.println("state of board: "+Arrays.deepToString(board.getBoard()));
		System.out.print("available moves: ");
		for(Move availableMove: Board.getAvailableMoves())
		{
			System.out.print("{"+availableMove.getToken()+",["+availableMove.getXcoord()+","+availableMove.getYcoord()+"]} ");	
		}
		System.out.println();
		System.out.println("chosen move:     "+"{"+bestMove.getToken()+",["+bestMove.getXcoord()+","+bestMove.getYcoord()+"]}");

	}

}
