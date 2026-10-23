package parking.refactored;

public class BusTariff  implements VehicleTariff{
    public String type() {
        return "BUS";
    }
    public double fee(int hours) {
        return hours * 15.0;
    }
}
