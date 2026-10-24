# Food Delivery System

## Project Description
Food Delivery System is a simple Java application developed using Object-Oriented Programming (OOP) principles.

The system allows a restaurant to manage customer orders, calculate food prices, handle payments, and track order status until delivery.

This project was developed as part of an Advanced Java OOP assignment.

## Features
- Create customer orders with automatically generated order numbers.
- Add meals and drinks with different quantities.
- Calculate prices based on toppings and drink sizes.
- Support standard and express delivery.
- Support cash and card payments.
- Calculate subtotal, delivery fees, and payment charges.
- Track order status (NEW, PAID, DELIVERED, CANCELLED).
- Prevent invalid order status changes.

## OOP Concepts Used
- **Encapsulation:** Using private attributes and public methods.
- **Inheritance:** Meal and Drink extend MenuItem.
- **Abstraction:** Using abstract classes and interfaces.
- **Polymorphism:** Different implementations of pricing, payment, and delivery.
- **Method Overloading:** Adding items with or without specifying a quantity.
- **Method Overriding:** Implementing different pricing methods.
- **Static Members:** Automatically generating order numbers.
- **Enums:** Managing order status.

## Project Structure
- **MenuItem.java:** Abstract class for menu items.
- **Meal.java:** Represents meals with extra toppings.
- **Drink.java:** Represents drinks with different sizes.
- **Order.java:** Manages customer orders.
- **OrderLine.java:** Stores ordered items and quantities.
- **OrderStatus.java:** Defines order statuses.
- **DeliveryOption.java:** Interface for delivery options.
- **StandardDelivery.java:** Standard delivery ($2).
- **ExpressDelivery.java:** Express delivery ($5).
- **PaymentMethod.java:** Interface for payment methods.
- **CashPayment.java:** Cash payment without additional fees.
- **CardPayment.java:** Card payment with a 2% fee.
- **Main.java:** Runs the application.
- **FoodDeliveryTests.java:** Tests the system functionality.

## Example

An order contains:
- 2 Burger Meals ($8 each + 1 extra topping)
- 1 Large Juice ($3 + $1)
- Express Delivery ($5)
- Card Payment (2% fee)

**Calculation:**

| Description | Price |
|---|---:|
| Burger Meals | $19.00 |
| Large Juice | $4.00 |
| Subtotal | $23.00 |
| Delivery | $5.00 |
| Total | $28.00 |
| Final Payment | **$28.56** |

## How to Run
1. Download or clone the repository.
2. Open Eclipse IDE.
3. Import the project into Eclipse.
4. Open `Main.java`.
5. Run as **Java Application**.
6. Check the output in the Console.

## Technologies
- Java
- Eclipse IDE
- UML Class Diagram

## UML Diagram
The UML class diagram is available in the `docs` folder.

It shows the classes, interfaces, attributes, methods, and relationships used in the system.
