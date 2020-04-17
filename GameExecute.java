
public class GameExecute {

	public static void main(String[] args) {
		//define and set turn
		turn gameTurn = new turn();
		gameTurn.setTurn(0);
		
		//define players
		Player Player1 = new Player();
		Player Player2 = new Player();
		
		//set player symbols and numbers
		Player1.setPlayerSymbol("X");
		Player2.setPlayerSymbol("O");
		Player1.setPlayerNumber(Player1.getPlayerSymbol());
		Player2.setPlayerNumber(Player2.getPlayerSymbol());
		
		//set player names
		Player1.setPlayerName("Player1");
		Player2.setPlayerName("Player2");
		
		
		//define game board
		GameBoard playingField = new GameBoard();
		
		//run while no player has won
		do {
			//increment turn
			gameTurn.turnCount();
			playingField.outputBoard();
			
			//set player turn
			switch(gameTurn.turnDefiner()) {
			
			//player 1 turn
			case 1:
				Player1.setPlayerTurnCheck(true);
				Player2.setPlayerTurnCheck(false);
				Player1.takeMove();
				
				//incorrect input catch
				if (Player1.getX() == -1 || Player1.getY() == -1) {
					gameTurn.restart();
				
				//only play if it is a new position
				}else if (playingField.gameBoardIndex(Player1.getX(), Player1.getY()) != "X" && playingField.gameBoardIndex(Player1.getX(), Player1.getY()) != "O") {
					playingField.setGameBoardIndex(Player1.getX(), Player1.getY(), Player1.getPlayerSymbol());
					
				//if position has already been used
				}else {
					System.out.println("You cannot play here");
					gameTurn.restart();
				}
				
				//check if winning move
				playingField.hasWon(Player1.getX(), Player1.getY(), Player1.getPlayerSymbol());
				Player1.playerWinCheck(playingField.getWinCheck());
				
				//output win
				if (Player1.getPlayerWinCheck() == true) {
					System.out.println(Player1.getPlayerName() + " has Won!");
					playingField.playAgain();
				}
				break;
				
			//player 2 turn
			case 2:
				Player2.setPlayerTurnCheck(true);
				Player1.setPlayerTurnCheck(false);
				Player2.takeMove();
				
				//incorrect input catch
				if (Player2.getX() == -1 || Player2.getY() == -1) {
					gameTurn.restart();
				
				//only play if it is a new position
				}else if (playingField.gameBoardIndex(Player2.getX(), Player2.getY()) != "X" && playingField.gameBoardIndex(Player2.getX(), Player2.getY()) != "O") {
					playingField.setGameBoardIndex(Player2.getX(), Player2.getY(), Player2.getPlayerSymbol());
				
				//if position has already been used
				}else {
					System.out.println("You cannot play here");
					gameTurn.restart();
				}
				
				//check if winning move
				playingField.hasWon(Player2.getX(), Player2.getY(), Player2.getPlayerSymbol());
				Player2.playerWinCheck(playingField.getWinCheck());
				
				//output win
				if (Player2.getPlayerWinCheck() == true) {
					System.out.println(Player2.getPlayerName() + " has Won!");
					playingField.playAgain();
				}
				break;
			}
			
			/** replay, currently ends no matter what
			if (playingField.getPlayAgainCheck() == true) {
				gameTurn.setTurn(0);
				playingField.boardReset();
				playingField.setWinCheck(false);
				Player1.playerWinCheck(false);
				Player2.playerWinCheck(false);
			}else {
				playingField.endGame();
				}**/
		} while ((playingField.getEndCheck() != true));
	}
}