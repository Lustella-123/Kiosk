package Lv5;

import java.util.List;
import java.util.Scanner;

public class Kiosk {
    private List<Menu> menus;

    public Kiosk(List<Menu> menus) {
        this.menus = menus;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("[ MAIN MENU ]");
            for (int i = 0; i < menus.size(); i++) {
                System.out.println((i + 1) + ". " + menus.get(i).getCategoryName());
            }
            System.out.println("0. 종료");

            int choice = scanner.nextInt();

            if (choice == 0) {
                System.out.println("프로그램을 종료합니다.");
                break;
            } else if (choice > 0 && choice <= menus.size()) {
                menus.get(choice - 1).displayMenu();
                int subChoice = scanner.nextInt();

                if (subChoice == 0) {
                    continue;
                } else if (subChoice > 0 && subChoice <= menus.get(choice - 1).getMenuItems().size()) {
                    MenuItem selectedItem = menus.get(choice - 1).getMenuItems().get(subChoice - 1);
                    System.out.println("선택한 메뉴: " + selectedItem.getName() + " | W " + selectedItem.getPrice() + " | " + selectedItem.getDescription());
                } else {
                    System.out.println("잘못된 선택지입니다.");
                }
            } else {
                System.out.println("잘못된 입력입니다.");
            }
        }
    }
}
