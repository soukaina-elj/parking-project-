package parking.refactored;

public class CarTariff implements VehicleTariff{
    public String type() {
        return "CAR";
    }
    public double fee(int hours) {
        return hours * 5.0;
    }
}

