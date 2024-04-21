package EcommerceClasses;
public class ElectronicProduct extends Product{
    private String brand;
    private int warrantyPeriod;
    

    public ElectronicProduct(int productId, String name, float price, String brand, int warrantyPeriod){
        super(productId, name, price);
        this.brand = brand;
        this.warrantyPeriod = Math.abs(warrantyPeriod);
    }

    ElectronicProduct(){
        brand = null;
        warrantyPeriod = 0;
    }

    public void setBrand(String brand){
        this.brand = brand;
    }

    public String getBrand(){
        return brand;
    }

    public void setWarrantyPeriod(int warrantyPeriod){
        this.warrantyPeriod = warrantyPeriod;
    }

    public int getWarrantyPeriod(){
        return warrantyPeriod;
    }
    
}
