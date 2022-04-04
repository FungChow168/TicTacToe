package com.techreturner.game;

import java.util.ArrayList;
import java.util.Arrays;

public class Tictactoe {

    private final int minimumBoxNum = 1;
    private final int maximumBoxNum = 9;
    private final int ELEMENTPERLINE = 5;
    private String gameBoard[] = {"1", "|", "2", "|", "3",
                                  "-", "+", "-", "+", "-",
                                  "4", "|", "5", "|", "6",
                                  "-", "+", "-", "+", "-",
                                  "7", "|", "8", "|", "9"};
    private ArrayList<Integer> availableBox = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9));
    private ArrayList<Integer> playerASelected = new ArrayList<Integer>();
    private ArrayList<Integer> playerBSelected = new ArrayList<Integer>();

    public String displayGameBoard(){
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

    public Boolean isAvailableBox(int boxNum){
        if (boxNum >= minimumBoxNum && boxNum <= maximumBoxNum && availableBox.indexOf(boxNum) != -1)
            return true;
        return false;
    }

    public int getIndex(int boxNumber){
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
            default -> 0;
        };
    }

    public void addItemToBoard(int boxNumber){
        if (isAvailableBox(boxNumber)){
            gameBoard[getIndex(boxNumber)] = "X";
            availableBox.remove(new Integer(boxNumber));
        }else
            System.out.println("Box " + boxNumber + " is not available.");

    }

    public void printAvailableBox(){
        System.out.println(availableBox.toString());
    }

    public static void main(String[] args) {
        Tictactoe a = new Tictactoe();
        a.addItemToBoard(1);
        a.addItemToBoard(3);
        a.addItemToBoard(9);
        a.addItemToBoard(9);
        a.printAvailableBox();
        a.displayGameBoard();
    }

}
