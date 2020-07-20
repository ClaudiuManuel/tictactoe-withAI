package tictactoe;

import java.util.Scanner;

public class Game {

    Player player1;
    Player player2;


    public void gameLogic(Board tabla, Scanner reader) {
        tabla.initializare_board();
        char[][] matrice = tabla.getMatrice();
        while (true) {
            System.out.print("Input command: ");
            String input = reader.nextLine();
            String[] helper = input.split(" ");
            if (helper[0].equals("exit"))
                break;
            if (helper.length != 3) {
                System.out.println("Bad parameters!");
            } else {
                if (helper[1].equals("easy")) {
                    player1 = new Player_Easy('X');
                }else if (helper[1].equals("medium")){
                    player1 = new Player_Medium('X');
                } else if(helper[1].equals("hard")){
                    player1= new Player_Hard('X');
                }else{
                    player1 = new Player_User('X');
                }

                if (helper[2].equals("easy")) {
                    player2 = new Player_Easy('O');
                } else if(helper[2].equals("medium")){
                    player2 = new Player_Medium('O');
                }else if(helper[2].equals("hard")){
                    player2=new Player_Hard('O');
                }else{
                    player2 = new Player_User('O');
                }

                tabla.printare();
                while (true) {
                    player1.faMutare(matrice);
                    tabla.printare();
                    if (this.verificare_stare(matrice).equals("Draw") || this.verificare_stare(matrice).equals("X wins") || this.verificare_stare(matrice).equals("O wins")) {
                        System.out.println(verificare_stare(matrice));
                        break;                //verificare dupa mutarea primului jucator
                    }
                    player2.faMutare(matrice);
                    tabla.printare();
                    if (this.verificare_stare(matrice).equals("Draw") || this.verificare_stare(matrice).equals("X wins") || this.verificare_stare(matrice).equals("O wins")) {
                        System.out.println(verificare_stare(matrice));
                        break;                //verificare dupa mutarea jucatorului cu numarul 2
                    }
                }
                break;
            }
        }

    }


    public static String verificare_stare(char[][] matrice) {
        boolean empty = false;
        char winner = 'n';//verificare daca ramane "no"(no winner found:n)
        //diagonala principala + diagonala secundara
        if (matrice[1][1] != ' ' && ((matrice[0][0] == matrice[1][1] && matrice[0][0] == matrice[2][2]) || (matrice[0][2] == matrice[1][1] && matrice[0][2] == matrice[2][0]))) {
            winner = matrice[1][1];
        } else {
            for (int i = 0; i < 3; i++) {
                if (matrice[i][0] != ' ' && matrice[i][0] == matrice[i][1] && matrice[i][0] == matrice[i][2]) {
                    winner = matrice[i][0]; //winner gasit pe linie
                    break;
                }
                if (matrice[0][i] != ' ' && matrice[0][i] == matrice[1][i] && matrice[0][i] == matrice[2][i]) {
                    winner = matrice[0][i]; //winner gasit pe coloana
                    break;
                }
                for (int j = 0; j < 3; j++) {
                    if (matrice[i][j] == ' ')
                        empty = true;
                }
            }
        }
        if (winner != 'n')
            return winner + " wins";
        else if (!empty)
            return "Draw";
        else return "Game not finished";

    }
}
