public class Main {
    public static void main(String[] args) {
        TicTacToeButton[][] board = new TicTacToeButton[3][3];
        for (int row=0; row<3;row++)
        {
            for (int col=0; col<3;col++)
            {
                board[row][col] = new TicTacToeButton(row, col);
                board[row][col].setText(" ");
            }
        }
    }
}