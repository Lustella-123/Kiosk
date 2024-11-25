package challenge_Lv2;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private String categoryName;
    private List<MenuItem<Double, String>> menuItems;

    public Menu(String categoryName) {
        this.categoryName = categoryName;
        this.menuItems = new ArrayList<>();
    }

    public String getCategoryName() {
        return categoryName;
    }

    public List<MenuItem<Double, String>> getMenuItems() {
        return menuItems;
    }

    public void addMenuItem(MenuItem<Double, String> item) {
        menuItems.add(item);
    }

    public void displayMenu() {
        System.out.println("[ " + categoryName.toUpperCase() + " MENU ]");
        menuItems.stream() // for문 스트림으로 교체
                .forEach(item -> System.out.println((menuItems.indexOf(item) + 1) + ". "
                        + item.getName() + " | W " + item.getPrice() + " | " + item.getDescription()));
        System.out.println("0. 뒤로가기");
    }
}
