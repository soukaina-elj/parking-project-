package parking.refactored;

import java.util.ArrayList;
import java.util.List;

public class TestLogger  implements ReceiptLogger{
    private final List<String> receipts = new ArrayList<>();
    public void log(String line) {
        receipts.add(line);
    }
}
