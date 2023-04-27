package scaler.tictactoe.controllers;

import scaler.tictactoe.models.Game;
import scaler.tictactoe.models.GameState;
import scaler.tictactoe.models.Player;
import scaler.tictactoe.models.PlayerType;
import scaler.tictactoe.strategies.winningStrategies.WinningStrategies;

import java.util.List;

public class GameController {

    public Game startGame(int dimension, List<Player> players, List<WinningStrategies> winningStrategies){
        return Game.builder().setDimension(dimension).setPlayers(players)
                .setWinningStrategies(winningStrategies).build();
    }

    public void displayBoard(Game game){
        game.displayBoard();
    }

    public GameState checkGameState(Game game){
        return game.getGameState();
    }

    public void makeMove(Game game){
        game.makeMove();
    }



    public void getWinner(){

    }

    public void undoLastMove(){

    }


}
