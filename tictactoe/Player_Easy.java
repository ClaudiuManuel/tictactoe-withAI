package tictactoe;

import java.util.Random;

public class Player_Easy implements Player {
    char c;

    public Player_Easy(char c){
        this.c=c;
    }

    public void faMutare(char[][] matrice) {
        System.out.println("Making move level \"easy\"");
        Random r = new Random();
        int linie;
        int coloana;
        while (true) {
            linie = r.nextInt(3);
            coloana = r.nextInt(3) + 1;
            if (matrice[linie][coloana * 2] == ' ') {
                matrice[linie][coloana * 2] = c;
                break;
            }
        }
    }
}

