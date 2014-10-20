import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.Timer;

public class SnakeGame extends JFrame {
    DoublyLinkedList<Point> snake = new DoublyLinkedList<Point>();
    
    SnakeGame() {
        SnakeGame frame = new SnakeGame();
        Grid grid = new Grid();
        
        // add grid to frame
        frame.add(grid,BorderLayout.CENTER);
        
        frame.setTitle("Snake");

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // start snake
        Timer timer = new Timer(100, grid);
        timer.start();
    }
    
    public static void main(String[] a) {
        new SnakeGame();
    }
}