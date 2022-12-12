package pt.banana.dice;

public class Player {
	String name;
	int points = 0;
	int wins = 0;
	int lastRoll = 0;
	
	public int getLastRoll() {
		return lastRoll;
	}

	public void setLastRoll(int lastRoll) {
		this.lastRoll = lastRoll;
	}

	public Player(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPoints() {
		return points;
	}

	public void addPoints() {
		this.points++;
	}

	public int getWins() {
		return wins;
	}

	public void addWins() {
		this.wins++;
	}
	
	public String printGameStats() {
		return String.format("%s has %d points", name, points); 
	}
	
	public String printOverallStats() {
		return String.format("%s has %d wins", name, wins); 
	}
	
	public void resetPoints() {
		points = 0; 
	}

}
