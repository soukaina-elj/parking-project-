package parking.refactored;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ParkingService {
    private final List<String> receipts = new ArrayList<>();
    private final ReceiptLogger logger;
    private final ReceiptFormatter formatter;
    private double total;
    public ParkingService(ReceiptLogger logger, ReceiptFormatter formatter) {
        this.logger = logger;
        this.formatter = formatter;
    }
    public double fee(Vehicle vehicle, int hours) {
        return vehicle.fee(hours);
    }
    public void checkout(Vehicle vehicle, int hours, PaymentMethod method)
            throws IOException {
        double amount = fee(vehicle, hours);
        method.pay(amount);
        total += amount;
        String receipt = formatter.formatReceipt(vehicle, hours, amount, method);
        receipts.add(receipt);
        logger.log(receipt);
    }
    public void cancel(Vehicle vehicle, int hours, RefundablePaymentMethod method) {
        double amount = fee(vehicle, hours);
        method.refund(amount);
        total -= amount;
    }
    public void cancelCashAtDesk(Vehicle vehicle, int hours) {
        double amount = fee(vehicle, hours);
        System.out.println("Refund " + amount + " MAD at the desk for "
                + vehicle.getPlate());
        total -= amount;
    }
    public String dailyReport() {
        return formatter.formatDailyReport(receipts, total);
    }
}
