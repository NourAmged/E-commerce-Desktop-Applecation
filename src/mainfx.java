import java.io.IOException;
import EcommerceClasses.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class mainfx {
    private Stage stage;
    private Parent root;

    @FXML
    private Label count, count2, 
    count3, name1, name2, name3, 
    price1, price2, price3, total1, 
    total2, total3;

    @FXML
    Button dec, dec2, dec3, checkOut;

    @FXML
    TextField name, id, address;


    ElectronicProduct smartphone = new ElectronicProduct(1, "smartphone", 599.9f, "Samsung", 12);
    ClothingProduct tShirt = new ClothingProduct(2, "T-shirt", 19.99f, "Medium", "Cotton");
    BookProduct book = new BookProduct(3, "OOP", 39.99f, "O’Reilly", "X Publications");


    public void initialize() {
        name1.setText(tShirt.getName());
        name2.setText(smartphone.getName());
        name3.setText(book.getName());

        price1.setText("$"+Float.toString(tShirt.getPrice()));
        price2.setText("$"+Float.toString(smartphone.getPrice()));
        price3.setText("$"+Float.toString(book.getPrice()));

        dec.setDisable(true);
        dec2.setDisable(true);
        dec3.setDisable(true);
        checkOut.setDisable(true);

    }

    private void checkCheckoutButton() {

        if (!name.getText().isEmpty() && !id.getText().isEmpty() && !address.getText().isEmpty()) {

            checkOut.setDisable(false);
        } else {

            checkOut.setDisable(true);
        }
    }


    private void updateLabel(Label label, int delta) {
        int num = Integer.parseInt(label.getText());
        label.setText(Integer.toString(num + delta));
    }

    private void updateTotalPrice(Label price, Label totalPrice, Label count){
        float total = Float.parseFloat(price.getText().replace("$", "")) * Integer.parseInt(count.getText());
        totalPrice.setText("$"+Float.toString(total));
    }

    private void btn(Button button, Label count){
        if(Integer.parseInt(count.getText()) > 0)
            button.setDisable(false);
        else
            button.setDisable(true);
    }

    private void cartFilling(Label count, Label productName, Cart cart){
        for(int i = 0; i < Integer.parseInt(count.getText()); i++){
            if(productName.getText() == smartphone.getName()){
                cart.addProduct(smartphone);
            }
            else if(productName.getText() == tShirt.getName()){
                cart.addProduct(tShirt);
            }
            else
                cart.addProduct(book);
        }
    }

    public void increment(ActionEvent e){
        updateLabel(count, 1);
        updateTotalPrice(price1, total1, count);
        btn(dec, count);
    }

    public void decrement(ActionEvent e){
        updateLabel(count, -1);
        btn(dec, count);
        updateTotalPrice(price1, total1, count);

        
    }

    public void increment2(ActionEvent e){
        updateLabel(count2, 1);
        updateTotalPrice(price2, total2, count2);
        btn(dec2, count2);

    }

    public void decrement2(ActionEvent e){
        updateLabel(count2, -1);
        btn(dec2, count2);
        updateTotalPrice(price2, total2, count2);
        
    }

    public void increment3(ActionEvent e){
        updateLabel(count3, 1);
        updateTotalPrice(price3, total3, count3);
        btn(dec3, count3);
    }

    public void decrement3(ActionEvent e){
        updateLabel(count3, -1);
        btn(dec3, count3);
        updateTotalPrice(price3, total3, count3);
        
    }

 
    public void nameField(ActionEvent e){
        checkCheckoutButton();
    }

    public void idField(ActionEvent e){
        checkCheckoutButton();
    }

    public void addressField(ActionEvent e){
        checkCheckoutButton();
    }

    public void checkout(ActionEvent e) throws IOException{

        Customer customer = new Customer(Integer.parseInt(id.getText()), name.getText(), address.getText());
        int size = Integer.parseInt(count.getText()) + Integer.parseInt(count2.getText()) + Integer.parseInt(count3.getText());
        Cart cart = new Cart(customer.getCustomerId(), size);

        cartFilling(count, name1, cart);
        cartFilling(count2, name2, cart);
        cartFilling(count3, name3, cart);

        Order order = cart.placeOrder();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("outputFX.fxml"));
        root = loader.load();

        outputScene output = loader.getController();

        output.displayOutput(order);

        stage = new Stage();

        stage.setScene(new Scene(root));

        stage.setTitle("Output");
        stage.getIcons().add(new Image("imgs-style/57589.png"));

        stage.show();



 
    }

}
