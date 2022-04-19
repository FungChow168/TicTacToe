package com.techreturner.game;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class TictactoeTest {

    private Tictactoe game = new Tictactoe();

    @Test
    public void checkDisplayGameBoardTest(){
        assertEquals("1|2|3\n-+-+-\n4|5|6\n-+-+-\n7|8|9\n", game.printGameBoard());
    }

    @Test
    public void checkAddItemToBoard(){
        game.addItemToBoard(1, "X");
        assertEquals("X|2|3\n-+-+-\n4|5|6\n-+-+-\n7|8|9\n", game.printGameBoard());
        game.addItemToBoard(2, "O");
        assertEquals("X|O|3\n-+-+-\n4|5|6\n-+-+-\n7|8|9\n", game.printGameBoard());
        game.addItemToBoard(3, "X");
        assertEquals("X|O|X\n-+-+-\n4|5|6\n-+-+-\n7|8|9\n", game.printGameBoard());
        game.addItemToBoard(4, "O");
        assertEquals("X|O|X\n-+-+-\nO|5|6\n-+-+-\n7|8|9\n", game.printGameBoard());
        game.addItemToBoard(5, "X");
        assertEquals("X|O|X\n-+-+-\nO|X|6\n-+-+-\n7|8|9\n", game.printGameBoard());
        game.addItemToBoard(6, "O");
        assertEquals("X|O|X\n-+-+-\nO|X|O\n-+-+-\n7|8|9\n", game.printGameBoard());
        game.addItemToBoard(7, "X");
        assertEquals("X|O|X\n-+-+-\nO|X|O\n-+-+-\nX|8|9\n", game.printGameBoard());
        game.addItemToBoard(8, "O");
        assertEquals("X|O|X\n-+-+-\nO|X|O\n-+-+-\nX|O|9\n", game.printGameBoard());
        game.addItemToBoard(9, "X");
        assertEquals("X|O|X\n-+-+-\nO|X|O\n-+-+-\nX|O|X\n", game.printGameBoard());
    }

    @Test
    public void checkAvailableBoxtest(){
        game.addItemToBoard(1, "X");
        assertFalse("this is not valid box number", game.isAvailableBox(1));
        game.addItemToBoard(3, "X");
        assertFalse("this is not valid box number", game.isAvailableBox(3));
        game.addItemToBoard(6, "X");
        assertFalse("this is not valid box number", game.isAvailableBox(6));
        game.addItemToBoard(2, "X");
        assertFalse("this is not valid box number", game.isAvailableBox(2));
        game.addItemToBoard(5, "X");
        assertFalse("this is not valid box number", game.isAvailableBox(5));
        game.addItemToBoard(8, "X");
        assertFalse("this is not valid box number", game.isAvailableBox(8));
        game.addItemToBoard(9, "X");
        assertFalse("this is not valid box number", game.isAvailableBox(9));
        game.addItemToBoard(7, "X");
        assertFalse("this is not valid box number", game.isAvailableBox(7));
        game.addItemToBoard(4, "X");
        assertFalse("this is not valid box number", game.isAvailableBox(4));
    }

    // get user input alternatively, check the board display properly

    // check three in a row

}
