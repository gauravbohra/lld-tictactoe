package scaler.tictactoe;

import scaler.tictactoe.controllers.GameController;
import scaler.tictactoe.models.*;
import scaler.tictactoe.strategies.winningStrategies.ColumnWinningStrategies;
import scaler.tictactoe.strategies.winningStrategies.DiagonalWinningStrategies;
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
        winningStrategies.add(new DiagonalWinningStrategies());

        Game game =gameController.startGame(3, players, winningStrategies);

        while(gameController.checkGameState(game)== GameState.IN_PROGRESS){
            //Print Board
            //Make move
            gameController.displayBoard(game);
            gameController.makeMove(game);
        }
        if(game.getGameState().equals(GameState.SUCCESS)){
            System.out.println(gameController.getWinner(game)+" has won the game");
        }
        else{
            System.out.println("Game ended in draw");
        }

    }
}
