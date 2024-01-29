public class Cell {

    private boolean isAMine;
    private int mineNeighbours;
    private boolean isRevealed;
    private boolean isFlagged;

    public Cell(){
        isAMine = false;
        mineNeighbours = 0;
        isRevealed = false;
        isFlagged = false;
    }

    public boolean isAMine() {
        return isAMine;
    }

    public void setAMine(boolean AMine) {
        isAMine = AMine;
    }

    public int getMineNeighbours() {
        return mineNeighbours;
    }

    public void setMineNeighbours(int mineNeighbours) {
        this.mineNeighbours = mineNeighbours;
    }

    public boolean isRevealed() {
        return isRevealed;
    }

    public void setRevealed(boolean revealed) {
        isRevealed = revealed;
    }

    public boolean isFlagged() {
        return isFlagged;
    }

    public void setFlagged(boolean flagged) {
        isFlagged = flagged;
    }


}
