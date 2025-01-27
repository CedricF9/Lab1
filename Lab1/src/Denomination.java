import javax.swing.*;

public record Denomination(String name, double amt, String form, String img) {
    public ImageIcon getImageIcon() {
        return new ImageIcon(getClass().getResource(img));
    }
}
