import java.util.Scanner;
import java.util.Locale;

public class GameBoard {
	private String[][] gameBoard = {{".",".","."},{".",".","."},{".",".","."}};
	private boolean winCheck;
	private boolean endCheck;
	private boolean playAgainCheck;
	private Scanner inputPlayAgain = new Scanner(System.in);
	
	//game board index
	String gameBoardIndex(int x,int y) {
		return gameBoard[x][y];
	}
	
	//game board setter
	void setGameBoardIndex(int x, int y, String z) {
		this.gameBoard[x][y] = z;
	}
	
	//output game board
	void outputBoard() {
		for (int i = 0;i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (j == 2) {
					System.out.println(this.gameBoardIndex(i,j));
				}else {
					System.out.print(this.gameBoardIndex(i,j));
				}
			}
		}
	}
	
	//win check getter
	boolean getWinCheck() {
		return winCheck;
	}
	
	//win check setter
	void setWinCheck(boolean x) {
		this.winCheck = x;
	}
	
	//check for win
	void hasWon(int x, int y, String symbol) {
		
		//check column
		for (int i = 0; i < 3; i++) {
			if (this.gameBoardIndex(x,i) != symbol) {
				break;
			}else if (i == 2) {
				this.winCheck = true;
			}
		}
			
		//check row
		for (int i = 0; i < 3; i++) {
			if (this.gameBoardIndex(i, y) != symbol) {
				break;
			}else if (i == 2) {
				this.winCheck = true;
			}
		}
			
		//check diagonals
			
		if (x == y) {
			for (int i = 0; i < 3; i++) {
				if (this.gameBoardIndex(i, i) != symbol) {
					break;
				}else if (i == 2) {
					this.winCheck = true;
				}
			}
		}else if (x+y == 2) {
			for (int i = 0; i < 3; i++) {
				if (this.gameBoardIndex(i, (2-i)) != symbol) {
					break;
				}else if (i == 2) {
					this.winCheck = true;
				}		
			}
		}
	}
	
	//play again check getter
	boolean getPlayAgainCheck() {
		return playAgainCheck;
	}
	
	//play again check setter
	void playAgain() {
		System.out.println("Would you like to play again?: ");
		if ((inputPlayAgain.next()).toLowerCase(Locale.ENGLISH) == "yes" || (inputPlayAgain.next()).toLowerCase(Locale.ENGLISH) == "y"){
			this.playAgainCheck = true;
		}else {
			this.playAgainCheck = false;
		}
	}
	
	//endGame setter
	void endGame() {
		if (this.getWinCheck() == true && this.getPlayAgainCheck() == false) {
			this.endCheck = true;
		}
	}
	
	//endCheck getter
	boolean getEndCheck() {
		return endCheck;
	}
	
	//board reset
	void boardReset() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				this.setGameBoardIndex(i,j,".");
			}
		}
	}
	
}

