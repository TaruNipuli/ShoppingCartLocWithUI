import java.util.Locale;
import java.util.ResourceBundle;
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

        Locale.setDefault(new Locale("en", "US"));


        Scanner sc = new Scanner(System.in);
        // Ask user preferred language
        System.out.println("Select language");
        System.out.println("1. English");
        System.out.println("2. Finnish");
        System.out.println("3. Swedish");
        System.out.println("4. Japanese");

        int choice = sc.nextInt();

        String language;
        String country;

        switch (choice) {
            case 2:
                language = "fi";
                country = "FI";
                System.out.println("Valitsit kielen suomi");
                break;
            case 3:
                language = "sv";
                country = "SE";
                System.out.println("Du valde språket svenska");
                break;
            case 4:
                language = "ja";
                country = "JP";
                System.out.println("スウェーデン語を選択しました");
                break;
            default:
                language = "en";
                country = "US";
                System.out.println("You chose language English");
        }

        Locale locale = new Locale(language, country);
        ResourceBundle rb = ResourceBundle.getBundle("MessagesBundle", locale);


        ItemCalculator calculator = new ItemCalculator();

        // Ask the user for the number of items
        System.out.println(rb.getString("productCount"));
        int itemCount = sc.nextInt();
        double cartTotal = 0.0; // Initialize the cart total

        // Loop through each item
        for (int i = 1; i <= itemCount; i++) {
            System.out.println(rb.getString("itemPrice") + " " + i + ":");
            double price = sc.nextDouble();
            System.out.println(rb.getString("itemCount") + " " + i + ":");
            int quantity = sc.nextInt();

            // Calculate total cost for item
            double totalCost = calculator.calculateItemTotal(price, quantity);
            // Add item's total to the cart total
            cartTotal = calculator.calculateCartTotal(cartTotal, totalCost);

            System.out.println(rb.getString("price") + " " + i + ": " + totalCost);
        }

        System.out.println(rb.getString("price") + ": " + cartTotal);
    }
}
