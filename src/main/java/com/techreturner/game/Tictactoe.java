package com.techreturner.game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tictactoe {

    private final int minimumBoxNum = 1;
    private final int maximumBoxNum = 9;
    private final int ELEMENTPERLINE = 5;
    private final String playerASymbol = "X";
    private final String playerBSymbol = "O";
    private String gameBoard[] = {"1", "|", "2", "|", "3",
                                  "-", "+", "-", "+", "-",
                                  "4", "|", "5", "|", "6",
                                  "-", "+", "-", "+", "-",
                                  "7", "|", "8", "|", "9"};
    private ArrayList<Integer> availableBox = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9));
    private ArrayList<Integer> playerASelected = new ArrayList<Integer>();
    private ArrayList<Integer> playerBSelected = new ArrayList<Integer>();
    private final Integer [][] winningNumberlist = {{1,2,3},{4,5,6},{7,8,9},
                                                {1,4,7},{2,5,8},{3,6,9},
                                                {1,5,9},{3,5,7}
                                                };

    public void play(){

    }

    public String printGameBoard(){
        String board = "";
        for (int i=0; i<gameBoard.length; i++) {
            System.out.print(gameBoard[i]);
            board += gameBoard[i];
            if (i%ELEMENTPERLINE == 4) {
                System.out.println("");
                board += "\n";
            }
        }
        return board;
    }

    public boolean isWinner(ArrayList<Integer> playerSelected, Integer [] winningNumber){
        if (playerSelected.size()<3)
            return false;
        return playerSelected.containsAll(new ArrayList<Integer>(List.of(winningNumber)));
    }

    public Boolean isAvailableBox(int boxNum){
        if (boxNum >= minimumBoxNum && boxNum <= maximumBoxNum && availableBox.indexOf(boxNum) != -1)
            return true;
        return false;
    }

    private int getIndex(int boxNumber){
        return switch (boxNumber) {
            case 1 -> 0;
            case 2 -> 2;
            case 3 -> 4;
            case 4 -> 10;
            case 5 -> 12;
            case 6 -> 14;
            case 7 -> 20;
            case 8 -> 22;
            case 9 -> 24;
            default -> throw new IllegalArgumentException();
        };
    }

    public void addItemToBoard(int boxNumber, String symbol){
        if (isAvailableBox(boxNumber)){
            gameBoard[getIndex(boxNumber)] = symbol;
            availableBox.remove(Integer.valueOf(boxNumber));
        }else
            System.out.println("Box " + boxNumber + " is not available.");

    }

    public void printAvailableBox(){
        System.out.println(availableBox);
    }

    public static void main(String[] args) {
        Tictactoe a = new Tictactoe();
        a.addItemToBoard(1, "X");
        a.addItemToBoard(3, "O");
        a.addItemToBoard(9, "X");
        a.addItemToBoard(9, "O");
        a.printAvailableBox();
        a.printGameBoard();
        Integer [] b = {1,2,3};
        System.out.println(a.isWinner(new ArrayList<Integer>(Arrays.asList(1,2,5,7,3)), b));
    }

}
