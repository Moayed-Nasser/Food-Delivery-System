package fooddelivery;

public abstract class MenuItem {
    protected final String name;
    protected final double basePrice;

    public MenuItem(String name, double basePrice) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Item name cannot be empty.");
        }
        if (!Double.isFinite(basePrice) || basePrice < 0) {
            throw new IllegalArgumentException("Base price must be a non-negative number.");
        }
        this.name = name;
        this.basePrice = basePrice;
    }

    public abstract double getFinalPrice();

    public String getName() {
        return name;
    }

    public double getBasePrice() {
        return basePrice;
    }
}
