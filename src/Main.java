import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            HangmanGUI gui = new HangmanGUI();
            gui.setVisible(true);
        });
    }
}