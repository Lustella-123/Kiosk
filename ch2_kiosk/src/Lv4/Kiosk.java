package Lv4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kiosk {

    private Menu menu = new Menu();
    private List<MenuItem> cart = new ArrayList<>();

    public void startKiosk() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) { // 키오스크 전체 루프
            menu.showMenu(); // 메인 메뉴 출력

            int selectMenu;

            // 첫 번째 루프: 메인 메뉴 선택
            while (true) {
                try {
                    System.out.print("메뉴를 선택하세요: ");
                    selectMenu = scanner.nextInt();

                    // 종료 옵션 처리
                    if (selectMenu == 0) {
                        System.out.println("프로그램을 종료합니다.");
                        exit = true;
                        break;
                    } else if (selectMenu > 0 && selectMenu <= 4) {
                        break;
                    } else {
                        System.out.println("잘못된 선택지입니다. 다시 입력해주세요.");
                    }
                } catch (Exception e) {
                    System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
                    scanner.nextLine(); // 입력 버퍼 초기화
                }
            }

            if (exit) break;

            // 장바구니 관리 메뉴로 이동
            if (selectMenu == 4) {
                manageCart(scanner);
                continue;
            }

            // 선택된 메뉴에 따라 세부 메뉴 출력
            menu.showMenuItem(selectMenu);

            int selectMenuItem;
            MenuItem selectedItem;

            // 두 번째 루프: 세부 메뉴 선택
            while (true) {
                try {
                    System.out.print("세부 메뉴를 선택하세요: ");
                    selectMenuItem = scanner.nextInt();

                    // 뒤로가기 옵션 처리
                    if (selectMenuItem == 0) {
                        System.out.println("메인 메뉴로 돌아갑니다.");
                        break;
                    } else if (selectMenuItem > 0 && selectMenuItem <= 4) {
                        // 선택한 메뉴 항목 가져오기
                        if (selectMenu == 1) {
                            selectedItem = menu.getBurgers().get(selectMenuItem - 1);
                        } else if (selectMenu == 2) {
                            selectedItem = menu.getDrinks().get(selectMenuItem - 1);
                        } else {
                            selectedItem = menu.getDesserts().get(selectMenuItem - 1);
                        }

                        // 장바구니에 추가
                        if (selectedItem != null) {
                            cart.add(selectedItem);
                            System.out.println("선택한 메뉴: " + selectedItem.getName() + " / " + selectedItem.getPrice() + " / " + selectedItem.getDescription());
                            showCart();
                            break;
                        }
                    } else {
                        System.out.println("잘못된 선택지입니다. 다시 입력해주세요.");
                    }
                } catch (Exception e) {
                    System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
                    scanner.nextLine(); // 입력 버퍼 초기화
                }
            }
        }
    }

    // 장바구니 표시
    private void showCart() {
        System.out.println();
        System.out.println("=== 장바구니 ===");
        int i = 1;
        for (MenuItem item : cart) {
            System.out.println(i + ". " + item.getName() + " / " + item.getPrice());
            i++;
        }
        if (cart.isEmpty()) {
            System.out.println("장바구니가 비어 있습니다.");
        }
    }

    // 장바구니 관리
    private void manageCart(Scanner scanner) {
        while (true) {
            showCart();
            System.out.println();
            System.out.println("1. 구매하기");
            System.out.println("2. 제거하기");
            System.out.println("3. 뒤로가기");
            System.out.print("선택하세요: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    // 구매 완료 처리
                    System.out.println("구매가 완료되었습니다. 프로그램을 종료합니다.");
                    System.exit(0);
                    break;
                case 2:
                    // 장바구니에서 항목 제거
                    if (cart.isEmpty()) {
                        System.out.println("장바구니가 비어 있습니다. 제거할 항목이 없습니다.");
                    } else {
                        System.out.print("제거할 항목 번호를 입력하세요: ");
                        int removeIndex = scanner.nextInt() - 1;
                        if (removeIndex >= 0 && removeIndex < cart.size()) {
                            MenuItem removedItem = cart.remove(removeIndex);
                            System.out.println(removedItem.getName() + "이(가) 장바구니에서 제거되었습니다.");
                        } else {
                            System.out.println("잘못된 번호입니다. 다시 시도해주세요.");
                        }
                    }
                    break;
                case 3:
                    // 뒤로가기
                    return;
                default:
                    System.out.println("잘못된 선택입니다. 다시 입력해주세요.");
            }
        }
    }
}