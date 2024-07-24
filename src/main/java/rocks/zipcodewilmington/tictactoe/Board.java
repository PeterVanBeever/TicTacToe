package rocks.zipcodewilmington.tictactoe;

public class Board {
    private Character[][] matrix;
    private int numCols; // number of columns

    // constructor
    public Board(Character[][] matrix) {
        this.matrix = matrix;
        this.numCols = matrix[0].length;
    }

    // get the winner of the game
    public String getWinner() {
        // check rows for a winner
        for (int i = 0; i < 3; i++) {
            // check if all elements in row i are the same and not null
            if (matrix[i][0] != null && matrix[i][0].equals(matrix[i][1]) && matrix[i][1].equals(matrix[i][2])) {
                return matrix[i][0].toString(); // return the winner ('X' or 'O')
            }
        }

        // check columns for a winner
        for (int i = 0; i < 3; i++) {
            // check if all elements in column i are the same and not null
            if (matrix[0][i] != null && matrix[0][i].equals(matrix[1][i]) && matrix[1][i].equals(matrix[2][i])) {
                return matrix[0][i].toString(); // return the winner ('X' or 'O')
            }
        }

        // check diagonals for a winner
        // top-left to bottom-right diagonal
        if (matrix[0][0] != null && matrix[0][0].equals(matrix[1][1]) && matrix[1][1].equals(matrix[2][2])) {
            return matrix[0][0].toString(); // return the winner ('X' or 'O')
        }

        // top-right to bottom-left diagonal
        if (matrix[0][2] != null && matrix[0][2].equals(matrix[1][1]) && matrix[1][1].equals(matrix[2][0])) {
            return matrix[0][2].toString(); // return the winner ('X' or 'O')
        }

        return ""; // no winner
    }

    // check if 'O' is the winner
    public Boolean isInFavorOfO() {
        return "O".equals(getWinner()); // return true if 'O' is the winner
    }

    // check if 'X' is the winner
    public Boolean isInFavorOfX() {
        return "X".equals(getWinner()); // return true if 'X' is the winner
    }

    // check if the game is a tie
    public Boolean isTie() {
        // if there is a winner, it's not a tie
        if (!getWinner().isEmpty()) {
            return false;
        }

        // check if there are any empty cells
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == null) {
                    return false; // there is an empty cell, so it's not a tie
                }
            }
        }

        return true; // no winner and no empty cells means a tie
    }
}
