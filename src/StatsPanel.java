import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Displays statistics about how many guesses the person took during past games
 * Loads data from the file and displays in a JPanel
 *
 * TODO: refactor this class
 */
public class StatsPanel extends JPanel {

    private final JPanel resultsPanel;

    // Stats will display the number of games in each "bin"
    // A bin goes from BIN_EDGES[i] through BIN_EDGES[i+1]-1, inclusive
    private Bins bins;
    private ArrayList<JLabel> resultsLabels;


    public StatsPanel(JPanel cardsPanel) {
        bins = new Bins();
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        JLabel title = new JLabel("Your Stats");
        this.add(title);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel subtitle = new JLabel("(Past 30 Days)");
        this.add(subtitle);
        subtitle.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.add(Box.createRigidArea(new Dimension(0,40)));

        resultsPanel = new JPanel();
        resultsLabels = new ArrayList<>();
        resultsPanel.setLayout(new GridLayout(0, 2));
        resultsPanel.add(new JLabel("Guesses"));
        resultsPanel.add(new JLabel("Games"));
        for(int binIndex=0; binIndex<bins.getBinsLength(); binIndex++){
            String binName = bins.setUpBin(binIndex);

            resultsPanel.add(new JLabel(binName));
            JLabel result = new JLabel("--");
            resultsLabels.add(result);
            resultsPanel.add(result);
        }

        resultsPanel.setMinimumSize(new Dimension(120, 120));
        this.add(resultsPanel);
        resultsPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        updateResultsPanel();

        this.add(Box.createVerticalGlue());

        JButton quit = new JButton("Back to Home");
        quit.addActionListener(e -> {
            // See itemStateChanged in https://docs.oracle.com/javase/tutorial/uiswing/examples/layout/CardLayoutDemoProject/src/layout/CardLayoutDemo.java
            CardLayout cardLayout = (CardLayout) cardsPanel.getLayout();
            cardLayout.show(cardsPanel, ScreenID.HOME.name());
        });
        this.add(quit);
        quit.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.add(Box.createRigidArea(new Dimension(0,20)));

        this.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent e) {
                updateResultsPanel();
            }
        });
    }




    private void clearResults(){
        for(JLabel lbl : resultsLabels){
            lbl.setText("--");
        }
    }

    private void updateResultsPanel(){
        clearResults();

        GameStats stats = new StatsFile();

        for(int binIndex=0; binIndex<bins.getBinsLength(); binIndex++){
            int numGames = bins.getGamesInBin(stats, binIndex);

            JLabel resultLabel = resultsLabels.get(binIndex);
            resultLabel.setText(Integer.toString(numGames));
        }
    }
}

