import java.util.HashMap;
import java.util.Map;

public class Purse {
    private final Map<Denomination, Integer> cash = new HashMap<>();

    public void add(Denomination type, int num) {
        cash.put(type, cash.getOrDefault(type, 0) + num);
    }

    public double remove(Denomination type, int num) {
        if (!cash.containsKey(type) || cash.get(type) < num) {
            return 0.0;
        }
        cash.put(type, cash.get(type) - num);
        if (cash.get(type) == 0) {
            cash.remove(type);
        }
        return type.amt() * num;
    }

    public double getValue() {
        return cash.entrySet().stream().mapToDouble(e -> e.getKey().amt() * e.getValue()).sum();
    }

    public Map<Denomination, Integer> getCash() {
        return cash;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Purse contents:\n");
        for (Map.Entry<Denomination, Integer> entry : cash.entrySet()) {
            sb.append(entry.getValue()).append(" ").append(entry.getKey().name()).append("\n");
        }
        return sb.toString();
    }
}
