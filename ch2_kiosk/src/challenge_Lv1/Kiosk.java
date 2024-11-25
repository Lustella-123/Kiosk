package challenge_Lv1;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    private List<Menu> menus;
    private List<MenuItem> shoppingCart = new ArrayList<>();

    public Kiosk(List<Menu> menus) {
        this.menus = menus;
    }

    public void start() {
        // 스캐너 선언
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        // 전체 반복문 시작
        while (!exit) {
            // 메인메뉴 화면
            System.out.println("[ MAIN MENU ]");
            for (int i = 0; i < menus.size(); i++) {
                System.out.println((i + 1) + ". " + menus.get(i).getCategoryName());
            }
            System.out.println("0. 종료");
            if (!shoppingCart.isEmpty()){
                System.out.println();
                System.out.println("[ ORDER MENU ]");
                System.out.println("4. Orders");
                System.out.println("5. Cancel");
            }
            // 메인메뉴 화면 끝

            // 메인메뉴 선택
            while (true) {
                try {
                    int choice = scanner.nextInt();
                    boolean orderBreak = false;
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
                            System.out.println("선택한 메뉴: " + selectedItem.getName() + " | W " + selectedItem.getPrice() + " | " + selectedItem.getDescription());
                            // 장바구니 추가
                            System.out.println();
                            System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
                            System.out.println("1. 확인      2. 취소");
                            while (true) {
                                try {
                                    int cart = scanner.nextInt();
                                    if (cart == 1) {
                                        shoppingCart.add(selectedItem);
                                        System.out.println();
                                        System.out.println(selectedItem.getName() + "이 장바구니에 추가되었습니다.");
                                        break;
                                    } else {
                                        System.out.println("장바구니에 추가하지 않았습니다.");
                                        break;
                                    }
                                } catch (InputMismatchException e) {
                                    System.out.println("잘못된 입력입니다.");
                                }
                            }
                            break;
                        } else {
                            System.out.println("잘못된 입력입니다.");
                        }
                    // 쇼핑카트가 차있을 때 출력
                    } else if (!shoppingCart.isEmpty()) {
                        if (choice == 4) {
                            double totalPrice = 0;
                            System.out.println("아래와 같이 주문하시겠습니까?");
                            System.out.println();
                            System.out.println("[ Orders ]");
                            for (int i = 0; i < shoppingCart.size(); i++) {
                                System.out.println(shoppingCart.get(i).getName() + " | W " + shoppingCart.get(i).getPrice() + " | " + shoppingCart.get(i).getDescription());
                                totalPrice += shoppingCart.get(i).getPrice();
                            }
                            System.out.println();
                            System.out.println("[ Total ]");
                            System.out.println("W " + totalPrice);

                            // 최종 주문 기능
                            System.out.println("1. 주문      2. 메뉴판");
                            while (true) {
                                try {
                                    int order = scanner.nextInt();
                                    if (order == 1) {
                                        System.out.println();
                                        System.out.println("주문이 완료되었습니다. 금액은 W " + totalPrice + "입니다.");
                                        exit = true;
                                        orderBreak = true;
                                        break;
                                    } else if (order == 2) {
                                        System.out.println();
                                        orderBreak = true;
                                        break;
                                    } else {
                                        System.out.println("잘못된 입력입니다.");
                                    }
                                } catch (InputMismatchException e) {
                                    System.out.println("잘못된 입력입니다.");
                                }
                            }
                            if (orderBreak) {
                                break;
                            }
                        }
                    }else {
                        System.out.println("잘못된 입력입니다.");
                    }
                } catch (InputMismatchException e) { // 예외처리
                    System.out.println("정수를 입력해주세요.");
                    scanner.next(); // 버퍼에 남은 값 제거
                }
            }
            // 메인메뉴 선택 끝
        }
    }
}
