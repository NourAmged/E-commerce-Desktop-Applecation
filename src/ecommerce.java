import java.util.Scanner;
import EcommerceClasses.*;



public class ecommerce {

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        ElectronicProduct smartphone = new ElectronicProduct(1, "smartphone", 599.9f, "Samsung", 12);
        ClothingProduct tShirt = new ClothingProduct(2, "T-shirt", 19.99f, "Medium", "Cotton");
        BookProduct book = new BookProduct(3, "OOP", 39.99f, "“O’Reilly", "X Publications");
        
        String name, address;

        System.out.print("Please enter your ID: \n");
        int id = input.nextInt();

        System.out.print("Please enter your name: \n");
        name = input.next();

        System.out.print("Please enter your address: \n");
        address = input.next();

        Customer customer = new Customer(id, name, address);


        System.out.println("How many products you want to add to your cart ? ");
        int n = input.nextInt();


        Cart cart = new Cart(customer.getCustomerId(), n);

        while (n > 0) {
            int chose = 0;
            System.out.printf("Which product would you like to add? 1- %s 2- %s 3- %s\n",smartphone.getName(), tShirt.getName(), book.getName());
            chose = input.nextInt();
            switch (chose) {
                case 1:
                    cart.addProduct(smartphone);
                    n--;
                    break;

                case 2:
                    cart.addProduct(tShirt);
                    n--;
                    break;

                case 3:
                    cart.addProduct(book);
                    n--;
                    break;
                default:
                    System.out.println("Invalid chose");
                    break;
            }
        }
        System.out.println("Your total is $"+cart.getTotalPrice() +". Would you like to place the order? 1- yes 2- No");
        int place = input.nextInt();
        if(place == 1){
            System.out.println("Here's your order's summary:");
            Order order = cart.placeOrder();
            order.printOrderInfo();
        }

        input.close();
    }
}
    