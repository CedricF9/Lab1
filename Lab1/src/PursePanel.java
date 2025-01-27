import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class PursePanel extends JPanel {
    private Purse purse = new Purse();

    public void setPurse(Purse purse) {
        this.purse = purse;
        repaint(); // Trigger a repaint when the Purse is updated
    }
   publuc void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (purse == null || purse.getCash().isEmpty()) {
            g.drawString("Purse is empty", 10, 20);
            return;
        }

        int x = 10; // Initial x position
        int y = 30; // Initial y position

        for (Map.Entry<Denomination, Integer> entry : purse.getCash().entrySet()) {
            Denomination denom = entry.getKey();
            int count = entry.getValue();

            // Draw images for each denomination
            ImageIcon icon = denom.getImageIcon();
            Image img = icon.getImage();

            for (int i = 0; i < count; i++) {
                g.drawImage(img, x, y, 50, 50, this); // Draw the image
                x += 60; // Move x position for the next image
                if (x > getWidth() - 60) { // Wrap to the next line if needed
                    x = 10;
                    y += 60;
                }
            }
        }
    }
}
