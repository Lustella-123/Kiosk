package Lv1;

import java.util.Scanner;

public class Kiosk {
    Scanner scanner = new Scanner(System.in);
    Menu menu = new Menu();
    boolean isvalid = false; // 유효 숫자 판별

    public Kiosk() {
        System.out.println("[ SHAKESHACK MENU }");
        menu.getBurger(); // 버거 메뉴 가져오기
        while (!isvalid) { // 유효한 숫자 입력할 때까지 반복
            try {
                int selectBurger = scanner.nextInt();
                switch (selectBurger) {
                    case 0:
                        System.out.println("프로그램을 종료합니다.");
                        isvalid = true;
                        break;
                    case 1:
                        System.out.println("1번 선택");
                        isvalid = true;
                        break;
                    case 2:
                        System.out.println("2번 선택");
                        isvalid = true;
                        break;
                    case 3:
                        System.out.println("3번 선택");
                        isvalid = true;
                        break;
                    case 4:
                        System.out.println("4번 선택");
                        isvalid = true;
                        break;
                    default: // 잘못된 숫자인 경우 경고
                        System.out.println("잘못된 숫자입니다. 다시 입력해주세요.");
                }
            } catch (Exception e) { // 숫자가 아닌 경우 경고
                System.out.println("숫자 형식이 아닙니다. 다시 입력해주세요.");
                scanner.nextLine();
            }
        }
    }
}
