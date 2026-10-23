package parking.refactored;

public class Vehicle {
    private final String plate;
    private final VehicleTariff tariff;
    public Vehicle(String plate, VehicleTariff tariff) {
        this.plate = plate;
        this.tariff = tariff;
    }
    public String getPlate() {
        return plate;
    }
    public String getType() {
        return tariff.type();
    }
    public double fee(int hours) {
        return tariff.fee(hours);
    }
}
