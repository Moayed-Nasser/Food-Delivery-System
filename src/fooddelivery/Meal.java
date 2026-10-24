package fooddelivery;

public class Meal extends MenuItem {
    private static final double TOPPING_FEE = 1.5;
    private final int extraToppings;

    public Meal(String name, double basePrice, int extraToppings) {
        super(name, basePrice);
        if (extraToppings < 0) {
            throw new IllegalArgumentException("Extra toppings cannot be negative.");
        }
        this.extraToppings = extraToppings;
    }

    @Override
    public double getFinalPrice() {
        return basePrice + (extraToppings * TOPPING_FEE);
    }

    public int getExtraToppings() {
        return extraToppings;
    }
}
