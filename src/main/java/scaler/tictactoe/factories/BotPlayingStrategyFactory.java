package scaler.tictactoe.factories;

import scaler.tictactoe.models.BotDifficultyLevel;
import scaler.tictactoe.strategies.botPlayingStrategy.BotPlayingStrategy;
import scaler.tictactoe.strategies.botPlayingStrategy.EasyBotPlayingStrategy;
import scaler.tictactoe.strategies.botPlayingStrategy.HardBotPlayingStrategy;
import scaler.tictactoe.strategies.botPlayingStrategy.MediumBotPlayingStrategy;

public class BotPlayingStrategyFactory {

    public static BotPlayingStrategy getBotPlayingStrategyForDifficultyLevel(BotDifficultyLevel botDifficultyLevel){
        if(botDifficultyLevel==BotDifficultyLevel.EASY){
            return new EasyBotPlayingStrategy();
        }
        else if(botDifficultyLevel ==BotDifficultyLevel.MEDIUM){
            return new MediumBotPlayingStrategy();
        }
        else {
            return new HardBotPlayingStrategy();
        }
    }
}
