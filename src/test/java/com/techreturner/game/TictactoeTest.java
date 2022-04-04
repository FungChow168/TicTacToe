package com.techreturner.game;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class TictactoeTest {

    private Tictactoe game = new Tictactoe();

    @Test
    public void checkDisplayGameBoardTest(){
        assertEquals("1|2|3\n-+-+-\n4|5|6\n-+-+-\n7|8|9\n", game.displayGameBoard());
    }

    @Test
    public void checkAddItemToBoard(){
        game.addItemToBoard(1);
        assertEquals("X|2|3\n-+-+-\n4|5|6\n-+-+-\n7|8|9\n", game.displayGameBoard());
        game.addItemToBoard(2);
        assertEquals("X|X|3\n-+-+-\n4|5|6\n-+-+-\n7|8|9\n", game.displayGameBoard());
        game.addItemToBoard(3);
        assertEquals("X|X|X\n-+-+-\n4|5|6\n-+-+-\n7|8|9\n", game.displayGameBoard());
        game.addItemToBoard(4);
        assertEquals("X|X|X\n-+-+-\nX|5|6\n-+-+-\n7|8|9\n", game.displayGameBoard());
        game.addItemToBoard(5);
        assertEquals("X|X|X\n-+-+-\nX|X|6\n-+-+-\n7|8|9\n", game.displayGameBoard());
        game.addItemToBoard(6);
        assertEquals("X|X|X\n-+-+-\nX|X|X\n-+-+-\n7|8|9\n", game.displayGameBoard());
        game.addItemToBoard(7);
        assertEquals("X|X|X\n-+-+-\nX|X|X\n-+-+-\nX|8|9\n", game.displayGameBoard());
        game.addItemToBoard(8);
        assertEquals("X|X|X\n-+-+-\nX|X|X\n-+-+-\nX|X|9\n", game.displayGameBoard());
        game.addItemToBoard(9);
        assertEquals("X|X|X\n-+-+-\nX|X|X\n-+-+-\nX|X|X\n", game.displayGameBoard());
    }

    @Test
    public void checkAvailableBoxtest(){
        game.addItemToBoard(1);
        assertFalse("this is not valid box number", game.isAvailableBox(1));
        game.addItemToBoard(3);
        assertFalse("this is not valid box number", game.isAvailableBox(3));
        game.addItemToBoard(6);
        assertFalse("this is not valid box number", game.isAvailableBox(6));
        game.addItemToBoard(2);
        assertFalse("this is not valid box number", game.isAvailableBox(2));
        game.addItemToBoard(5);
        assertFalse("this is not valid box number", game.isAvailableBox(5));
        game.addItemToBoard(8);
        assertFalse("this is not valid box number", game.isAvailableBox(8));
        game.addItemToBoard(9);
        assertFalse("this is not valid box number", game.isAvailableBox(9));
        game.addItemToBoard(7);
        assertFalse("this is not valid box number", game.isAvailableBox(7));
        game.addItemToBoard(4);
        assertFalse("this is not valid box number", game.isAvailableBox(4));
    }

    // get user input alternatively, check the board display properly

    // check three in a row

}
