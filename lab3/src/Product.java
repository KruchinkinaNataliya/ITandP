public class Product {
    private String name = "Apples";
    private String price = "89 руб";
    private String available_quantity; //доступное количество
    public Product() {
    }
    public Product(String name, String price, String available_quantity) {
        this.name = name;
        this.price = price;
        this.available_quantity = available_quantity;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }
    public String getAvailable_quantity() {
        return available_quantity;
    }
    public void setAvailable_quantity(String available_quantity) {
        this.available_quantity = available_quantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", available_quantity='" + available_quantity + '\'' +
                '}';
    }
}
