import javax.swing.JFrame;
import javax.swing.JLabel;

public class SimpleGuiApp {
    
    public static void main(String[] args) {
        // Create a new JFrame object, which is the window.
        JFrame frame = new JFrame("Simple GUI Application");

        // Set the operation that will happen by default when the user initiates a "close" on this frame.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a JLabel and add some text to it.
        JLabel label = new JLabel("Hello, World!");

        // Add the JLabel to the JFrame.
        frame.add(label);

        // Set the size of the frame (window).
        frame.setSize(300, 200);

        // Make the frame visible.
        frame.setVisible(true);
    }
}
