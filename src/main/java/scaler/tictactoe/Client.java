package scaler.tictactoe;

import scaler.tictactoe.controllers.GameController;
import scaler.tictactoe.models.Player;
import scaler.tictactoe.models.PlayerType;
import scaler.tictactoe.models.Symbol;
import scaler.tictactoe.strategies.winningStrategies.ColumnWinningStrategies;
import scaler.tictactoe.strategies.winningStrategies.RowWinningStrategy;
import scaler.tictactoe.strategies.winningStrategies.WinningStrategies;

import java.util.ArrayList;
import java.util.List;

public class Client {

    public static void main(String[] args) {
        GameController gameController = new GameController();

        List<Player> players = new ArrayList<>();
        players.add(new Player(1,"Gaurav", new Symbol('X'), PlayerType.HUMAN));
        players.add(new Player(2,"Rahul", new Symbol('O'), PlayerType.HUMAN));

        List<WinningStrategies> winningStrategies = new ArrayList<>();
        winningStrategies.add(new RowWinningStrategy());
        winningStrategies.add(new ColumnWinningStrategies());

        gameController.startGame(3, players, winningStrategies);


    }
}
