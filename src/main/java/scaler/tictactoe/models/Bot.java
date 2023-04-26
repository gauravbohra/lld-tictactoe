package scaler.tictactoe.models;

import scaler.tictactoe.factories.BotPlayingStrategyFactory;
import scaler.tictactoe.strategies.botPlayingStrategy.BotPlayingStrategy;

public class Bot extends Player{
    private BotDifficultyLevel botDifficultyLevel;
    private BotPlayingStrategy botPlayingStrategy;

    public Bot(int id, String name, Symbol symbol, BotDifficultyLevel botDifficultyLevel) {
        super(id, name, symbol, PlayerType.BOT);
        this.botDifficultyLevel = botDifficultyLevel;
        this.botPlayingStrategy= BotPlayingStrategyFactory.getBotPlayingStrategyForDifficultyLevel(
                botDifficultyLevel
        );
    }
}
