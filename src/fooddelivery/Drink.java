package fooddelivery;

public class Drink extends MenuItem {
    private static final double LARGE_FEE = 1.0;
    private final boolean isLarge;

    public Drink(String name, double basePrice, boolean isLarge) {
        super(name, basePrice);
        this.isLarge = isLarge;
    }

    @Override
    public double getFinalPrice() {
        return basePrice + (isLarge ? LARGE_FEE : 0.0);
    }

    public boolean isLarge() {
        return isLarge;
    }
}
