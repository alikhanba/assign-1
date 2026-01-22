import java.sql.*;

public class Inventory {
    private String location;
    private int totalCapacity;

    public Inventory(String location, int totalCapacity) {
        this.location = location;
        this.totalCapacity = totalCapacity;
    }

    public void addProduct(Product product){
       String sql = "Insert into products(name,price,quantity,brand) values (?,?,?,?)";
       try (Connection conn =DB.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){
           pstmt.setString(1,product.getName());
           pstmt.setDouble(2,product.getPrice());
           pstmt.setInt(3,product.getQuantity());

           if(product instanceof Electronics){
               pstmt.setString(4,((Electronics) product).getBrand());
           }else{
               pstmt.setNull(4,java.sql.Types.VARCHAR);
           }
           pstmt.executeUpdate();
           System.out.println("Product Added: "+product.getName());
       } catch (SQLException e) {
           System.out.println("Error:"+ e.getMessage());
       };
    }

    public void searchbyName(String name){
        System.out.println("searching for: "+name);
        String sql = "SELECT * FROM products WHERE name = ?";
        try(Connection conn = DB.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1,name);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()) {
                System.out.println("Product Found: " + rs.getString("name") + "Price: " + rs.getDouble("price") + "Brand: " + rs.getString("brand"));
            }else{
                System.out.println("Product Not Found");
        }
    }catch(SQLException e){
        System.out.println("Error:"+ e.getMessage());}
    }

    public void filterLowStock(int threshold){
       System.out.println("filtering low stock: "+threshold);
       String sql = "SELECT * FROM products WHERE quantity < ?";

       try(Connection conn = DB.getConnection();
       PreparedStatement pstmt = conn.prepareStatement(sql)){
           pstmt.setInt(1,threshold);
           ResultSet rs = pstmt.executeQuery();
           while(rs.next()){
               System.out.println("ID: "+ rs.getInt("id")+ "Name: "+ rs.getString("name")+ " Stock: "+ rs.getInt("quantity"));
           }} catch(SQLException e){
               System.out.println("Error: "+ e.getMessage());
           }
       }


    public void sortByPrice(){
       System.out.println("sorting by price from low to high");
       String sql = "SELECT * FROM products ORDER BY price ASC";
       try(Connection conn = DB.getConnection();
       Statement stmt = conn.createStatement();
       ResultSet rs = stmt.executeQuery(sql)){
           while(rs.next()){
               System.out.println("Price: " + rs.getDouble("price")+" NAME: "+ rs.getString("name"));
           }}catch(SQLException e){
               System.out.println("Error: "+ e.getMessage());
           }
       }


    public void displayAll(){
        System.out.println("Inventory at location: "+ location);
        String sql = "Select * FROM products";
        try(Connection conn = DB.getConnection();
         Statement stmt = conn.createStatement();
         ResultSet rs= stmt.executeQuery(sql)){
            while(rs.next()){
                int id=rs.getInt("id");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                String brand = rs.getString("brand");
                if(brand!=null) {
                    System.out.println("Electronics{name=" + name + "price=" + price + "quantity=" + quantity + "brand=" + brand + "}");
                }else{
                    System.out.println("Product{name=" + name + "price=" + price + "quantity=" + quantity + "}");
                }
            }} catch(SQLException e){
                System.out.println("error:" + e.getMessage());
            }
        }


    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public int getTotalCapacity() { return totalCapacity; }
    public void setTotalCapacity(int totalCapacity) { this.totalCapacity = totalCapacity; }

    @Override
    public String toString() {
        return "Inventory{location='" + location + "', capacity=" + totalCapacity + "}";
    }}
