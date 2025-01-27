import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterPanel extends JPanel {
    private Register register = new Register();
    private JTextField input = new JTextField(10);
    private PursePanel changePanel = new PursePanel(); // Panel to display images

    public RegisterPanel() {
        setLayout(new BorderLayout());
        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Enter amount: "));
        inputPanel.add(input);

        input.addActionListener(new InputListener());
        add(inputPanel, BorderLayout.NORTH);
        add(changePanel, BorderLayout.CENTER); // This Adds changePanel to display images
    }

    private class InputListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                double amt = Double.parseDouble(input.getText());
                Purse purse = register.makeChange(amt);
                changePanel.setPurse(purse); // This Passes the Purse to PursePanel
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(RegisterPanel.this, "Invalid amount entered.");
            }
        }
    }
}
