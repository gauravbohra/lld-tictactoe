package scaler.tictactoe.strategies.botPlayingStrategy;

import scaler.tictactoe.models.Board;
import scaler.tictactoe.models.Cell;
import scaler.tictactoe.models.CellState;
import scaler.tictactoe.models.Move;

import java.util.List;

public class EasyBotPlayingStrategy implements BotPlayingStrategy{

    public Move makeMove(Board board) {
        for(List<Cell> row: board.getBoard()){
            for (Cell cell: row){
                if(cell.getCellState()== CellState.EMPTY){
                    new Move(cell,null);
                }
            }
        }

        return null;
    }
}
