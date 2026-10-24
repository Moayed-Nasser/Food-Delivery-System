package fooddelivery;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Order {
    private static int nextOrderNumber = 1001;

    private final int orderNumber;
    private final String customerName;
    private final DeliveryOption delivery;
    private OrderStatus status;
    private final List<OrderLine> lines;

    public Order(String customerName, DeliveryOption delivery) {
        if (customerName == null || customerName.trim().isEmpty()) {
            throw new IllegalArgumentException("Customer name cannot be empty.");
        }
        if (delivery == null) {
            throw new IllegalArgumentException("Delivery option cannot be null.");
        }

        this.customerName = customerName;
        this.delivery = delivery;
        this.orderNumber = nextOrderNumber++;
        this.status = OrderStatus.NEW;
        this.lines = new ArrayList<OrderLine>();
    }

    public void addItem(MenuItem item) {
        addItem(item, 1);
    }

    public void addItem(MenuItem item, int quantity) {
        if (status != OrderStatus.NEW) {
            throw new IllegalStateException("Items can only be added to a NEW order.");
        }
        lines.add(new OrderLine(item, quantity));
    }

    public double getSubtotal() {
        double subtotal = 0;
        for (OrderLine line : lines) {
            subtotal += line.getLineTotal();
        }
        return subtotal;
    }

    public double getTotal() {
        return getSubtotal() + delivery.getFee();
    }

    public double pay(PaymentMethod method) {
        if (status != OrderStatus.NEW) {
            throw new IllegalStateException("Only a NEW order can be paid.");
        }
        if (lines.isEmpty()) {
            throw new IllegalStateException("An order must contain at least one item.");
        }
        if (method == null) {
            throw new IllegalArgumentException("Payment method cannot be null.");
        }

        double amount = method.calculateAmount(getTotal());
        if (!Double.isFinite(amount) || amount < 0) {
            throw new IllegalStateException("Payment amount is invalid.");
        }
        status = OrderStatus.PAID;
        return amount;
    }

    public void deliver() {
        if (status != OrderStatus.PAID) {
            throw new IllegalStateException("Only a PAID order can be delivered.");
        }
        status = OrderStatus.DELIVERED;
    }

    public void cancel() {
        if (status != OrderStatus.NEW) {
            throw new IllegalStateException("Only a NEW order can be cancelled.");
        }
        status = OrderStatus.CANCELLED;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public DeliveryOption getDelivery() {
        return delivery;
    }

    public List<OrderLine> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
