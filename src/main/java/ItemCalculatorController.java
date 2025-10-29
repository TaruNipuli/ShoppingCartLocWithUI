
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.util.Locale;
import java.util.ResourceBundle;

public class ItemCalculatorController {

    @FXML
    private ComboBox<String> comboLanguage;
    @FXML
    private TextField txtPrice;
    @FXML
    private TextField txtQuantity;
    @FXML
    private Label lblItemTotal;
    @FXML
    private Label lblCartTotal;
    @FXML
    private Button btnCalculate;
    @FXML
    private Button btnAddToCart;
    @FXML
    private Button btnResetCart;

    private ItemCalculator calculator = new ItemCalculator();
    private double cartTotal = 0.0;
    private ResourceBundle rb;

    @FXML
    public void initialize() {
        comboLanguage.getItems().addAll("English", "Finnish", "Swedish", "Japanese");
        comboLanguage.getSelectionModel().selectFirst();

        setLocale("en", "US");

        btnCalculate.setOnAction(e -> calculateItemTotal());
        btnAddToCart.setOnAction(e -> addToCart());
        btnResetCart.setOnAction(e -> resetCart());

        comboLanguage.setOnAction(e -> {
            switch (comboLanguage.getValue()) {
                case "Finnish": setLocale("fi", "FI"); break;
                case "Swedish": setLocale("sv", "SE"); break;
                case "Japanese": setLocale("ja", "JP"); break;
                default: setLocale("en", "US");
            }
        });
    }

    private void setLocale(String language, String country) {
        Locale locale = new Locale(language, country);
        rb = ResourceBundle.getBundle("MessagesBundle", locale);

        // Käytetään olemassa olevia keyjä
        lblItemTotal.setText(rb.getString("itemPrice") + ": ");
        lblCartTotal.setText(rb.getString("price") + ": ");
    }

    private void calculateItemTotal() {
        try {
            double price = Double.parseDouble(txtPrice.getText());
            int quantity = Integer.parseInt(txtQuantity.getText());
            double total = calculator.calculateItemTotal(price, quantity);
            lblItemTotal.setText(rb.getString("itemPrice") + ": " + total);
        } catch (NumberFormatException e) {
            showAlert("Invalid input", "Please enter numeric values for price and quantity.");
        }
    }

    private void addToCart() {
        try {
            double price = Double.parseDouble(txtPrice.getText());
            int quantity = Integer.parseInt(txtQuantity.getText());
            double total = calculator.calculateItemTotal(price, quantity);
            cartTotal = calculator.calculateCartTotal(cartTotal, total);
            lblCartTotal.setText(rb.getString("price") + ": " + cartTotal);
        } catch (NumberFormatException e) {
            showAlert("Invalid input", "Please enter numeric values for price and quantity.");
        }
    }

    private void resetCart() {
        cartTotal = 0.0;
        lblCartTotal.setText(rb.getString("price") + ": " + cartTotal);
        lblItemTotal.setText(rb.getString("itemPrice") + ": ");
        txtPrice.clear();
        txtQuantity.clear();
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
