import EcommerceClasses.Order;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class outputScene {
    @FXML
    private Label orderID, customerID, products, total;

    public void displayOutput(Order order){
        orderID.setText(Integer.toString(order.getOrderId()));
        customerID.setText(Integer.toString(order.getCustomerId()));
        products.setText(order.getStr());
        total.setText("$"+Float.toString(order.getTotalPrice()));
    }
}
