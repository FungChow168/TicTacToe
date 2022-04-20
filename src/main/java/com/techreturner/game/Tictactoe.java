package com.techreturner.game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tictactoe {

    private final int MINIMUMBOXNUM = 1;
    private final int MAXIMUMBOXNUM = 9;
    private final int ELEMENTPERLINE = 5;
    private final int PLAYER = 66;
    private final String PLAYERASYMBOL = "X";
    private final String PLAYERBSYMBOL = "O";
    private char winner ;
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
    private boolean gameEnd = false;

    public void play(){
        String input;
        Scanner scanner = new Scanner(System.in);
        int index = MINIMUMBOXNUM;
        while (index <= MAXIMUMBOXNUM && !gameEnd) {
            do {
                System.out.println("option: " + availableBox);
                System.out.println("Player " + (char) (PLAYER - index % 2) + ": please select a box.");
                input = scanner.nextLine();
            }while (!isValidInput(input));
            addItemToBoard(Integer.valueOf(input), index%2==1?PLAYERASYMBOL:PLAYERBSYMBOL);
            if (index%2==1)
                playerASelected.add(Integer.valueOf(input));
            else
                playerBSelected.add(Integer.valueOf(input));
            printGameBoard();
            if (iAmWinner(index%2))
                break;
            index ++;
        }
        if (!gameEnd)
            System.out.println("Game is tied.");
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
        System.out.println("\n------------------\n");
        return board;
    }

    private boolean iAmWinner(int playerNum){
        if (playerNum == 1) {
            if (playerASelected.size()> 2) {
                for (int i = 0; i < winningNumberlist.length; i++) {
                    if (isWinner(playerASelected, winningNumberlist[i])) {
                        System.out.print("Winner is A");
                        gameEnd = true;
                        return true;
                    }
                }
            }
        }else
            if (playerBSelected.size()> 2) {
                for (int i = 0; i < winningNumberlist.length; i++) {
                    if (isWinner(playerBSelected, winningNumberlist[i])) {
                        System.out.print("Winner is B");
                        gameEnd = true;
                        return true;
                    }
                }
            }
        return false;
    }

    public boolean isWinner(ArrayList<Integer> playerSelected, Integer [] winningNumber){
        if (playerSelected.size()<3)
            return false;
        return playerSelected.containsAll(new ArrayList<Integer>(List.of(winningNumber)));
    }

    public boolean isValidInput(String input){
        Pattern pattern = Pattern.compile("[1-9]");
        Matcher matcher = pattern.matcher(input);
        if (matcher.find())
            if (isAvailableBox(Integer.valueOf(input)))
                return true;
        System.out.println("Invalid input.  Please try again.");
        return false;
    }

    public Boolean isAvailableBox(int boxNum){
        if (boxNum >= MINIMUMBOXNUM && boxNum <= MAXIMUMBOXNUM && availableBox.indexOf(boxNum) != -1)
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
            System.out.println("Box " + boxNumber + " is taken.");

    }

    public void printAvailableBox(){
        System.out.println(availableBox);
    }

    public static void main(String[] args) {
        Tictactoe a = new Tictactoe();
        a.play();
    }

}
