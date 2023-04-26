package scaler.tictactoe.models;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<List<Cell>> board;
    private int size;

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

}
