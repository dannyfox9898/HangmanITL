import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HangmanGUI extends JFrame {
    private JPanel panel1;
    private JLabel solutionWordLabel;
    private JTextField guessWordTxt;
    private JLabel imageLabel;
    private JButton resetBtn;
    private JLabel historyLabel;
    private JMenuBar menuBar;
    private JMenu settingsMenu;
    private JMenuItem setAttemptsItem ;
    private JCheckBoxMenuItem showHistoryMenuItem;

    private Hangman game;

    public HangmanGUI() {
        setContentPane(panel1);
        setTitle("Hangman");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        solutionWordLabel.setFont(new Font("Arial", Font.BOLD, 36));
        resetBtn.setBackground(new Color(139, 0, 0));
        resetBtn.setForeground(Color.WHITE);
        resetBtn.setOpaque(true);
        resetBtn.setBorderPainted(false);

        JMenuBar menuBar = new JMenuBar();
        JMenu settingsMenu = new JMenu("Settings");
        JMenuItem setAttemptsItem = new JMenuItem("Set Max Attempts");

        showHistoryMenuItem = new JCheckBoxMenuItem("Show History");
        showHistoryMenuItem.setSelected(true);
        showHistoryMenuItem.addActionListener(e ->
                historyLabel.setVisible(showHistoryMenuItem.isSelected()));

        settingsMenu.add(setAttemptsItem);
        settingsMenu.add(showHistoryMenuItem);
        menuBar.add(settingsMenu);
        setJMenuBar(menuBar);

        game = new Hangman();
        updateView();

        guessWordTxt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = guessWordTxt.getText();
                if (input.length() == 1) {
                    char guess = input.charAt(0);
                    game.guess(guess);
                    updateView();
                }
                guessWordTxt.setText("");
            }
        });

        resetBtn.addActionListener(e -> {
            game = new Hangman();
            updateView();
            guessWordTxt.setText("");
        });

        setAttemptsItem.addActionListener(e -> {
            String input = JOptionPane.showInputDialog(this,
                    "Enter maximum number of allowed mistakes:",
                    game.getMaxMistakes());
            if (input != null) {
                try {
                    int newMax = Integer.parseInt(input.trim());
                    if (newMax > 0) {
                        game.setMaxMistakes(newMax);
                        JOptionPane.showMessageDialog(this,
                                "Max mistakes set to " + newMax);
                    } else {
                        JOptionPane.showMessageDialog(this,
                                "Please enter a positive number.",
                                "Invalid Input", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this,
                            "Please enter a valid number.",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    private void updateView() {
        String displayWord = game.getCurrentWord()
                .chars()
                .mapToObj(c -> (char)c + " ")
                .reduce("", String::concat)
                .trim();
        solutionWordLabel.setText(displayWord);
        imageLabel.setIcon(ErrorNumber.getImage(game.getMistakes()));
        historyLabel.setText("Guessed: " + game.getGuessedLetters());

        if (game.isSolved()) {
            JOptionPane.showMessageDialog(this, "You solved it! Word was: " + game.getSecretWord());
        } else if (game.isGameOver()) {
            JOptionPane.showMessageDialog(this, "Game over! Word was: " + game.getSecretWord());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            HangmanGUI gui = new HangmanGUI();
            gui.setVisible(true);
        });
    }
}
