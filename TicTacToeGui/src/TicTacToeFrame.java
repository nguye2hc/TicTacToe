import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class TicTacToeFrame extends JFrame{
    JPanel statPnl;
    JPanel boardPanel;
    JPanel mainPanel;
    JPanel playerPanel;
    JButton quit;
    JTextField playerXTF;
    JTextField playerOTF;
    JTextField tieTF;
    JLabel playerXLbl;
    JLabel playerOLbl;
    JLabel tieLbl;
    JLabel playerTurn;
    int row;
    int col = 0;
    int playerXWinCount=0;
    int playerOWinCount=0;
    int tieCount=0;
    int numMove;
    boolean playerMove=true;
    private static final int ROW = 3;
    private static final int COL = 3;
    static TicTacToeButton[][] board = new TicTacToeButton[3][3];
    public TicTacToeFrame()
    {
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        createPlayerPanel();
        createBoardPanel();
        createStatPanel();

        mainPanel.add(playerPanel, BorderLayout.NORTH);
        mainPanel.add(boardPanel, BorderLayout.CENTER);
        mainPanel.add(statPnl, BorderLayout.SOUTH);

        add(mainPanel);
        pack();
    }
    private void createPlayerPanel()
    {
        playerPanel = new JPanel();
        playerTurn = new JLabel("Player X Turn");
        playerTurn.setFont(new Font("Serif", Font.PLAIN, 20));
        playerPanel.add(playerTurn);
    }


    private void createStatPanel()
    {
        statPnl = new JPanel();
        statPnl.setLayout(new GridLayout(3,2));
        statPnl.setLayout(new FlowLayout(FlowLayout.CENTER));

        playerXLbl = new JLabel("Player X won: ");
        playerXTF = new JTextField();
        playerXTF.setText(String.valueOf(playerXWinCount));
        playerXTF.setEditable(false);

        playerOLbl = new JLabel("Player O won: ");
        playerOTF = new JTextField();
        playerOTF.setText(String.valueOf(playerOWinCount));
        playerOTF.setEditable(false);


        tieLbl = new JLabel("Tie: ");
        tieTF = new JTextField();
        tieTF.setText(String.valueOf(tieCount));
        tieTF.setEditable(false);

        //Since using GridLayout, we must add labels and text fields in order.

        quit = new JButton();
        quit.setText("Exit");
        quit.setFont(new Font("Serif", Font.PLAIN, 14));
        quit.addActionListener(e ->
        {
            System.exit(0);
        });
        statPnl.add(playerXLbl);
        statPnl.add(playerXTF);

        statPnl.add(playerOLbl);
        statPnl.add(playerOTF);

        statPnl.add(tieLbl);
        statPnl.add(tieTF);
        statPnl.add(quit);
    }
    private void createBoardPanel() {
        boardPanel = new JPanel();
        boardPanel.setLayout(new GridLayout(3, 3));

        for (int row = 0; row < 3; row++)
            for (int col = 0; col < 3; col++)
            {
                board[row][col] = new TicTacToeButton(row, col);
                board[row][col].setText(" ");
                board[row][col].setFont(new Font(Font.SERIF, Font.PLAIN, 15));
                board[row][col].addActionListener((ActionEvent ae) -> {

                    TicTacToeButton player =  (TicTacToeButton) ae.getSource();

                    if (!player.getText().equals(" "))
                    {
                        JOptionPane.showMessageDialog(null, "Illegal Move. Choose an empty square");
                        return;

                    }
                    if (playerMove)
                    {
                        player.setText("X");
                        player.setFont(new Font(Font.SERIF, Font.PLAIN, 30));
                        playerTurn.setText("Player O turn");
                    }
                    else
                    {
                        player.setText("O");
                        player.setFont(new Font(Font.SERIF, Font.PLAIN, 30));
                        playerTurn.setText("Player X turn");
                    }
                    playerMove = !playerMove;
                    numMove++;

                    if (numMove >= 5)
                    {
                        checkWin();
                    }
                    if (numMove >= 7)
                    {
                        checkTie();
                    }

                });
                boardPanel.add(board[row][col]);

            }
    }
    private void checkWin()
    {
        // checking row win
        for (int row = 0; row < 3; row++) {
            if (board[row][0].getText().equals(board[row][1].getText())
                    && board[row][1].getText().equals(board[row][2].getText())
                    && !board[row][0].getText().equals(" ")) {
                JOptionPane.showMessageDialog(null, board[row][0].getText() + " wins!");
                if(board[row][0].getText()=="X")
                {
                    playerXWinCount++;
                    playerXTF.setText(String.valueOf(playerXWinCount));
                }else if(board[row][0].getText()=="O") {
                    playerOWinCount++;
                    playerOTF.setText(String.valueOf(playerOWinCount));
                }
                restartGame();
                return;
            }
        }
        // checking col win
        for (int col = 0; col < 3; col++) {
            if (board[0][col].getText().equals(board[1][col].getText())
                    && board[1][col].getText().equals(board[2][col].getText())
                    && !board[0][col].getText().equals(" ")) {
                JOptionPane.showMessageDialog(null, board[0][col].getText() + " wins!");
                if(board[0][col].getText()=="X")
                {
                    playerXWinCount++;
                    playerXTF.setText(String.valueOf(playerXWinCount));
                }else if(board[0][col].getText()=="O") {
                    playerOWinCount++;
                    playerOTF.setText(String.valueOf(playerOWinCount));
                }
                restartGame();
                return;
            }

        }
        // checking diagonol win
        if (board[0][0].getText().equals(board[1][1].getText())
                && board[1][1].getText().equals(board[2][2].getText())
                && !board[0][0].getText().equals(" ")) {
            JOptionPane.showMessageDialog(null, board[0][0].getText() + " wins!");
            if(board[0][0].getText()=="X")
            {
                playerXWinCount++;
                playerXTF.setText(String.valueOf(playerXWinCount));
            }else if(board[0][0].getText()=="O") {
                playerOWinCount++;
                playerOTF.setText(String.valueOf(playerOWinCount));
            }
            restartGame();
            return;
        }
        // checking diagonal win
        if (board[0][2].getText().equals(board[1][1].getText())
                && board[1][1].getText().equals(board[2][0].getText())
                && !board[0][2].getText().equals(" ")) {
            JOptionPane.showMessageDialog(null, board[0][2].getText() + " wins!" );
            if(board[0][2].getText()=="X")
            {
                playerXWinCount++;
                playerXTF.setText(String.valueOf(playerXWinCount));
            }else if(board[0][2].getText()=="O") {
                playerOWinCount++;
                playerOTF.setText(String.valueOf(playerOWinCount));
            }
            restartGame();
            return;
        }
    }
    private void checkTie() {
        {
            boolean xFlag = false;
            boolean oFlag = false;
            // Check all 8 win vectors for an X and O so
            // no win is possible
            // Check for row ties
            for (int row = 0; row < ROW; row++) {
                if (board[row][0].getText().equals("X") ||
                        board[row][1].getText().equals("X") ||
                        board[row][2].getText().equals("X")) {
                    xFlag = true; // there is an X in this row
                }
                if (board[row][0].getText().equals("O") ||
                        board[row][1].getText().equals("O") ||
                        board[row][2].getText().equals("O")) {
                    oFlag = true; // there is an O in this row
                }
                if (!(xFlag && oFlag)) {
                    return; // No tie can still have a row win
                }
                xFlag = oFlag = false;
            }
            // Now scan the columns
            for (int col = 0; col < COL; col++) {
                if (board[0][col].getText().equals("X") ||
                        board[1][col].getText().equals("X") ||
                        board[2][col].getText().equals("X")) {
                    xFlag = true; // there is an X in this col
                }
                if (board[0][col].getText().equals("O") ||
                        board[1][col].getText().equals("O") ||
                        board[2][col].getText().equals("O")) {
                    oFlag = true; // there is an O in this col
                }
                if (!(xFlag && oFlag)) {
                    return; // No tie can still have a col win
                }
            }
// Now check for the diagonals
            xFlag = oFlag = false;
            if (board[0][0].getText().equals("X") ||
                    board[1][1].getText().equals("X") ||
                    board[2][2].getText().equals("X")) {
                xFlag = true;
            }
            if (board[0][0].getText().equals("O") ||
                    board[1][1].getText().equals("O") ||
                    board[2][2].getText().equals("O")) {
                oFlag = true;
            }
            if (!(xFlag && oFlag)) {
                return; // No tie can still have a diag win
            }

            xFlag = oFlag = false;
            if (board[0][2].getText().equals("X") ||
                    board[1][1].getText().equals("X") ||
                    board[2][0].getText().equals("X")) {
                xFlag = true;
            }
            if (board[0][2].getText().equals("O") ||
                    board[1][1].getText().equals("O") ||
                    board[2][0].getText().equals("O")) {
                oFlag = true;
            }
            if (!(xFlag && oFlag)) {
                return; // No tie can still have a diag win
            }
            // Checked every vector so I know I have a tie
            tieCount++;
            tieTF.setText(String.valueOf(tieCount));
            JOptionPane.showMessageDialog(null, "It's a Tie Game");
            restartGame();
        }
    }
    private boolean restartGame() {

        int dialogButton = JOptionPane.showConfirmDialog(null, "Do you play the game again?", "End Game?", JOptionPane.YES_NO_OPTION);
        if (dialogButton == JOptionPane.YES_OPTION)
        {
            clearBoard();
        }
        else
        {
            System.exit(0);
        }
        return false;
    }
    private void clearBoard()
    {
        for (int row=0; row<ROW;row++)
        {
            for (int col=0; col<COL;col++)
            {
                board[row][col].setText(" ");
            }
        }
        playerTurn.setText("Player X Turn");
    }

}