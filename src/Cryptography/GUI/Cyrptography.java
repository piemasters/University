package Cryptography.GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by David on 10/10/2014.
 */
public class Cyrptography {
    private JButton ISBNValidatorButton;
    private JButton creditCardValidatorButton;
    private JButton hamming64GeneratorButton;
    private JTextPane cyrptographyToolkitTextPane;
    private JTextPane selectAToolBelowTextPane;
    private JButton BCH106GeneratorButton;
    private JButton BCH106DecoderButton;

    public Cyrptography() {
        ISBNValidatorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ISBNValidator isbnFrame = new ISBNValidator();
                //isbnFrame.setVisible(true);
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
