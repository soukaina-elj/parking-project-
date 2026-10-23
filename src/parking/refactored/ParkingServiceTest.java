package parking.refactored;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ParkingServiceTest {
    public static void main(String[] args) throws IOException {
        ReceiptLogger logger = new TestLogger();
        ReceiptFormatter formatter = new ReceiptFormatter();
        ParkingService garage = new ParkingService(logger, formatter);
        Vehicle car = new Vehicle("12345-A-6", new CarTariff());
        Vehicle bike = new Vehicle("67890-B-1", new MotorbikeTariff());
        Vehicle truck = new Vehicle("24680-D-8", new TruckTariff());
        if (garage.fee(car, 3) != 15.0) {
            throw new RuntimeException("Incorrect car fee");
        }
        if (garage.fee(bike, 2) != 4.0) {
            throw new RuntimeException("Incorrect motorbike fee");
        }
        if (garage.fee(truck, 4) != 60.0) {
            throw new RuntimeException("Incorrect truck fee");
        }
        RefundablePaymentMethod card = new CardPayment("4242");
        PaymentMethod cash = new CashPayment();
        garage.checkout(car, 3, card);
        garage.checkout(bike, 2, cash);
        garage.checkout(truck, 4, card);
        garage.cancelCashAtDesk(bike, 2);
        garage.cancel(truck, 4, card);
        String report = garage.dailyReport();
        if (!report.endsWith("Total: 15.0 MAD")) {
            throw new RuntimeException("Incorrect daily total");
        }
        System.out.println("All tests passed!");
    }
}


