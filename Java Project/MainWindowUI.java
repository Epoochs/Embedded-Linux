
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindowUI extends JFrame {
    
    private JFrame mainWindow;
    private JButton settingsButton;
    private JDialog secondWindow;
    private JPanel zoneOne;
    private JPanel zoneTwo;
    private JPanel zoneThree;
    private JPanel zoneFour;
    private JTextField textField;
    private String tempText = null;
    private int SetTemp;

    public MainWindowUI() {
        initialize();
    }
    public class FireAlarmApp {
        public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MainWindowUI();
        });
    }
}

    private void initialize() {
        mainWindow = this;
        mainWindow.setTitle("Main Window");
        mainWindow.setSize(1024, 600);
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setLayout(new BorderLayout());

        textField = new JTextField(20);
        
        settingsButton = new JButton("Settings");
        settingsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleSettings();
            }
        });

        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        controlPanel.add(textField);
        controlPanel.add(settingsButton);
        
        JPanel gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(2, 2));

        zoneOne = new JPanel();
        zoneOne.setBackground(Color.YELLOW);
        gridPanel.add(zoneOne);

        zoneTwo = new JPanel();
        zoneTwo.setBackground(Color.BLUE);
        gridPanel.add(zoneTwo);

        zoneThree = new JPanel();
        zoneThree.setBackground(Color.GREEN);
        gridPanel.add(zoneThree);

        zoneFour = new JPanel();
        zoneFour.setBackground(Color.RED);
        gridPanel.add(zoneFour);

        mainWindow.add(gridPanel, BorderLayout.CENTER);
        mainWindow.add(controlPanel, BorderLayout.SOUTH);
        
        new ZoneOne().start();
     /*   new ZoneTwo().start();
        new ZoneThree().start();
        new ZoneFour().start();*/

        mainWindow.setVisible(true);
    }

private void handleSettings() {
    if (secondWindow == null || !secondWindow.isShowing()) {
        secondWindow = new JDialog(mainWindow, "Settings", true); // true makes it modal
        secondWindow.setSize(300, 200);
        secondWindow.setLocationRelativeTo(mainWindow);
        secondWindow.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        secondWindow.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                secondWindow = null;
            }
        });

        secondWindow.setVisible(true);
    } else {
        secondWindow.toFront();
    }
}


    public class ZoneOne extends Thread {
        @Override
        public void run() {
            while (true) {
                tempText = textField.getText().trim();
                if (!tempText.isEmpty()) {
                try {
                    SetTemp = Integer.parseInt(tempText);
                    
                if (tempText.equals("50")) {
                    SwingUtilities.invokeLater(() -> {
                        zoneOne.setBackground(Color.WHITE);
                    });
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }

                    SwingUtilities.invokeLater(() -> {
                        zoneOne.setBackground(Color.YELLOW);
                    });
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
            }catch(NumberFormatException ex){
                System.out.println("Invalid input: " + tempText);
            }
            }
            }
        }
    }

   /* public class ZoneTwo extends Thread {
        @Override
        public void run() {
            while (true) {
                tempText = textField.getText();

                if (tempText.equals("50")) {
                    SwingUtilities.invokeLater(() -> {
                        zoneTwo.setBackground(Color.WHITE);
                    });
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }

                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            zoneTwo.setBackground(Color.BLUE);
                        }
                    });
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }
    }

    public class ZoneThree extends Thread {
        @Override
        public void run() {
            while (true) {
                tempText = textField.getText();

                if (tempText.equals("50")) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            zoneThree.setBackground(Color.WHITE);
                        }
                    });
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }

                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            zoneThree.setBackground(Color.GREEN);
                        }
                    });
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }
    }

    public class ZoneFour extends Thread {
        @Override
        public void run() {
            while (true) {
                tempText = textField.getText();

                if (tempText.equals("50")) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            zoneFour.setBackground(Color.WHITE);
                        }
                    });
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }

                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            zoneFour.setBackground(Color.RED);
                        }
                    });
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }
    }*/
}
