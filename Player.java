import java.util.Scanner;

public class Player {
	private String playerSymbol;
	private String playerName;
	private int playerNumber;
	public boolean playerTurnCheck;
	private boolean playerWinCheck;
	private int X;
	private int Y;
	private Scanner inputXY = new Scanner(System.in);
	private Scanner inputName = new Scanner(System.in);
	
	
	//player symbol getter
	String getPlayerSymbol() {
		return playerSymbol;
	}
	
	//player symbol setter
	void setPlayerSymbol(String x) {
			this.playerSymbol = x;
		}

	//player name getter
	String getPlayerName() {
		return playerName;
	}
	
	//player name setter
	void setPlayerName(String x) {
		System.out.print(x + " enter your name: ");
		this.playerName = inputName.next();
	}
	
	//player number getter
	int getPlayerNumber() {
		return playerNumber;
	}
	
	//player number setter
	void setPlayerNumber(String x) {
		if (x == "X") {
			this.playerNumber = 1;
		}else if (x == "O") {
			this.playerNumber = 2;
		}
		
	}
	
	//player turn getter
	boolean getPlayerTurnCheck() {
		return playerTurnCheck;
	}
	
	//player turn setter
	void setPlayerTurnCheck(boolean x) {
		this.playerTurnCheck = x;
			
		}
 
	
	
	//player win check getter
	boolean getPlayerWinCheck() {
		return playerWinCheck;
		}
		
	//win check setter
	void playerWinCheck(boolean x) {
		if (x == true) {
			this.playerWinCheck = true;
		}else {
			this.playerWinCheck = false;
		}
	}
	//X getter
	int getX() {
		return X;
	}
		
	//Y getter
	int getY() {
		return Y;
	}
		
	//XY input
	void takeMove() {
		System.out.println("Starting from the top left,");
		System.out.println("Enter X coordinate: ");
		try {
			this.X = inputXY.nextInt()-1;
		} catch (Exception e) {
			System.out.println("Incorrect input");
			this.X = -1;
		}
		System.out.println("Enter Y coordinate: ");
		try {
			this.Y = inputXY.nextInt()-1;
		} catch (Exception e) {
			System.out.println("Incorrect input");
			this.Y = -1;
		}
	}
}

