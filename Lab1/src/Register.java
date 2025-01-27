import javax.swing.*;
import java.util.List;

public class Register {
    private static final List<Denomination> DENOMINATIONS = List.of(
            new Denomination("Fifty-Dollar Note", 50.0, "bill", "/images/fifty.jpg"),
            new Denomination("Twenty-Dollar Note", 20.0, "bill", "/images/twenty.jpg"),
            new Denomination("Ten-Dollar Note", 10.0, "bill", "/images/ten.jpg"),
            new Denomination("Five-Dollar Note", 5.0, "bill", "/images/five.jpg"),
            new Denomination("One-Dollar Note", 1.0, "bill", "/images/one.jpg"),
            new Denomination("Quarter", 0.25, "coin", "/images/quarter.jpg"),
            new Denomination("Dime", 0.10, "coin", "/images/dime.jpg"),
            new Denomination("Nickel", 0.05, "coin", "/images/nickel.jpg"),
            new Denomination("Penny", 0.01, "coin", "/images/penny.jpg")
    );

    public Purse makeChange(double amt) {
        Purse purse = new Purse();
        if (amt <= 0) {
            return purse;
        }

        for (Denomination denom : DENOMINATIONS) {
            int count = (int) (amt / denom.amt());
            if (count > 0) {
                purse.add(denom, count);
                amt -= count * denom.amt();
                amt = Math.round(amt * 100.0) / 100.0; // Avoid floating-point precision issues
            }
        }
        return purse;
    }
}
