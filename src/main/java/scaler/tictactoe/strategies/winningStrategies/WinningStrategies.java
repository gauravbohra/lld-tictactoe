package scaler.tictactoe.strategies.winningStrategies;

import scaler.tictactoe.models.Board;
import scaler.tictactoe.models.Move;

public interface WinningStrategies {
    public boolean checkWinner(Board board, Move move);
}
