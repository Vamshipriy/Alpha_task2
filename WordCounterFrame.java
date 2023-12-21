import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WordCounterFrame extends JFrame {
    private JLabel label;
    private JTextField textField;
    private JButton countButton;
    private JButton resetButton;

    public WordCounterFrame() {
        super("Word Counter");
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        label = new JLabel("Enter a paragraph:");
        add(label);

        textField = new JTextField(20);
        add(textField);

        countButton = new JButton("Count Words");
        countButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textField.getText();
                int wordCount = text.split("\\s+").length;
                JOptionPane.showMessageDialog(null, "The entered paragraph has " + wordCount + " words.");
            }
        });
        add(countButton);

        resetButton = new JButton("Reset");
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText("");
            }
        });
        add(resetButton);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new WordCounterFrame().setVisible(true);
            }
        });
    }
} 
