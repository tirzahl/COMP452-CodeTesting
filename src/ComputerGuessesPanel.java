import javax.swing.*;
import java.awt.*;
import java.util.function.Consumer;

/**
 * UI screen for when the computer is guessing a number
 *
 * Displays the computer's guesses and processes human's answers
 * Tracks the computer's guesses
 *
 * TODO: refactor this class -> Refactored
 */
public class ComputerGuessesPanel extends JPanel {

    private int numGuesses;
    private int lastGuess;

    // upperBound and lowerBound track the computer's knowledge about the correct number
    // They are updated after each guess is made
    private int upperBound; // correct number is <= upperBound
    private int lowerBound; // correct number is >= lowerBound

    public ComputerGuessesPanel(JPanel cardsPanel, Consumer<GameResult> gameFinishedCallback){
        numGuesses = 0;
        upperBound = 1000;
        lowerBound = 1;

        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        JLabel guessMessage = new JLabel("I guess ___.");
        guessMessage.setAlignmentX(Component.LEFT_ALIGNMENT);
        addLabel(guessMessage, 40);

        JLabel prompt = new JLabel("Your number is...");
        addLabel(prompt, 10);

        JButton lowerBtn = new JButton("Lower");
        lowerBtn.addActionListener(e -> {
            upperBound = Math.min(upperBound, lastGuess);

            calculateGuess(guessMessage);
        });
        addButton(lowerBtn,10);

        JButton correctBtn = new JButton("Equal");
        correctBtn.addActionListener(e -> {
            gameOver(cardsPanel, gameFinishedCallback, guessMessage);
        });
        addButton(correctBtn,10);

        JButton higherBtn = new JButton("Higher");
        higherBtn.addActionListener(e -> {
            lowerBound = Math.max(lowerBound, lastGuess + 1);

            calculateGuess(guessMessage);
        });
        this.add(higherBtn);
        higherBtn.setAlignmentX(Component.CENTER_ALIGNMENT);


        this.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent e) {
                numGuesses = -1;
                upperBound = 1000;
                lowerBound = 1;

                calculateGuess(guessMessage);
            }
        });
    }

    private void gameOver(JPanel cardsPanel, Consumer<GameResult> gameFinishedCallback, JLabel guessMessage) {
        guessMessage.setText("I guess ___.");

        // Send the result of the finished game to the callback
        GameResult result = new GameResult(false, lastGuess, numGuesses);
        gameFinishedCallback.accept(result);

        CardLayout cardLayout = (CardLayout) cardsPanel.getLayout();
        cardLayout.show(cardsPanel, ScreenID.GAME_OVER.name());
    }

    private void addButton(JButton button, int height) {
        this.add(button);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(Box.createRigidArea(new Dimension(0, height)));
    }

    private void addLabel(JLabel label, int height) {
        this.add(label);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(Box.createRigidArea(new Dimension(0, height)));
    }

    private void calculateGuess(JLabel guessMessage) {
        lastGuess = (lowerBound + upperBound + 1) / 2;
        numGuesses += 1;
        guessMessage.setText("I guess " + lastGuess + ".");
    }

}
