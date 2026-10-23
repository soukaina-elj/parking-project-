package parking.refactored;

public class MotorbikeTariff implements VehicleTariff{
    public String type() {
        return "MOTORBIKE";
    }
    public double fee(int hours) {
        return hours * 2.0;
    }
}
