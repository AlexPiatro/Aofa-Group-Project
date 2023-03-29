import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JPanel.*;

public class GUIdisplay extends JFrame implements ActionListener {

    private JTextArea displayScreen;
    private JButton updateGraphButton;
    private JButton maxFlowButton;
    private JButton displayGraphButton;
    private JButton clearDataButton;
    private JLabel maxFlowLabel;
    private JLabel sourceSinkLabel;
    

    public GUIdisplay() {
        super("Graph Window");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        
        // Creating the main panel with BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout());
        
        // Creating the display screen with thick stroke border
        displayScreen = new JTextArea();
        displayScreen.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2
        ));
        mainPanel.add(displayScreen, BorderLayout.CENTER);
        
        // Creating the button panel with FlowLayout
        JPanel buttonPanel = new JPanel(new FlowLayout());
        
        // Creating the update graph button
        updateGraphButton = new JButton("Update");
        updateGraphButton.addActionListener(this);
        buttonPanel.add(updateGraphButton);
        
        // Creating the max flow button
        maxFlowButton = new JButton("Max Flow");
        maxFlowButton.addActionListener(this);
        buttonPanel.add(maxFlowButton);
        
        // Creating the display graph button
        displayGraphButton = new JButton("Display");
        displayGraphButton.addActionListener(this);
        buttonPanel.add(displayGraphButton);
        
        // Creating the clear data button
        clearDataButton = new JButton("Clear");
        clearDataButton.addActionListener(this);
        buttonPanel.add(clearDataButton);
        
        // Adding the button panel to the main panel
        mainPanel.add(buttonPanel, BorderLayout.NORTH);
        
        // Creating the bottom panel with GridLayout
        JPanel bottomPanel = new JPanel(new GridLayout(1, 2));
        
        // Creating the max flow label
        maxFlowLabel = new JLabel("Max Flow: ");
        bottomPanel.add(maxFlowLabel);
        
        // Creating the source/sink label
        sourceSinkLabel = new JLabel("Source: , Sink: ");
        bottomPanel.add(sourceSinkLabel);
        
        // Adding the bottom panel to the main panel
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);
        
        // Adding the main panel to the frame
        add(mainPanel);
        
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == updateGraphButton) {
            displayScreen.setText("Update Graph data displayed");
        } else if (e.getSource() == maxFlowButton) {
            displayScreen.setText("Max Flow data displayed");
            maxFlowLabel.setText("Max Flow: 100"); // Example max flow value
        } else if (e.getSource() == displayGraphButton) {
            displayScreen.setText("Display Graph data displayed");
            sourceSinkLabel.setText("Source: A, Sink: B"); // Example source/sink values
        } else if (e.getSource() == clearDataButton) {
            displayScreen.setText("");
            maxFlowLabel.setText("Max Flow: ");
            sourceSinkLabel.setText("Source: and Sink: ");
        }
    }

    public static void main(String[] args) {
        new GUIdisplay();
    }
}
