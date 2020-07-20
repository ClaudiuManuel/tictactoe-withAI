package tictactoe;

import java.util.Scanner;

public class Player_User implements Player {
    char c;
    Scanner r = new Scanner(System.in);

    public Player_User(char c) {
        this.c = c;
    }

    @Override
    public void faMutare(char[][] matrice) {
        while (true) {
            try {
                System.out.print("Enter the coordinates: ");
                String[] helper = r.nextLine().split(" ");
                int a = Integer.parseInt(helper[0]);
                int b = Integer.parseInt(helper[1]);
                if (a > 3 || b > 3 || a < 1 || b < 1) {
                    System.out.println("Coordinates should be from 1 to 3!");
                } else {

                    if (matrice[a-1][b-1] == ' ') {
                        matrice[a-1][b-1] = c;
                        break;
                    } else
                        System.out.println("This cell is occupied! Choose another one!");
                }
            } catch (Exception e) {
                System.out.println("You should enter numbers!");
            }
        }
    }
}

