package tictactoe;

public class Board {
    private char[][] matrice = new char[6][15];

    public void initializare_board(){
        for (int i = 0; i < 3; i++) {       //initializare matrice cu spatii goale
            for (int j = 0; j < 9; j++) {
                matrice[i][j] = ' ';
            }
        }
    }

    public  void printare() {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 9; j++) {
                if (matrice[i][j] == 'X' || matrice[i][j] == 'O')
                    System.out.print(matrice[i][j]);
                else if (j == 0 || j == 8)
                    System.out.print("|");
                else System.out.print(" ");
            }
            System.out.print("\n");
        }
        System.out.println("---------");
    }

    public char[][] getMatrice(){
        return matrice;
    }
}
