package Lv2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // 리스트에 메뉴 추가
        List<MenuItem> burger = new ArrayList<>();
        Menu menu = new Menu();
        burger.add(menu.getShackBurger());
        burger.add(menu.getSmokeShack());
        burger.add(menu.getCheeseBurger());
        burger.add(menu.getHamburger());

        Scanner scanner = new Scanner(System.in);
        Kiosk kiosk = new Kiosk();
        int i = 1; // 메뉴 앞 숫자

        // 메뉴 출력
        System.out.println("[ SHAKESHACK MENU ]");
        for (MenuItem b : burger) { // burger List를 하나씩 꺼냄
            System.out.println(i + ". " + b.name + " / W " + b.price + " / " + b.description);
            i++; // 메뉴 앞 숫자 1씩 증가
        }
        System.out.println("0. 종료");

        boolean isValid = false;
        while (!isValid) { // 유효한 숫자 입력할 때까지 반복
            try {
                int selectBurger = scanner.nextInt();
                switch (selectBurger) {
                    case 0: // 0 입력시 종료
                        System.out.println("프로그램을 종료합니다.");
                        isValid = true;
                        break;
                    default: // burger 길이에 따른 유동적인 조건문
                        if (selectBurger > 0 && selectBurger <= burger.size()) {
                            MenuItem selectedBurger = burger.get(selectBurger - 1);
                            System.out.println("선택한 메뉴 : " + selectedBurger.name + ", " + selectedBurger.price + ", " + selectedBurger.description);
                            isValid = true;
                        } else {
                            System.out.println("잘못된 선택지입니다. 다시 입력해주세요.");
                        }
                        break;
                }
            } catch (Exception e) { // 숫자가 아닌 경우 경고
                System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
                scanner.nextLine();
            }
        }

        kiosk.startKiosk();

    }
}
