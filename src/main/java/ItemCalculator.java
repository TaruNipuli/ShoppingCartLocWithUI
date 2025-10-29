public class ItemCalculator {
    public double calculateItemTotal(double price, int quantity) {
        return price * quantity;
    }
    public double addToCartTotal(double cartTotal, double itemTotal) {
        return cartTotal + itemTotal;
    }
    public double calculateCartTotal(double currentTotal, double newItemTotal) {
        return currentTotal + newItemTotal;
    }
}
