import java.util.Scanner;
/**
 * Write a description of class Main here.
 *
 * @author Leonardo Martins & Cid Coroad
 * @version 1.1.12d
 */
public class Main
{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        System.out.println("\n=======================|\n Welcome to Dice Mania |\n=======================|");
        System.out.println();
    
        Game game = new Game();
        
        while(true) {
            System.out.println("\n=======================|\n Admin Dice Mania Menu |\n=======================|\n 1 | Add player        | \n 2 | Check stats       | \n 3 | Start game        | \n 4 | Custom game       | \n 5 | Remove player     | \n=======================|\n 69 | Custom Match     | \n=======================|\n");
            int selectedMenuOption = in.nextInt();
            in.nextLine();
            
            switch (selectedMenuOption) {
                case 1:
                    System.out.println("What is your desired player name?");
                    System.out.println();
                    String pName = in.nextLine();
                    game.addPlayer(new Player(pName));
                    System.out.println();
                    break;
                case 2:
                    checkStats(game);
                    break;
                case 3:
                    if (game.checkStart()) {
                        int i = 1;
                    do {
                        System.out.println("== Round " + i++);
                        game.runRound();
                        System.out.println();
                    } while (!game.status);
                        System.out.println();
                    } else {
                        System.out.println("Please add at least one player...");
                        System.out.println();
                    }
                    break;
                case 4:
                    System.out.println("How many points to win?");
                    game.setGoal(in.nextInt());
                    in.nextLine();
                    System.out.println();
                    break;
                case 5:
                    System.out.println("What is the name of the player you want to remove?");
                    String dName = in.nextLine();
                    game.removePlayer(dName);
                    System.out.println();
                    break;
                case 69:
                    int d = 1;
                    System.out.println("How many matches?");
                    int numberMatches = in.nextInt();
                    in.nextLine();
                    if (game.checkStart()) {
                    for (int i = 0; i < numberMatches; i++) {
                        do {
                            game.runRound();
                        } while (!game.status);
                        }
                    } else {
                        System.out.println("Please add at least one player...");
                        System.out.println();
                    }
                    System.out.println();
                    break;
                default:
                    System.out.println("Please select an option from the menu...");
                    System.out.println();
                    break;
                }
            }
        }
    
    private static void checkStats(Game game) {
            for (Player player : game.players) {
                System.out.println(player.printOverallStats());
            }
            System.out.println();
    }
}
