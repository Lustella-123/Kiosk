package basic_Lv4;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    // MenuItem 클래스를 List로 관리
    String categoryName;
    List<MenuItem> menuItems;

    public Menu(String categoryName) {
        this.categoryName = categoryName;
        this.menuItems = new ArrayList<>();
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void addMenuItem(MenuItem item) {
        menuItems.add(item);
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    // List에 들어있는 MenuItem을 순차적으로 보여주는 함수
    public void displayMenu() {
        System.out.println("[ " + categoryName.toUpperCase() + " MENU ]");
        for (int i = 0; i < menuItems.size(); i++) {
            MenuItem item = menuItems.get(i);
            System.out.println((i + 1) + ". " + item.name + " | W " + item.price + " | " + item.description);
        }
        System.out.println("0. 뒤로가기");
    }
}
