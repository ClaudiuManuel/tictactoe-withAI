package tictactoe;

public class Player_Hard implements Player {
    char c;

    public Player_Hard(char c) {
        this.c = c;
    }

    public char otherPlayer() {
        if (c == 'X')
            return 'O';
        else
            return 'X';
    }

    @Override
    public void faMutare(char[][] matrice) {
        System.out.println("Making move level \"hard\"");
        int bestScore = Integer.MIN_VALUE;
        int bestLine = -5;
        int bestColumn = -5;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (matrice[i][(j + 1) * 2] == ' ') {
                    matrice[i][(j + 1) * 2] = c;
                    int score = minimax(matrice, 0, false);
                    matrice[i][(j + 1) * 2] = ' '; //revenire la starea initiala.In caz contrar la fiecare pas s-ar face o mutare(pe prima pozitie gasita libera)
                    //System.out.println(bestScore + " in functia principala inainte de schimb " + score+ " actual");
                    if (score > bestScore) {
                        bestScore = score;
                        bestLine = i;
                        bestColumn = j;
                    }
                }
            }
        }
        matrice[bestLine][(bestColumn + 1) * 2] = c;
    }

    public int minimax(char[][] matrice, int depth, boolean isMax) {
        //verific daca jocul a ajuns intr-o faza terminala(X sau O a castigat)
        String checkFinish = Game.verificare_stare(matrice);

        if (checkFinish.equals(c + " wins"))
            return 1 * (this.emptyCellsLeft(matrice) + 1);
        else if (checkFinish.equals(this.otherPlayer() + " wins"))
            return -1 * (this.emptyCellsLeft(matrice) + 1);
        else if (checkFinish.equals("Draw"))
            return 0 * (this.emptyCellsLeft(matrice) + 1);

        if (isMax) {
            int bestSc = Integer.MIN_VALUE;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (matrice[i][(j + 1) * 2] == ' ') {
                        matrice[i][(j + 1) * 2] = c;
                        int score = minimax(matrice, depth + 1, false);
                        matrice[i][(j + 1) * 2] = ' ';
                        bestSc = Math.max(score, bestSc);
                        //System.out.println(bestSc+" pe max "+depth);
                    }
                }
            }
            return bestSc;
        } else {
            int worstScore = Integer.MAX_VALUE;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (matrice[i][(j + 1) * 2] == ' ') {
                        matrice[i][(j + 1) * 2] = this.otherPlayer();
                        int score = minimax(matrice, depth + 1, true);
                        matrice[i][(j + 1) * 2] = ' ';
                        worstScore = Math.min(worstScore, score);
                        //System.out.println(worstScore+" pe min "+depth);
                    }
                }
            }
            return worstScore;
        }
    }

    public int emptyCellsLeft(char[][] matrice) {
        int empty = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (matrice[i][(j + 1) * 2] == ' ')
                    empty++;
            }
        }
        return empty;
    }
}

