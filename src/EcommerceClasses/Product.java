package EcommerceClasses;

public class Product {
    private int ProdouctId;
    private String name;
    private float price;

    Product(int ProdouctId, String name, float price){
        this.ProdouctId = Math.abs(ProdouctId);
        this.name = name;
        this.price = Math.abs(price);
    }

    Product(){
        ProdouctId = 0;
        name = null;
        price = 0;
    }

    public void setProdouctId(int ProdouctId){
        this.ProdouctId = ProdouctId;
    }

    public int getProdouctId(){
        return ProdouctId;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setPrice(float price){
        this.price = price;
    }

    public float getPrice(){
        return price;
    }

}
