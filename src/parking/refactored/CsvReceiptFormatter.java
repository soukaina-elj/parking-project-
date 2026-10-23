package parking.refactored;
import java.util.List;

public class CsvReceiptFormatter extends ReceiptFormatter {
    public String formatDailyReport(List<String> receipts, double total) {
        StringBuilder sb = new StringBuilder("Plate,Type,Hours,Amount,Payment\n");
        for (String receipt : receipts) {
            sb.append(receipt.replace(" | ", ",")).append("\n");
        }
        sb.append("Total,,,").append(total).append(",");
        return sb.toString();
    }
}
