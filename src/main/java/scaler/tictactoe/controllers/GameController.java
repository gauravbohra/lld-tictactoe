package scaler.tictactoe.controllers;

import scaler.tictactoe.models.Game;
import scaler.tictactoe.models.Player;
import scaler.tictactoe.models.PlayerType;
import scaler.tictactoe.strategies.winningStrategies.WinningStrategies;

import java.util.List;

public class GameController {

    public Game startGame(int dimension, List<Player> players, List<WinningStrategies> winningStrategies){
        return Game.builder().setDimension(dimension).setPlayers(players)
                .setWinningStrategies(winningStrategies).build();
    }

    public void makeMove(){

    }

    public void displayBoard(){

    }

    public void checkGameState(){

    }

    public void getWinner(){

    }

    public void undoLastMove(){

    }


}
