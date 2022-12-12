import java.util.ArrayList;
import java.util.Random;
/**
 * Write a description of class Game here.
 *
 * @author Leonardo Martins & Cid Coroad
 * @version 1.1.12d
 */
public class Game
{
    // instance variables for the game
    ArrayList<Player> players = new ArrayList<>();
    int goal = 21;
    boolean status = false;

    /**
     * Constructor for objects of class Game
     */
    public Game()
    {
    }
    /**
     * Constructor for objects of class Game with a custom goal
     */
    public Game(int goal) {
        this.goal = goal;
    }
    /**
     * This is the method used to add players.
     *
     * @param  player  receives an object of type player and checks if it can be created, if it already exists it will return an error. 
     */
    public void addPlayer(Player player) {
    if (!checkExistence(player.getName())) {
            players.add(player);
            System.out.println(String.format("%s has been added successfuly!", player.name));
    } else {
            System.out.println("\n{ERROR: This player already exists.}");
        }
    }
    /**
     * This is the method used to remove players.
     *
     * @param  name  receives the player name and checks if it exists, if it does it will delete it. 
     */
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
        /**
     * This is the method used to check if a player exists.
     *
     * @param  name  used to checks if it exists in the player ArrayList.
     * 
     * @return checker if true means the player exists, if false it doesn't exist yet
     */
    public boolean checkExistence(String name) {
        boolean checker = false;
        for (Player player : players) {
            if (player.getName().equals(name) ) {
        checker = true;
            }
        }
        return checker;
    }
        /**
     * This is the method used to check if the game can start.
     *
     * @return  if there is at least 1 player in the ArrayList it let's the game start. 
     */
    public boolean checkStart() {
        if (players.size() > 0) {
            return true;
        } else {
            return false;
        }
    }
        /**
     * This is the method used to check if a player won.
     *
     * @return  returns a player that has hit the goal. 
     */
    private Player checkGoal() {
        for (Player player : players) {
            if (player.points >= goal ) {
                return player;
            }
        }
        return null;
    }
    /**
     * This is the method used to get the game goals.
     *
     * @return  returns game goal. 
     */
    public int getGoal() {
        return goal;
    }
    /**
     * This is the method used to set game goals.
     *
     * @param  goal  set game goal. 
     */
    public void setGoal(int goal) {
        this.goal = goal;
    }
    /**
     * This is the method used to run the rounds.
     *
     * @return  roundwinner  this is the logic that runs the rounds, it will return the round winner in the end and while running it gives round and player points. 
     */    
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
     /**
     * This is the method used to check player stats.
     *
     * @return  player  returns player stats. 
     */   
    private void checkStats() {
        for (Player player : players) {
            System.out.println(player.printGameStats());
        }
    }
    /**
     * This is the method used to reset player points.
     *
     * @return  player  player points. 
     */    
    private void resetPoints() {
        for (Player player : players) {
            player.resetPoints();
        }
    }
    /**
     * This is the method used to check for ties during match.
     *
     * @param  highestThrown  if more than one player have the highestThrown they both get a win, this is to make the game fair and balanced. 
     */    
    private void checkTies(int highestThrown) {
        for (Player player : players) {
            if (player.getLastRoll() == highestThrown) {
                player.addPoints();
            }
        }
    }
}
