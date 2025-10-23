import java.util.Scanner;

public class ItemCalculator {

    // Calculates total cost for a single item
    public double calculateItemTotal(double price, int quantity) {
        return price * quantity;
    }

    // Adds an item's total to the current cart total
    public double addToCartTotal(double cartTotal, double itemTotal) {
        return cartTotal + itemTotal;
    }

    // Calculates the cart total
    public double calculateCartTotal(double currentTotal, double newItemTotal) {
        return currentTotal + newItemTotal;
    }
}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Ask user preferred language
        System.out.println("Select language");
        System.out.println("1. English");
        System.out.println("2. Finnish");
        System.out.println("3. Swedish");
        System.out.println("4. Japanese");

        String language = sc.nextLine();

        ItemCalculator calculator = new ItemCalculator();

        // Ask the user for the number of items
        System.out.println("Enter number of items:");
        int itemCount = sc.nextInt();
        double cartTotal = 0.0; // Initialize the cart total

        // Loop through each item
        for (int i = 1; i <= itemCount; i++) {
            System.out.println("Enter price of item " + i + ":");
            double price = sc.nextDouble();
            System.out.println("Enter quantity of item " + i + ":");
            int quantity = sc.nextInt();

            // Calculate total cost for item
            double totalCost = calculator.calculateItemTotal(price, quantity);
            // Add item's total to the cart total
            cartTotal = calculator.calculateCartTotal(cartTotal, totalCost);

            System.out.println("Total cost for item " + i + ": " + totalCost);
        }

        System.out.println("Total cost of all items: " + cartTotal);
    }
}
