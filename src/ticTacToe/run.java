//------------------------------------------PACKAGE------------------------------------------------
package ticTacToe;
//------------------------------------------ENDOF PACKAGE------------------------------------------
//------------------------------------------IMPORT-------------------------------------------------
import ticTacToe.controller.PlayerContext;
import ticTacToe.model.Board;
import ticTacToe.view.CellButton;
import ticTacToe.view.GameWindow;
//------------------------------------------ENDOF IMPORT-------------------------------------------

public class run 
{

	private static CellButton button = null;
	private static GameWindow gameView = new GameWindow();
	private static PlayerContext controller = new PlayerContext(gameView, button);
	private static Board model = new Board();
	
	public static void main(String[] args) 
	{
		gameView.disableBoard();
		gameView.enableMenu();
	}
}
