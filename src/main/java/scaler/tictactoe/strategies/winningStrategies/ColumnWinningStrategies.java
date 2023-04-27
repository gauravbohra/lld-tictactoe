package scaler.tictactoe.strategies.winningStrategies;

import scaler.tictactoe.models.Board;
import scaler.tictactoe.models.Move;
import scaler.tictactoe.models.Symbol;

import java.util.HashMap;
import java.util.Map;

public class ColumnWinningStrategies implements WinningStrategies{
    Map<Integer, Map<Symbol,Integer>> counts= new HashMap<>();
    public boolean checkWinner(Board board, Move move) {
        int col = move.getCell().getCol();
        if(!counts.containsKey(col)){
            Map<Symbol,Integer> map= new HashMap<>();
            counts.put(col,map);
        }
        Symbol symbol = move.getCell().getPlayer().getSymbol();
        Map<Symbol,Integer> colMap=counts.get(col);
        if(!colMap.containsKey(symbol)){
            colMap.put(symbol,0);
        }
        colMap.put(symbol,colMap.get(symbol)+1);

        if(colMap.get(symbol).equals(board.getSize())){
            return true;
        }
        return false;
    }
}
