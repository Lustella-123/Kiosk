package basic_Lv4;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    private List<Menu> menus;

    public Kiosk(List<Menu> menus) {
        this.menus = menus;
    }

    public void start() {
        // 스캐너 선언
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        // 반복문 시작
        while (!exit) {
            // 메인메뉴 화면
            System.out.println("[ MAIN MENU ]");
            for (int i = 0; i < menus.size(); i++) {
                System.out.println((i + 1) + ". " + menus.get(i).getCategoryName());
            }
            System.out.println("0. 종료");
            // 메인메뉴 화면 끝

            // 메인메뉴 선택
            while (true) {
                try {
                    int choice = scanner.nextInt();
                    if (choice == 0) {
                        System.out.println("프로그램을 종료합니다.");
                        exit = true;
                        break;
                    } else if (choice > 0 && choice <= menus.size()) {
                        menus.get(choice - 1).displayMenu(); // 세부메뉴 화면
                        int subChoice = scanner.nextInt(); // 세부메뉴 선택

                        if (subChoice == 0) {
                            System.out.println("뒤로가기");
                            break;
                        } else if (subChoice > 0 && subChoice <= menus.get(choice - 1).getMenuItems().size()) {
                            MenuItem selectedItem = menus.get(choice - 1).getMenuItems().get(subChoice - 1);
                            System.out.println("선택한 메뉴: " + selectedItem.name + " | W " + selectedItem.price + " | " + selectedItem.description);
                            break;
                        } else {
                            System.out.println("잘못된 선택지입니다.");
                        }
                    } else {
                        System.out.println("잘못된 입력입니다.");
                    }
                } catch (InputMismatchException e) { // 예외처리
                    System.out.println("정수를 입력해주세요.");
                    scanner.next(); // 버퍼에 남은 값 제거
                }
            }
        }
    }
}
