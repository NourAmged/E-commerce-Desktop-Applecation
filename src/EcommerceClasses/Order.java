package EcommerceClasses;
public class Order {
    private int customerId;
    private int orderId;
    private Product[] products;
    private float totalPrice;
    private String str = "";

    public Order(int customerId, Product[] products, float totalPrice) {
        this.customerId = Math.abs(customerId);
        this.orderId = 1;
        this.products = products;
        this.totalPrice = Math.abs(totalPrice);
    }

    public int getOrderId(){
        return this.orderId;
    }

    public String getStr(){
        for (Product product : products) {
            if (product != null) {
                String tmp = product.getName() +" - $" +product.getPrice() +'\n';
                str = str +tmp;
            }
        }

        return str;
    }

    public int getCustomerId(){
        return this.customerId;
    }

    public float getTotalPrice(){
        return this.totalPrice;
    }

    public void printOrderInfo() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Customer ID: " + customerId);
        System.out.println("Product:");
        for (Product product : products) {
            if (product != null) {
                String tmp = product.getName() +" - $" +product.getPrice() +'\n';
                System.out.printf("%s - $%.3f\n", product.getName(), product.getPrice());
                str = str +tmp;
            }
        }
        System.out.printf("Total Price: $%.3f\n", totalPrice);
    }
}
