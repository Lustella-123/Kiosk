package Lv1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("[ SHAKESHACK MENU ]");
        System.out.println("1. ShackBurger  | W 6.9 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거");
        System.out.println("2. SmokeShack   | W 8.9 | 베이컨, 체리 페퍼이 쉑소스가 토핑된 치즈버거");
        System.out.println("3. cheeseburger | W 6.9 | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
        System.out.println("4. Hamburger    | W 5.4 | 비프패티를 기반으로 야채가 들어간 기본버거");
        System.out.println("0. 종료");

        while (true) {
            try {
                int burgerMenu = scanner.nextInt();
                if (burgerMenu == 0) {
                    System.out.println("프로그램을 종료합니다.");
                    break; // 제대로된 선택지
                } else if (burgerMenu >= 1 && burgerMenu <= 4) {
                    System.out.println(burgerMenu + "번 선택");
                    break; // 제대로된 선택지
                } else {
                    System.out.println("잘못된 선택지입니다.");
                }
            } catch (InputMismatchException e) {
                System.out.println("정수를 입력해주세요.");
                scanner.next(); // 버퍼에 남은 값 제거
            }
        }
    }
}
