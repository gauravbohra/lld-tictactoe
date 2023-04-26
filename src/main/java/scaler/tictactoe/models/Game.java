package scaler.tictactoe.models;

import scaler.tictactoe.strategies.winningStrategies.WinningStrategies;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private List<Player> players;
    private Board board;
    private GameState gameState;
    private List<Move> moves;
    private Player winner;
    private int nextPlayerIndex;
    private List<WinningStrategies> winningStrategies;

    private Game(){
    }
    public static Builder builder(){
        return new Builder();
    }
    public static class Builder{
        private List<Player> players;
        private int dimension;
        private List<WinningStrategies> winningStrategies;

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }
        public Builder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }
        public Builder setWinningStrategies(List<WinningStrategies> winningStrategies) {
            this.winningStrategies = winningStrategies;
            return this;
        }
        private void validate(){

        }
        public Game build(){
            Game game = new Game();
            game.players = this.players;
            game.winningStrategies = this.winningStrategies;
            game.gameState = GameState.IN_PROGRESS;
            game.board = new Board(dimension);
            game.nextPlayerIndex = 0;
            game.moves = new ArrayList<>();
            return game;
        }

    }
}
