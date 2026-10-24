package fooddelivery;

public class CashPayment implements PaymentMethod {
    @Override
    public double calculateAmount(double total) {
        return total;
    }
}
