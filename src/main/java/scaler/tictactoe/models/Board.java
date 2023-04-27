package scaler.tictactoe.models;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<List<Cell>> board;
    private int size;

    public int getSize() {
        return size;
    }

    public List<List<Cell>> getBoard() {
        return board;
    }

    public Board(int size){
        this.size = size;
        this.board = new ArrayList<>();
        for(int i=0;i<size;i++){
            ArrayList<Cell> row = new ArrayList<>();
            board.add(row);
            for(int j=0 ;j<size;j++){
                row.add(new Cell(i,j));
            }
        }
    }

    public void printBoard(){
        for(int i=0;i<this.size;i++){
            for(int j=0;j<this.size;j++){
                board.get(i).get(j).displayCell();
            }
            System.out.println();
        }
    }

}
