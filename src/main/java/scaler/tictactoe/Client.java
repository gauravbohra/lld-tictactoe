package scaler.tictactoe;

import scaler.tictactoe.controllers.GameController;
import scaler.tictactoe.models.*;
import scaler.tictactoe.strategies.winningStrategies.ColumnWinningStrategy;
import scaler.tictactoe.strategies.winningStrategies.DiagonalWinningStrategy;
import scaler.tictactoe.strategies.winningStrategies.RowWinningStrategy;
import scaler.tictactoe.strategies.winningStrategies.WinningStrategies;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        GameController gameController = new GameController();

        List<Player> players = new ArrayList<>();
        players.add(new Player(1,"Gaurav", new Symbol('X'), PlayerType.HUMAN));
        players.add(new Bot(2,"TestBot", new Symbol('O'), BotDifficultyLevel.EASY));

        List<WinningStrategies> winningStrategies = new ArrayList<>();
        winningStrategies.add(new RowWinningStrategy());
        winningStrategies.add(new ColumnWinningStrategy());
        winningStrategies.add(new DiagonalWinningStrategy());

        Game game =gameController.startGame(3, players, winningStrategies);
        Scanner scanner= new Scanner(System.in);

        while(gameController.checkGameState(game)== GameState.IN_PROGRESS){
            //Print Board
            //Make move
            System.out.println("Do you undo the last move? (y/n)");
            String undoCheck=scanner.next();
            if(undoCheck.equalsIgnoreCase("y")){
                gameController.undoLastMove(game);
            }
            gameController.displayBoard(game);
            gameController.makeMove(game);
        }
        if(game.getGameState().equals(GameState.SUCCESS)){
            System.out.println(gameController.getWinner(game).getName()+" has won the game");
        }
        else{
            System.out.println("Game ended in draw");
        }

    }
}
