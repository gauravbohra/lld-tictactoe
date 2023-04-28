package scaler.tictactoe.models;

import scaler.tictactoe.exceptions.PlayerCountDimensionMismatchException;
import scaler.tictactoe.exceptions.DuplicateSymbolException;
import scaler.tictactoe.exceptions.MoreThanOneBotException;
import scaler.tictactoe.strategies.winningStrategies.WinningStrategies;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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


    public void displayBoard(){
        this.board.printBoard();
    }

    public GameState getGameState(){
        return this.gameState;
    }

    public Player getWinner() {
        return winner;
    }

    public void makeMove(){
        Player currentMovePlayer = this.players.get(this.nextPlayerIndex);
        System.out.println("It is Player "+currentMovePlayer.getName()+"'s turn. Please, make your move");
        Move move=currentMovePlayer.makeMove(board);
        int row=move.getCell().getRow();
        int col=move.getCell().getCol();
        System.out.println(currentMovePlayer.getName()+"has made a move at row "+ row
                +" and column "+col);
        if(!validateMove(move)){
            System.out.println("Invalid move. Please try again ");
            return;
        }

        //Updating the cell in the board
        Cell cellToUpdate=board.getBoard().get(row).get(col);
        cellToUpdate.setPlayer(currentMovePlayer);
        cellToUpdate.setCellState(CellState.FILLED);

        //adding move to the moves list
        move=new Move(cellToUpdate,currentMovePlayer);
        this.moves.add(move);

        //Check winner
        if(checkWinner(move)){
            this.gameState=GameState.SUCCESS;
            this.winner=currentMovePlayer;
        }
        else if(this.moves.size()==board.getSize()* board.getSize()){
            this.gameState=GameState.DRAW;
        }

        this.nextPlayerIndex++;
        this.nextPlayerIndex=this.nextPlayerIndex % players.size();
    }

    public void undo(){
        if(moves.size()==0){
            System.out.println("No moves to undo");
            return;
        }
        //Remove the last move from the moves list
        Move lastMove = moves.get(moves.size()-1);
        moves.remove(lastMove);
        //Updating the board cell of last move
        Cell cell = lastMove.getCell();
        cell.setCellState(CellState.EMPTY);
        cell.setPlayer(null);
        //Updating the winning strategies map
        for(WinningStrategies strategy:winningStrategies){
            strategy.handleUndo(board,lastMove);
        }
        //Updating the next player index
        nextPlayerIndex= nextPlayerIndex-1;
        nextPlayerIndex=(nextPlayerIndex+players.size())%players.size();
    }

    public boolean validateMove(Move move){
        int row=move.getCell().getRow();
        int col=move.getCell().getCol();
        if(row<0 || row>=this.board.getSize()){
            return false;
        }
        if(col<0 || col>=this.board.getSize()){
            return false;
        }

        if(this.board.getBoard().get(row).get(col).getCellState()==CellState.FILLED){
            return false;
        }
        return true;
    }

    private boolean checkWinner(Move move){
        for(WinningStrategies winningStrategies: winningStrategies){
            if(winningStrategies.checkWinner(board,move)) {
                return true;
            }
        }
        return false;
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

        private void validatePlayersUniqueSymbol() throws DuplicateSymbolException {
            Set<Character> symbolSet =new HashSet<>();
            for(Player player:players){
                char playerSymbol=player.getSymbol().getaChar();
                if(symbolSet.contains(playerSymbol)){
                    throw new DuplicateSymbolException();
                }
                symbolSet.add(playerSymbol);
            }
        }

        private void validateBotCount() throws MoreThanOneBotException{
            int botCount=0;
            for(Player player:players){
                if(player.getPlayerType()==PlayerType.BOT){
                    botCount++;
                }
                if(botCount>1){
                    throw new MoreThanOneBotException();
                }
            }
        }
        private void validatePlayerCountAndDimension() throws PlayerCountDimensionMismatchException{
            if((dimension-1)!=this.players.size()){
                throw new PlayerCountDimensionMismatchException();
            }
        }
        private void validate(){
            validatePlayerCountAndDimension();
            validateBotCount();
            validatePlayersUniqueSymbol();
        }

        public Game build(){
            validate();
            Game game = new Game();
            game.players = this.players;
            game.winningStrategies = this.winningStrategies;
            game.gameState = GameState.IN_PROGRESS;
            game.board = new Board(this.dimension);
            game.nextPlayerIndex = 0;
            game.moves = new ArrayList<>();
            return game;
        }

    }
}
