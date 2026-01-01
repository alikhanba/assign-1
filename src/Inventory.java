import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Inventory {
    private String location;
    private int totalCapacity;
    private List<Product> products;

    public Inventory(String location, int totalCapacity) {
        this.location = location;
        this.totalCapacity = totalCapacity;
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product){
        if(product.size()<totalCapacity){
            products.add(product);
        }
        else{
            System.out.println("Invetory is full");
        }
    }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public int getTotalCapacity() { return totalCapacity; }
    public void setTotalCapacity(int totalCapacity) { this.totalCapacity = totalCapacity; }

    @Override
    public String toString() {
        return "Inventory{location='" + location + "', capacity=" + totalCapacity + "}";
    }
}