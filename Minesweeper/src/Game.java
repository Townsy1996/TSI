import java.util.Scanner;

public class Game {
    private Board board;
    private boolean gameIsRunning;

    public Game(){
        this.gameIsRunning = true;
    }

    public void start(){

        // Welcome Message
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to Minesweeper, thanks for playing!");

        // Player selects difficulty
        System.out.println("Please select your difficulty:");
        System.out.println("1: Easy :)");
        System.out.println("2: Medium :|");
        System.out.println("3: Hard :(");


        int difficultyLevel = scan.nextInt();
        boolean playerChosen  = false;

        while(!playerChosen) {
            if (difficultyLevel == 1) {
                System.out.println("You have selected Easy mode.");
                playerChosen =true;
                this.board = new Board(5, 5, 6);
            } else if (difficultyLevel == 2) {
                System.out.println("You have selected Medium mode.");
                playerChosen =true;
                this.board = new Board(7, 7, 12);
            } else if (difficultyLevel == 3) {
                System.out.println("You have selected Hard mode.");
                playerChosen =true;
                this.board = new Board(10, 10, 20);
            } else {
                System.out.println("Invalid difficulty. Exiting game.");
                break;
            }

        }

        





    }

}
