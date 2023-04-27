package scaler.tictactoe.strategies.winningStrategies;

import scaler.tictactoe.models.Board;
import scaler.tictactoe.models.Move;
import scaler.tictactoe.models.Symbol;

import java.util.HashMap;
import java.util.Map;

public class RowWinningStrategy implements WinningStrategies{
    Map<Integer, Map<Symbol,Integer>>  counts = new HashMap<>();
    public boolean checkWinner(Board board, Move move) {
        int row=move.getCell().getRow();

        if(!counts.containsKey(row)){
            Map<Symbol,Integer> map=new HashMap<>();
            counts.put(row, map);
        }

        Symbol symbol=move.getCell().getPlayer().getSymbol();
        Map<Symbol, Integer> rowMap=counts.get(row);
        if(!rowMap.containsKey(symbol)){
            rowMap.put(symbol, 0);
        }
        rowMap.put(symbol,rowMap.get(symbol)+1);

        if(rowMap.get(symbol).equals(board.getSize())){
            return true;
        }

        return false;
    }
}
