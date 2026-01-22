import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Supplier mainSupplier = new Supplier("Lenovo", "contact@lenovo.com");
        Inventory warehouse = new Inventory("Main Warehouse", 500);

        System.out.println("System Setup");
        System.out.println(mainSupplier);
        System.out.println(warehouse.getLocation());

        boolean running  = true;
        while(running){
            System.out.println("inventory menu");
            System.out.println("1. Add Product");
            System.out.println("2. Display All Products");
            System.out.println("3. Search product");
            System.out.println("4. Filter low stock");
            System.out.println("5. Sort by price");
            System.out.println("6. Exit ");
            System.out.print("choice: ");
            try{
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice){
                case 1:
                    System.out.println("Enter name");
                    String name = sc.nextLine();
                    System.out.println("Enter price");
                    double price = sc.nextDouble();
                    System.out.println("Enter quantity");
                    int quantity = sc.nextInt();
                    warehouse.addProduct(new Product(name,price,quantity));
                    break;
                case 2:
                    warehouse.displayAll();
                    break;
                case 3:
                    System.out.println("Enter product name: ");
                    warehouse.searchbyName(sc.nextLine());
                    break;
                case 4:
                    System.out.println("Enter threshold: ");
                    warehouse.filterLowStock(sc.nextInt());
                    break;
                case 5:
                    warehouse.sortByPrice();
                    break;
                case 6:
                    running = false;
                    break;
                    default:
                        System.out.println("Invalid choice");
            }}catch(Exception e){
                System.out.println("Input error");
                sc.nextLine();
                }
        }
        sc.close();
    }
}
