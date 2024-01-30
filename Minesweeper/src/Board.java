import java.util.Random;

public class Board {

    private Cell [][] cells;
    private int rows;
    private int columns;
    private int numberofMines;


    public Board (int rows, int columns, int numMines){
        this.rows = rows;
        this.columns = columns;
        this.numberofMines = numMines;
        this.cells = new Cell [rows][columns];
    }

    public void createGameBoard(){
        for (int i = 0; i < rows; i ++){
            for(int j = 0; j < columns; j ++){
                cells[i][j] = new Cell();
            }
        }
    }

    public void printGameBoard(){



        System.out.println("Current Board State:");

        System.out.print("  ");
        for (int col = 0; col < columns; col++) {
            System.out.print(col + " ");
        }
        System.out.println();


        for (int row = 0; row < rows; row++) {
            System.out.print(row + "|");
            for (int col = 0; col < columns; col++) {
                Cell currentCell = cells[row][col];
                if (currentCell.isRevealed()) {
                    System.out.print("  "); // Print a space for revealed cells
                } else {
                    System.out.print("? "); // Print a question mark for unrevealed cells
                }
            }
            System.out.println();
        }
    }

    public void populateMines(){
        Random random = new Random();
        int placedMines = 0;

        while(placedMines < numberofMines){
            int randomRow = random.nextInt(rows);
            int randomColumn = random.nextInt(columns);

            if (!cells[randomRow][randomColumn].isAMine()) {
                cells[randomRow][randomColumn].setAMine(true);
                placedMines++;
            }
        }

    }





}

