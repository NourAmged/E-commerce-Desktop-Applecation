package EcommerceClasses;

public class Cart {
    private int customerId;
    private int nProducts;
    private Product[] products;
    private int i = 0;

    public Cart(int customerId, int nProducts){
        this.customerId = customerId;
        this.nProducts = nProducts;
        this.products = new Product[nProducts];
        
    }


    public Cart(){
        this.customerId = 1;
        this.nProducts = 1;
        this.products = new Product[1];
        
    }

    public void setnProducts(int nProducts){
        this.nProducts = nProducts;

    }

    public int getnProducts(){
        return nProducts;
    }

    public void setCustomerId(int customerId){
        this.customerId = customerId;
    }

    public int getnCustomerId(){
        return customerId;
    }

    public void addProduct(Product p){
        products[i++] = p;
    }
    
    public float getTotalPrice(){
        return this.calculatePrice();
    }

    public float calculatePrice() {
        float totalPrice = 0;
        for (int i = 0; i < nProducts; i++) {
            totalPrice += products[i].getPrice();
        }
        return totalPrice;
    }

    public void removeProduct(){
        products[i++] = null;
    }

    public Order placeOrder() {
        return new Order(this.customerId, this.products, this.calculatePrice());
    }
}
