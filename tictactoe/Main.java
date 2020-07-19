package tictactoe;

import org.w3c.dom.ls.LSOutput;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);
        Game game = new Game();
        game.gameLogic(new Board(), reader);

    }
}

