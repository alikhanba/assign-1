public class Inventory {
    private String location;
    private int totalCapacity;

    public Inventory(String location, int totalCapacity) {
        this.location = location;
        this.totalCapacity = totalCapacity;
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