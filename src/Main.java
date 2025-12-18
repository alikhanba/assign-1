public class Main {
    static void main() {
        Supplier mainSupplier = new Supplier("Global Tech", "contact@globaltech.com");
        Inventory warehouse = new Inventory("Main Warehouse", 500);

        Product p1 = new Product("Laptop", 400000.00, 15);
        Product p2 = new Product("Mouse", 15000.00, 15);

        System.out.println("--- System Setup ---");
        System.out.println(mainSupplier);
        System.out.println(warehouse);
        System.out.println("\n--- Current Products ---");
        System.out.println(p1);
        System.out.println(p2);

        System.out.println("\n--- Stock Comparison ---");
        if (p1.getQuantity() == p2.getQuantity()) {
            System.out.println("Both " + p1.getName() + " and " + p2.getName() + " have the same stock level: " + p1.getQuantity());
        } else {
            System.out.println("Stock levels are different.");
        }
    }
}
