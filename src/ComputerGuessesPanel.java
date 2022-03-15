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
    private ComputerGuesses computerGuesses;


    // upperBound and lowerBound track the computer's knowledge about the correct number
    // They are updated after each guess is made
    private int upperBound; // correct number is <= upperBound
    private int lowerBound; // correct number is >= lowerBound

    public ComputerGuessesPanel(JPanel cardsPanel, Consumer<GameResult> gameFinishedCallback){
        computerGuesses = new ComputerGuesses(0,1,1000);


        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        JLabel guessMessage = new JLabel("I guess ___.");
        guessMessage.setAlignmentX(Component.LEFT_ALIGNMENT);
        addLabel(guessMessage, 40);

        JLabel prompt = new JLabel("Your number is...");
        addLabel(prompt, 10);

        JButton lowerBtn = new JButton("Lower");
        lowerBtn.addActionListener(e -> {
            guessMessage.setText(generateMessage(computerGuesses.calculateGuess(false,1)));
        });
        addButton(lowerBtn,10);

        JButton correctBtn = new JButton("Equal");
        correctBtn.addActionListener(e -> {
            gameOver(cardsPanel, gameFinishedCallback, guessMessage, computerGuesses);
            computerGuesses = new ComputerGuesses(0,1,1000);
        });
        addButton(correctBtn,10);

        JButton higherBtn = new JButton("Higher");
        higherBtn.addActionListener(e -> {
            guessMessage.setText(generateMessage(computerGuesses.calculateGuess(true,1)));
        });
        this.add(higherBtn);
        higherBtn.setAlignmentX(Component.CENTER_ALIGNMENT);


        this.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent e) {
                guessMessage.setText(generateMessage(computerGuesses.calculateGuess(0)));
            }
        });
    }

    private String generateMessage(int calculateGuess) {
        return "I guess " + calculateGuess + ".";
    }


    private void gameOver(JPanel cardsPanel, Consumer<GameResult> gameFinishedCallback, JLabel guessMessage, ComputerGuesses CG) {
        guessMessage.setText("I guess ___.");

        // Send the result of the finished game to the callback
        GameResult result = new GameResult(false, CG.getLastGuess(), CG.getNumGuesses());
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


}
