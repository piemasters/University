package Cryptography.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;

/**
 * Created by David on 10/10/2014.
 */
public class Cryptography extends JFrame {

    JPanel rootPanel = new JPanel();
    JButton ISBNValidatorButton = new JButton();
    JButton creditCardValidatorButton = new JButton();
    JButton hamming64GeneratorButton = new JButton();
    JButton BCH106GeneratorButton = new JButton();
    JButton BCH106DecoderButton = new JButton();

    public Cryptography() {
        ISBNValidatorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                //Execute when button is pressed
                System.out.println("You clicked the button");
            }
        });
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI()  {

        JFrame rootPanel = new JFrame("JAVA");

        rootPanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton button = new JButton(" >> JavaProgrammingForums.com <<");
        //Add action listener to button
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e)
            {
                //Execute when button is pressed
                System.out.println("You clicked the button");
            }
        });

        rootPanel.getContentPane().add(button);
        rootPanel.pack();
        rootPanel.setVisible(true);
    }



}