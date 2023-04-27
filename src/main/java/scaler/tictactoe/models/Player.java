package scaler.tictactoe.models;

import java.util.Scanner;

public class Player {
    private int id;
    private String name;
    private Symbol symbol;
    private PlayerType playerType;
    private Scanner scanner;

    public Player(int id, String name, Symbol symbol, PlayerType playerType) {
        this.id = id;
        this.name = name;
        this.symbol = symbol;
        this.playerType = playerType;
        this.scanner = new Scanner(System.in);
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public Move makeMove(Board board){
        System.out.println("Select the row to make move, starting from 0");
        int row = scanner.nextInt();
        System.out.println("Select the column to make move, starting from 0");
        int col = scanner.nextInt();
        Cell cell =new Cell(row, col);
        return new Move(cell,this);
    }
}
