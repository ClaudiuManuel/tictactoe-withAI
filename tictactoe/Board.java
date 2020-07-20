package tictactoe;

public class Board {
    private char[][] matrice = new char[6][15];

    public void initializare_board(){
        for (int i = 0; i < 3; i++) {       //initializare matrice cu spatii goale
            for (int j = 0; j < 3; j++) {
                matrice[i][j] = ' ';
            }
        }
    }

    public  void printare() {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(j==0)
                    System.out.print("| ");
                if (matrice[i][j] == 'X' || matrice[i][j] == 'O')
                    System.out.print(matrice[i][j]);
                else
                    System.out.print(' ');
                if(j==2)
                    System.out.print(" |");
                System.out.print(" ");
            }
            System.out.print("\n");
        }
        System.out.println("---------");
    }

    public char[][] getMatrice(){
        return matrice;
    }
}
