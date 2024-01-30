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

        // Difficulty selection
        int difficultyLevel = selectDifficulty(scan);
        initialiseGame(difficultyLevel);

        // Game logic
        while(gameIsRunning){
            board.printGameBoard();



            System.out.println("Please select your move (row# press enter, column# press enter");
            int row = scan.nextInt();
            int column = scan.nextInt();

            board.revealCell(row, column);

            if(board.isGameOver()){
                gameIsRunning = false;
                board.printGameBoard();
            }
        }
    }
    private int selectDifficulty(Scanner scan) {
        int difficultyLevel = 0;

        while (difficultyLevel < 1 || difficultyLevel > 3) {
            System.out.println("Please select your difficulty:");
            System.out.println("1: Easy :)");
            System.out.println("2: Medium :|");
            System.out.println("3: Hard :(");

            difficultyLevel = scan.nextInt();

            if (difficultyLevel < 1 || difficultyLevel > 3) {
                System.out.println("Invalid difficulty. Please choose again.");
            }
        }

        return difficultyLevel;
    }

    private void initialiseGame(int difficultyLevel) {
        switch (difficultyLevel) {
            case 1:
                System.out.println("You have selected Easy mode.");
                this.board = new Board(5, 5, 3);
                break;
            case 2:
                System.out.println("You have selected Medium mode.");
                this.board = new Board(7, 7, 6);
                break;
            case 3:
                System.out.println("You have selected Hard mode.");
                this.board = new Board(10, 10, 10);
                break;
        }

        board.createGameBoard();
        board.populateMines();
    }


}
