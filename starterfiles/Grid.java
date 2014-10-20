import static java.awt.Color.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JPanel;

public class Grid extends JPanel implements KeyListener, ActionListener {

    private Snake snake;

    public Grid() {
        // intialize 
        // ...

        // install key listener and obtain focus
        addKeyListener(this);
        setFocusable(true);
        requestFocus();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); 
        // draw each grid element
    }
    
    /** 
     * let the snake make a step
     */
    void step() {
        //...  
        snake.step();
        //...
    }   

    @Override public void keyTyped(KeyEvent e) {    }
    @Override public void keyReleased(KeyEvent e) {    }

    @Override
    public void keyPressed(KeyEvent e) {
        // inspect e.getKeycode()
        // arrow key codes: KeyEvent.VK_UP, KeyEvent.VK_DOWN, KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT     
    }

    @Override
    public void actionPerformed(ActionEvent e) {  // called on Timer event
        //...
    }
}