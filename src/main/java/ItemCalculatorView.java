
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ItemCalculatorView extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("itemcalculator-view.fxml"));
        Scene scene = new Scene(loader.load());
        stage.setTitle("Shopping Cart");
        stage.setScene(scene);
        stage.show();
    }
}
