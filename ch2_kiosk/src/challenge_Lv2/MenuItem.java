package challenge_Lv2;

public class MenuItem {
    private String name;
    private double price;
    private String description;

    public MenuItem(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    // Getter and Setter
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }


    public String getDescription() {
        return description;
    }
}
