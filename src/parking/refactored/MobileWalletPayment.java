package parking.refactored;


public class MobileWalletPayment implements RefundablePaymentMethod{
    public String name() {
        return "MOBILE WALLET";
    }
    public void pay(double amount) {
        System.out.println("[MOBILE WALLET] paid " + amount + " MAD");
    }
    public void refund(double amount) {
        System.out.println("[MOBILE WALLET] refunded " + amount + " MAD");
    }
}
