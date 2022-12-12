
/**
 * Write a description of class Dice here.
 *
 * @author Leonardo Martins & Cid Coroad
 * @version 1.1.12d
 */
public class Dice
{
    // instance variables for the dice
    private static int diceSides;

    /**
     * Constructor for objects of class Dice
     */
    public Dice()
    {
        // initialise instance variables
        this.diceSides = 6;
    }

    /**
     * This is the Throw Dice method, this is the brain behind the dice throwing.
     *
     * @return    The random dice rolled value from 1 to 6.
     */
    public static int throwDice() {
    return (int)(Math.random() * diceSides +1);
    }
}
