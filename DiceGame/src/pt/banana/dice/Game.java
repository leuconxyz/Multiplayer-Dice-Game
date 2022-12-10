package pt.banana.dice;

import java.util.ArrayList;
import java.util.Random;

public class Game {
	
	ArrayList<Player> players = new ArrayList<>();
	int goal = 21;
	boolean status = false;
	
	public Game() {
	}
	
	public Game(int goal) {
		this.goal = goal;
	}
	
	public void addPlayer(Player player) {
		if (!checkExistence(player.getName())) {
			players.add(player);
		} else {
			System.out.println("\n{ERROR: This player already exists.}");
		}
	}
	
	public void removePlayer(String name) {
		if (checkExistence(name)) {
			int deleter = 0;
			for (Player player : players) {
				if (player.getName().equals(name)) {
					deleter = this.players.indexOf(player);
				}
			}
			this.players.remove(deleter);
			System.out.println(name + " has been removed successfuly");
		} else {
			System.out.println("\n{ERROR: This player does not exist.}");
		}
	}
	
	public boolean checkExistence(String name) {
		boolean checker = false;
		for (Player player : players) {
			if (player.getName().equals(name) ) {
				checker = true;
			}
		}
		return checker;
	}
	
	public boolean checkStart() {
		if (players.size() > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	private Player checkGoal() {
		for (Player player : players) {
			if (player.points >= goal ) {
				return player;
			}
		}
		return null;
	}

	public int getGoal() {
		return goal;
	}

	public void setGoal(int goal) {
		this.goal = goal;
	}
	
	public void runRound() {
		status = false;
		int thrown = 0;
		int highestThrown = 0;
		Player roundwinner = null;
		
		for (Player player : players) {
			Random rand = new Random();
			thrown =  (1+ rand.nextInt(6)); //Dice.throwDice();
			player.setLastRoll(thrown);
			if(thrown > highestThrown) {
				roundwinner = player;
				highestThrown = thrown;
			}
		}
		checkTies(highestThrown);
		checkStats();
		Player winner = checkGoal();
		if (winner != null) {
			System.out.println(String.format("==============================\nPlayer %s won!!!!!\n==============================", winner.getName()));
			status = true;
			winner.addWins();
			resetPoints();
		}
	}
	
	private void checkStats() {
		for (Player player : players) {
			System.out.println(player.printGameStats());
		}
	}
	
	private void resetPoints() {
		for (Player player : players) {
			player.resetPoints();
		}
	}
	
	private void checkTies(int highestThrown) {
		for (Player player : players) {
			if (player.getLastRoll() == highestThrown) {
				player.addPoints();
			}
		}
	}

}
