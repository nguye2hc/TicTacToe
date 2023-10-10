import javax.swing.*;
import java.awt.*;

public class TicTacToeRunner {
    public static void main(String[] args) {
        TicTacToeFrame frame = new TicTacToeFrame();
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();

        int height = screenSize.height;
        int width = screenSize.width;

        height = screenSize.height;
        width = screenSize.width;
        frame.setSize(800,600);
        frame.setLocation(width/4,height/20);

        frame.setTitle("Tic Tac Toe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
