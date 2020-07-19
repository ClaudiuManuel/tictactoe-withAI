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
                    switch (b) {  //transformare coordonate primite--> in forma folosita de mine la matrice
                        case 1:
                            b = 2;
                            break;
                        case 2:
                            b = 1;
                            break;
                        case 3:
                            b = 0;
                            break;
                    }
                    if (matrice[b][a * 2] == ' ') {
                        matrice[b][a * 2] = c;
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

