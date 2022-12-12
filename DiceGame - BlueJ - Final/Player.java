
/**
 * Write a description of class Player here.
 *
 * @author Leonardo Martins & Cid Coroad
 * @version 1.1.12d
 */
public class Player
{
    // instance variables for the player 
    String name;
    int points = 0;
    int wins = 0;
    int lastRoll = 0;

    /**
     * Constructor for objects of class Player
     */
    public Player(String name)
    {
        // initialise instance variables
        this.name = name;
    }

    /**
     * Method to return player last roll
     *
     * @return    returns the lass roll the player got.
     */
    public int getLastRoll() {
    return lastRoll;
    }

    /**
     * Method to return player last roll
     *
     * @param  lastRoll  sets the last roll of the player
     */
    public void setLastRoll(int lastRoll) {
    this.lastRoll = lastRoll;
    }
    /**
     * Method to return player name
     *
     * @return    returns the player name.
     */
    public String getName() {
        return name;
    }
    /**
     * Method to return player last roll
     *
     * @param  name  sets the player name.
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Method to return player points
     *
     * @return  returns the player points.
     */    
    public int getPoints() {
        return points;
    }
    /**
     * Method to add points to player
     */
    public void addPoints() {
        this.points++;
    }
    /**
     * Method to return player wins
     *
     * @return  returns the player wins.
     */    
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
