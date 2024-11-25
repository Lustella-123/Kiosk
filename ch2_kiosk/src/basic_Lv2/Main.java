package basic_Lv2;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // List 선언 및 초기화
        List<MenuItem> menuList = new ArrayList<>();
        // add 함수를 통해 new MenuItem(이름, 가격, 설명) List에 삽입
        menuList.add(new MenuItem("ShackBurger  ", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menuList.add(new MenuItem("SmokeShack   ", 8.9, "베이컨, 체리 페퍼이 쉑소스가 토핑된 치즈버거"));
        menuList.add(new MenuItem("cheeseburger ", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        menuList.add(new MenuItem("Hamburger    ", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));

        // Scanner 선언
        Scanner scanner = new Scanner(System.in);

        // 반복문을 활용해 List 안에 있는 MenuItem을 하나씩 출력
        System.out.println("[ SHAKESHACK MENU ]");
        int i = 1;
        for (MenuItem m : menuList) {
            System.out.println(i + ". " + m.name + "| W " + m.price + " | " + m.description);
            i++;
        }
        System.out.println("0. 종료");

        // 입력
        while (true) {
            try {
                int burgerMenu = scanner.nextInt(); // 숫자를 입력 받기
                if (burgerMenu == 0) { // 프로그램을 종료
                    System.out.println("프로그램을 종료합니다.");
                    break;
                } else if (burgerMenu >= 1 && burgerMenu <= 4) { // 입력된 숫자에 따른 처리, // 선택한 메뉴 : 이름, 가격, 설명
                    System.out.println("선택한 메뉴 : " + menuList.get(burgerMenu-1).name + "| W " + menuList.get(burgerMenu-1).price + " | " + menuList.get(burgerMenu-1).description);
                    break;
                } else { // 예외처리
                    System.out.println("잘못된 선택지입니다.");
                }
            } catch (InputMismatchException e) { // 예외처리
                System.out.println("정수를 입력해주세요.");
                scanner.next(); // 버퍼에 남은 값 제거
            }
        }
    }
}
