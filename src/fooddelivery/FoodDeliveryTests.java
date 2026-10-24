package fooddelivery;

public class FoodDeliveryTests {
    private static int passed = 0;

    private static void expect(boolean condition, String description) {
        if (!condition) {
            throw new AssertionError("FAILED: " + description);
        }
        passed++;
        System.out.println("PASS: " + description);
    }

    private static void expectEquals(double actual, double expected, String description) {
        expect(Math.abs(actual - expected) < 0.0000001, description);
    }

    private static void expectFailure(Runnable action, String description) {
        try {
            action.run();
            throw new AssertionError("FAILED: " + description + " (no exception)");
        } catch (IllegalArgumentException | IllegalStateException expected) {
            passed++;
            System.out.println("PASS: " + description);
        }
    }

    public static void main(String[] args) {
        MenuItem burger = new Meal("Burger", 8.0, 1);
        MenuItem juice = new Drink("Juice", 3.0, true);
        expectEquals(burger.getFinalPrice(), 9.5, "Meal topping fee");
        expectEquals(juice.getFinalPrice(), 4.0, "Large drink fee");
        expectEquals(new Drink("Small", 3.0, false).getFinalPrice(), 3.0, "Small drink");

        Order order = new Order("Test", new ExpressDelivery());
        int firstNumber = order.getOrderNumber();
        expect(order.getStatus() == OrderStatus.NEW, "Initial status is NEW");
        order.addItem(burger, 2);
        order.addItem(juice);
        expect(order.getLines().size() == 2, "Two order lines");
        expect(order.getLines().get(1).getQuantity() == 1, "Default quantity is 1");
        expectEquals(order.getSubtotal(), 23.0, "Assignment subtotal");
        expectEquals(order.getTotal(), 28.0, "Assignment total with delivery");
        expectFailure(order::deliver, "Cannot deliver before payment");
        expectEquals(order.pay(new CardPayment()), 28.56, "Card payment is $28.56");
        expect(order.getStatus() == OrderStatus.PAID, "Pay changes status to PAID");
        expectFailure(() -> order.addItem(juice), "Cannot add items after payment");
        expectFailure(order::cancel, "Cannot cancel after payment");
        expectFailure(() -> order.pay(new CashPayment()), "Cannot pay twice");
        order.deliver();
        expect(order.getStatus() == OrderStatus.DELIVERED, "Deliver changes status");
        expectFailure(order::deliver, "Cannot deliver twice");

        Order cashOrder = new Order("Cash", new StandardDelivery());
        expect(cashOrder.getOrderNumber() == firstNumber + 1, "Order number increments");
        expectFailure(() -> cashOrder.pay(new CashPayment()), "Cannot pay empty order");
        expectFailure(() -> cashOrder.addItem(juice, 0), "Reject zero quantity");
        cashOrder.addItem(new Meal("Sandwich", 5.0, 0));
        expectEquals(cashOrder.pay(new CashPayment()), 7.0, "Cash has no fee");

        Order cancelled = new Order("Cancelled", new StandardDelivery());
        cancelled.addItem(juice);
        cancelled.cancel();
        expect(cancelled.getStatus() == OrderStatus.CANCELLED, "Cancel NEW order");
        expectFailure(() -> cancelled.addItem(juice), "Cannot add after cancellation");
        expectFailure(() -> cancelled.pay(new CashPayment()), "Cannot pay cancelled order");

        DeliveryOption otherDelivery = () -> 7.5;
        Order custom = new Order("Custom", otherDelivery);
        custom.addItem(new Drink("Tea", 2.0, false));
        expectEquals(custom.getTotal(), 9.5, "New delivery option without changing Order");
        System.out.println("-----------------------------");
        System.out.println("All " + passed + " checks passed.");
    }
}
