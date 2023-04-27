package scaler.tictactoe.strategies.winningStrategies;

import scaler.tictactoe.models.Board;
import scaler.tictactoe.models.Move;
import scaler.tictactoe.models.Symbol;

import java.util.HashMap;
import java.util.Map;

public class DiagonalWinningStrategies implements WinningStrategies{
    Map<Symbol,Integer> leftDiagonalCount= new HashMap<>();
    Map<Symbol,Integer> rightDiagonalCount = new HashMap<>();
    public boolean checkWinner(Board board, Move move) {
        int row=move.getCell().getRow();
        int col=move.getCell().getCol();
        Symbol symbol= move.getCell().getPlayer().getSymbol();
        //Check for left diagonal
        if(row==col){
            if(!leftDiagonalCount.containsKey(symbol)){
                leftDiagonalCount.put(symbol,0);
            }
            leftDiagonalCount.put(symbol,leftDiagonalCount.get(symbol)+1);
            if(leftDiagonalCount.get(symbol).equals(board.getSize())){
                return true;
            }
        }
        //Check for right diagonal
        if((row+col)==(board.getSize()-1)){
            if(!rightDiagonalCount.containsKey(symbol)){
                rightDiagonalCount.put(symbol,0);
            }
            rightDiagonalCount.put(symbol,rightDiagonalCount.get(symbol)+1);
            if(rightDiagonalCount.get(symbol).equals(board.getSize())){
                return true;
            }
        }

        return false;
    }
}
