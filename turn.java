
public class turn {
	private int turn;
	
	//getter
	int getTurn() {
		return turn;
	}
	
	//setter
	void setTurn(int x) {
		this.turn = x;
	}
	
	//increment
	void turnCount() {
		this.turn = turn+1;
	}
	
	//restart the turn
	void restart() {
		this.turn = turn-1;
	}
	
	//player turn definer
	int turnDefiner() {
		if (turn%2 == 0) {
			return 2;
		}else {
			return 1;
		}
	}
}
