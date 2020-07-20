package tictactoe;

import java.util.Random;

public class Player_Medium implements Player {
    char c;

    public Player_Medium(char c) {
        this.c = c;
    }

    @Override
    public void faMutare(char[][] matrice) {
        int linie;
        int coloana;
        boolean gasit = false;
        System.out.println("Making move level \"medium\"");
        //verificare diagonala principala
        if ((matrice[1][1] != ' ' && (matrice[0][0] == matrice[1][1] || matrice[1][1] == matrice[2][2])) || (matrice[0][0] == matrice[2][2] && matrice[0][0] != ' ')) {
            if (matrice[0][0] == ' ') {
                matrice[0][0] = c;
                gasit = true;
            } else if (matrice[1][1] == ' ') {
                matrice[1][1] = c;
                gasit = true;
            } else if (matrice[2][2] == ' ') {
                matrice[2][2] = c;
                gasit = true;
            }
        }
        //verificare diagonala secundara
        if (!gasit) {
            if ((((matrice[0][2] == matrice[1][1]) || (matrice[1][1] == matrice[2][0])) && matrice[1][1] != ' ') || (matrice[0][2] == matrice[2][0] && matrice[0][2] != ' ')) {
                if (matrice[0][2] == ' ') {
                    matrice[0][2] = c;
                    gasit = true;
                } else if (matrice[1][1] == ' ') {
                    matrice[1][1] = c;
                    gasit = true;
                } else if (matrice[2][0] == ' ') {
                    matrice[2][0] = c;
                    gasit = true;
                }
            }
        }
        if (!gasit) {                           //daca nu s-a gasit pe diagonale nici un candidat--->se va merge la fiecare element
            for (int i = 0; i < 3; i++) {       //si se vor face verificari in L(se verifica in dreapta lui si sub el,mai putin cand se afla pe ultima linie sau ultima coloana)
                if(gasit)
                    break;
                for (int j = 0; j < 3; j++) {
                    linie = i + 1;
                    coloana = j + 1;
                    //verificari pe linie
                    if (j == 2)
                        coloana = 0;
                    if (matrice[i][coloana] == matrice[i][j] && matrice[i][j] != ' ') {
                        if (j == 0 && matrice[i][2] == ' ') {
                            matrice[i][2] = c;
                            gasit = true;
                            break;
                        } else if (j == 1 && matrice[i][0] == ' ') {
                            matrice[i][0] = c;
                            gasit = true;
                            break;
                        } else if (matrice[i][1] == ' ') {
                            matrice[i][1] = c;
                            gasit = true;
                            break;
                        }
                    }
                    //verificare pe coloana
                    if (i == 2)
                        linie = 0;
                    if (matrice[linie][j] == matrice[i][j] && matrice[i][j] != ' ') {
                        if (i == 0 && matrice[2][j] == ' ') {
                            matrice[2][j] = c;
                            gasit = true;
                            break;
                        } else if (i == 1 && matrice[0][j] == ' ') {
                            matrice[0][j] = c;
                            gasit = true;
                            break;
                        } else if (matrice[1][j] == ' ') {
                            matrice[1][j] = c;
                            gasit = true;
                            break;
                        }
                    }
                }
            }
        }
        if (!gasit) { //daca nu am reusit sa blochez mutarea decisiva sau sa o fac eu pentru a castiga,voi face o mutare random
            Random r = new Random();
            int l;
            int col;
            while (true) {
                l = r.nextInt(3);
                col = r.nextInt(3);
                if (matrice[l][col] == ' ') {
                    matrice[l][col] = c;
                    break;
                }
            }
        }
    }
}
