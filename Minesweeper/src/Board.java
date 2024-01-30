import java.util.Random;

public class Board {

    private Cell [][] cells;
    private int rows;
    private int columns;
    private int numberOfMines;
    private boolean isGameOver = false;

    public boolean isGameOver() {
        return isGameOver;
    }

    public Board (int rows, int columns, int numMines){
        this.rows = rows;
        this.columns = columns;
        this.numberOfMines = numMines;
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

        while(placedMines < numberOfMines){
            int randomRow = random.nextInt(rows);
            int randomColumn = random.nextInt(columns);

            if (!cells[randomRow][randomColumn].isAMine()) {
                cells[randomRow][randomColumn].setAMine(true);
                placedMines++;
            }
        }

    }
    private boolean isValidCell(int row, int col) {
        return row >= 0 && row < rows && col >= 0 && col < columns;
    }

    public void calculateAdjacentMines(int row, int column) {
        Cell curentCell = cells[row][column];
        if (curentCell.isRevealed() && !curentCell.isAMine()) {
            int adjacentMines = 0;

            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    int newRow = row + i;
                    int newCol = column + j;

                    if (isValidCell(newRow, newCol) && cells[newRow][newCol].isAMine()) {
                        adjacentMines++;

                    }
                }
            }

            curentCell.setMineNeighbours(adjacentMines);
        }
    }

    public void revealCell(int row, int column){



        Cell currentCell = cells[row][column];

        if(currentCell.isRevealed() || currentCell.isFlagged()){
            return;
        }

        currentCell.setRevealed(true);

        if(currentCell.isAMine()){
            System.out.println("Game Over! You hit a mine.");
            isGameOver = true;
        }else{
            calculateAdjacentMines(row, column);
        }

    }

}

