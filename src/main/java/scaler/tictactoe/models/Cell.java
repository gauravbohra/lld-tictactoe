package scaler.tictactoe.models;

public class Cell {
    private int row;
    private int col;
    private CellState cellState;
    private Player player;

    public Cell(int row, int col){
        this.row = row;
        this.col= col;
        this.cellState= CellState.EMPTY;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public CellState getCellState() {
        return cellState;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setCellState(CellState cellState) {
        this.cellState = cellState;
    }

    public void displayCell(){
        if(this.cellState==CellState.EMPTY){
            System.out.print("| - |");
        }
        else{
            System.out.print("| "+this.player.getSymbol().getaChar()+" |");
        }
    }

}
