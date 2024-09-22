import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsWindow extends JFrame {
    private JTextField textField;
    private JButton oneButton, twoButton, threeButton, fourButton, fiveButton, sixButton, sevenButton, eightButton, nineButton, zeroButton;
    private JButton insertButton, clearButton, backButton;

    public SettingsWindow() {
        setTitle("Settings");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel titleLabel = new JLabel("Settings", SwingConstants.CENTER);
        titleLabel.setBounds(269, 14, 62, 31);
        add(titleLabel);

        JLabel pointLabel = new JLabel("Set Point:");
        pointLabel.setBounds(14, 206, 70, 20);
        add(pointLabel);

        textField = new JTextField();
        textField.setBounds(83, 185, 200, 30);
        add(textField);

        JPanel gridPanel = new JPanel(new GridLayout(3, 3, 5, 5));
        gridPanel.setBounds(334, 124, 187, 152);
        add(gridPanel);

        oneButton = createButton("1", gridPanel);
        twoButton = createButton("2", gridPanel);
        threeButton = createButton("3", gridPanel);
        fourButton = createButton("4", gridPanel);
        fiveButton = createButton("5", gridPanel);
        sixButton = createButton("6", gridPanel);
        sevenButton = createButton("7", gridPanel);
        eightButton = createButton("8", gridPanel);
        nineButton = createButton("9", gridPanel);

        zeroButton = new JButton("0");
        zeroButton.setBounds(334, 276, 124, 50);
        add(zeroButton);

        insertButton = new JButton("Enter");
        insertButton.setBounds(521, 123, 65, 203);
        add(insertButton);

        clearButton = new JButton("CLR");
        clearButton.setBounds(457, 275, 65, 50);
        add(clearButton);

        backButton = new JButton("OK");
        backButton.setBounds(14, 355, 105, 31);
        add(backButton);

        // Add action listeners
        backButton.addActionListener(e -> handleBack());
        oneButton.addActionListener(e -> handleOneAction());
        twoButton.addActionListener(e -> handleTwoAction());
        threeButton.addActionListener(e -> handleThreeAction());
        fourButton.addActionListener(e -> handleFourAction());
        fiveButton.addActionListener(e -> handleFiveAction());
        sixButton.addActionListener(e -> handleSixAction());
        sevenButton.addActionListener(e -> handleSevenAction());
        eightButton.addActionListener(e -> handleEightAction());
        nineButton.addActionListener(e -> handleNineAction());
        zeroButton.addActionListener(e -> handleZeroAction());
        insertButton.addActionListener(e -> handleInsertAction());
        clearButton.addActionListener(e -> handleClearAction());

        setVisible(true);
    }

    private JButton createButton(String text, JPanel panel) {
        JButton button = new JButton(text);
        button.setPreferredSize(new Dimension(62, 54));
        panel.add(button);
        return button;
    }

    // Action handler methods
    private void handleBack() {
        // handle the back button action
    }

    private void handleOneAction() {
        // handle button "1" action
    }

    private void handleTwoAction() {
        // handle button "2" action
    }

    private void handleThreeAction() {
        // handle button "3" action
    }

    private void handleFourAction() {
        // handle button "4" action
    }

    private void handleFiveAction() {
        // handle button "5" action
    }

    private void handleSixAction() {
        // handle button "6" action
    }

    private void handleSevenAction() {
        // handle button "7" action
    }

    private void handleEightAction() {
        // handle button "8" action
    }

    private void handleNineAction() {
        // handle button "9" action
    }

    private void handleZeroAction() {
        // handle button "0" action
    }

    private void handleInsertAction() {
        // handle the insert button action
    }

    private void handleClearAction() {
        // handle the clear button action
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SettingsWindow::new);
    }
}

