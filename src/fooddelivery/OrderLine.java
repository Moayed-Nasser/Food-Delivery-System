package fooddelivery;

public class OrderLine {
    private final MenuItem item;
    private final int quantity;

    public OrderLine(MenuItem item, int quantity) {
        if (item == null) {
            throw new IllegalArgumentException("Menu item cannot be null.");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero.");
        }
        this.item = item;
        this.quantity = quantity;
    }

    public double getLineTotal() {
        return item.getFinalPrice() * quantity;
    }

    public MenuItem getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }
}
