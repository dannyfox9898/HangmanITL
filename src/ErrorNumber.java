import javax.swing.*;

public class ErrorNumber {
    private static final String[] IMAGES = {
            "resources/hangman1.png",
            "resources/hangman2.png",
            "resources/hangman3.png",
            "resources/hangman4.png",
            "resources/hangman5.png",
            "resources/hangman6.png",
            "resources/hangman7.png",
            "resources/hangman8.png",
            "resources/hangman9.png",
            "resources/hangman10.png"
    };

    public static ImageIcon getImage(int mistakes) {
        if (mistakes < 0 ) mistakes = 0;
        if (mistakes >= IMAGES.length) mistakes = IMAGES.length - 1;

        java.net.URL imgURL = ErrorNumber.class.getResource(IMAGES[mistakes]);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.out.println("Image not found: " + IMAGES[mistakes]);
            return new ImageIcon();
        }
    }
}
