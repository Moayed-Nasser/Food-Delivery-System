package fooddelivery;

public class CardPayment implements PaymentMethod {
    private static final double CARD_FEE_RATE = 0.02;

    @Override
    public double calculateAmount(double total) {
        return total * (1.0 + CARD_FEE_RATE);
    }
}
