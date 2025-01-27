import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class PursePanel extends JPanel {
    private Purse purse = new Purse();

    public void setPurse(Purse purse) {
        this.purse = purse;
        repaint(); // Triggers a repaint when the Purse is updated
    }
   public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (purse == null || purse.getCash().isEmpty()) {
            g.drawString("Purse is empty", 10, 20);
            return;
        }

        int x = 10; // The Initial x position
        int y = 30; // The Initial y position

        for (Map.Entry<Denomination, Integer> entry : purse.getCash().entrySet()) {
            Denomination denom = entry.getKey();
            int count = entry.getValue();

            ImageIcon icon = denom.getImageIcon();
            Image img = icon.getImage();

            for (int i = 0; i < count; i++) {
                g.drawImage(img, x, y, 50, 50, this); // Draws the image
                x += 60; // Moves x position for the next image
                if (x > getWidth() - 60) { // Wraps to the next line if needed
                    x = 10;
                    y += 60;
                }
            }
        }
    }
}
