import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemCalculatorTest {

    @Test
    void testCalculateItemTotal() {
        ItemCalculator calculator = new ItemCalculator();

        assertEquals(20.0, calculator.calculateItemTotal(5.0, 4));
        assertEquals(10.0, calculator.calculateItemTotal(5.0, 2));
    }

    @Test
    void testAddToCartTotal() {
        ItemCalculator calculator = new ItemCalculator();

        assertEquals(30.0, calculator.addToCartTotal(10.0, 20.0));
        assertEquals(15.0, calculator.addToCartTotal(5.0, 10.0));
    }

    @Test
    void testCalculateCartTotal() {
        ItemCalculator calculator = new ItemCalculator();
        double grandTotal = 0.0;

        double item1Total = calculator.calculateItemTotal(5.0, 2);
        grandTotal = calculator.addToCartTotal(grandTotal, item1Total); // total now 10.0

        double item2Total = calculator.calculateItemTotal(3.0, 4); // add 3x4=12
        grandTotal = calculator.addToCartTotal(grandTotal, item2Total); // total now 22.0

        double item3Total = calculator.calculateItemTotal(2.5, 6); // add 2.5x6=15
        grandTotal = calculator.addToCartTotal(grandTotal, item3Total); // total now 37.0

        assertEquals(37.0, grandTotal);

    }
}