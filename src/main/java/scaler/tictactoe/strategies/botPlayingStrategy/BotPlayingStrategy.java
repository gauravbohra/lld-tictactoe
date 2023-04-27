package scaler.tictactoe.strategies.botPlayingStrategy;

import scaler.tictactoe.models.Board;
import scaler.tictactoe.models.Move;
import scaler.tictactoe.models.Symbol;

public interface BotPlayingStrategy {

    public Move makeMove(Board board);
}
