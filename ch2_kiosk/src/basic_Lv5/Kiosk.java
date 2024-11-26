package basic_Lv5;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    private List<Menu> menus;

    public Kiosk(List<Menu> menus) {
        this.menus = menus;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            displayMainMenu();

            int choice = getIntInput(scanner, "정수를 입력해주세요.");
            if (choice == 0) {
                System.out.println("프로그램을 종료합니다.");
                exit = true;
            } else if (choice > 0 && choice <= menus.size()) {
                handleSubMenu(scanner, menus.get(choice - 1));
            } else {
                System.out.println("잘못된 입력입니다.");
            }
        }
    }

    private void displayMainMenu() {
        System.out.println("[ MAIN MENU ]");
        for (int i = 0; i < menus.size(); i++) {
            System.out.println((i + 1) + ". " + menus.get(i).getCategoryName());
        }
        System.out.println("0. 종료");
    }

    private void handleSubMenu(Scanner scanner, Menu menu) {
        menu.displayMenu();

        int subChoice = getIntInput(scanner, "정수를 입력해주세요.");
        if (subChoice == 0) {
            System.out.println("뒤로가기");
        } else if (subChoice > 0 && subChoice <= menu.getMenuItems().size()) {
            handleMenuItemSelection(menu.getMenuItems().get(subChoice - 1));
        } else {
            System.out.println("잘못된 선택지입니다.");
        }
    }

    private void handleMenuItemSelection(MenuItem selectedItem) {
        System.out.println("선택한 메뉴: " + selectedItem.getName() + " | W " + selectedItem.getPrice() + " | " + selectedItem.getDescription());
    }

    private int getIntInput(Scanner scanner, String errorMessage) {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println(errorMessage);
                scanner.next(); // 잘못된 입력 제거
            }
        }
    }
}
