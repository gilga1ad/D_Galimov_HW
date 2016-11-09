
public class Product {

    private int product_no;

    private String name;

    private String description;

    private double price;

    public Product(int product_no, String name, String description, double price) {
        this.product_no = product_no;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public void setProduct_no(int product_no) {
        this.product_no = product_no;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getProduct_no() {
        return product_no;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

}
