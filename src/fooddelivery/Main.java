package fooddelivery;

public class Main {
    public static void main(String[] args) {
       
        MenuItem burger = new Meal("Burger Meal", 8.0, 1);
        MenuItem juice = new Drink("Large Juice", 3.0, true);

        Order order = new Order("Ahmad", new ExpressDelivery());
        order.addItem(burger, 2);   
        order.addItem(juice);       

        System.out.println("Order Number : " + order.getOrderNumber());
        System.out.println("Customer     : " + order.getCustomerName());
        System.out.println("Status       : " + order.getStatus());
        System.out.printf("Burger x2    : $%.2f%n", burger.getFinalPrice() * 2);
        System.out.printf("Juice x1     : $%.2f%n", juice.getFinalPrice());
        System.out.printf("Subtotal     : $%.2f%n", order.getSubtotal());
        System.out.printf("Delivery     : $%.2f%n", order.getDelivery().getFee());
        System.out.printf("Total        : $%.2f%n", order.getTotal());

        double paidAmount = order.pay(new CardPayment());
        System.out.printf("Card payment : $%.2f%n", paidAmount);
        System.out.println("Status       : " + order.getStatus());

        order.deliver();
        System.out.println("After delivery: " + order.getStatus());

        Order secondOrder = new Order("Sara", new StandardDelivery());
        secondOrder.addItem(new Drink("Water", 1.5, false));
        System.out.println("-----------------------------");
        System.out.println("Next order number: " + secondOrder.getOrderNumber());
        System.out.printf("Cash payment: $%.2f%n", secondOrder.pay(new CashPayment()));
    }
}
