package basic_Lv4;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Menu 객체 생성하면서 카테고리 이름 설정
        List<Menu> menus = new ArrayList<>();
        menus.add(new Menu("Burgers"));
        menus.add(new Menu("Drinks"));
        menus.add(new Menu("Desserts"));
        // Menu 클래스 내 있는 List<MenuItem> 에 MenuItem 객체 생성하면서 삽입
        // 버거
        menus.get(0).addMenuItem(new MenuItem("ShackBurger  ", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menus.get(0).addMenuItem(new MenuItem("SmokeShack   ", 8.9, "베이컨, 체리 페퍼이 쉑소스가 토핑된 치즈버거"));
        menus.get(0).addMenuItem(new MenuItem("cheeseburger ", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        menus.get(0).addMenuItem(new MenuItem("Hamburger    ", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));
        // 음료
        menus.get(1).addMenuItem(new MenuItem("Cola         ", 2.5, "햄버거와 가장 잘 어울리는 기본 탄산음료"));
        menus.get(1).addMenuItem(new MenuItem("ZeroCola     ", 3.0, "다이어터들을 위한 시원한 콜라!"));
        menus.get(1).addMenuItem(new MenuItem("Cider        ", 2.5, "콜라에 질린 여러분을 위한 시원한 사이다~"));
        menus.get(1).addMenuItem(new MenuItem("OrangeJuice  ", 3.5, "사장이 직접 키우고 짜낸 오렌지주스"));
        // 디저트
        menus.get(2).addMenuItem(new MenuItem("FrenchFries  ", 3.0, "햄버거를 먹을 때 빼놓을 수 없는 사이드메뉴"));
        menus.get(2).addMenuItem(new MenuItem("OnionRing    ", 3.5, "사장이 20년간 연구해 만들어낸 궁극의 양파링"));
        menus.get(2).addMenuItem(new MenuItem("ChickenTender", 5.0, "햄버거로 양의 부족한 건장한 분들을 위한 사이드"));
        menus.get(2).addMenuItem(new MenuItem("CheeseStick  ", 2.5, "기이이이일게 늘어나는 치즈를 품은 스틱"));

        // Kiosk 객체 생성
        Kiosk kiosk = new Kiosk(menus);
        // Kiosk 내 시작하는 함수 호출
        kiosk.start();
    }
}
