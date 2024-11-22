package Lv4;

import java.util.ArrayList;
import java.util.List;

public class Menu {

    // 메뉴아이템 생성
    public Menu() {
        // 버거 메뉴
        Burgers.add(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        Burgers.add(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        Burgers.add(new MenuItem("CheeseBurger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        Burgers.add(new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));
        // 음료 메뉴
        Drinks.add(new MenuItem("Cola", 2.0, "버거와 가장 잘 어울리는 기본 음료"));
        Drinks.add(new MenuItem("Cider", 2.0, "콜라가 아닌 탄산을 원할 때 먹기 좋은 음료"));
        Drinks.add(new MenuItem("Juice", 2.5, "직접 짜낸 과즙으로 만드는 진짜 과일 주스"));
        Drinks.add(new MenuItem("Water", 1.0, "미네랄이 풍부한 물"));
        // 디저트 메뉴
        Desserts.add(new MenuItem("Pie", 3.5, "아침에 갓 구운 100년 전통의 사과파이"));
        Desserts.add(new MenuItem("EggTart", 3.0, "한입 먹는 순간 입안에 고소함과 달콤함이 입안에 퍼지는 타르트"));
        Desserts.add(new MenuItem("Croissant", 2.5, "주인장이 10년동안 팔아오며 진화시킨 클래식 빵"));
        Desserts.add(new MenuItem("FrenchFry", 2.0, "햄버거와 먹을 때 빼놓을 수 없는 감자튀김"));
    }

    // 버거 리스트
    private List<MenuItem> Burgers = new ArrayList<>();
    // 음료 리스트
    private List<MenuItem> Drinks = new ArrayList<>();
    // 디저트 리스트
    private List<MenuItem> Desserts = new ArrayList<>();

    // 메인 메뉴 출력
    public void showMenu() {
        System.out.println();
        System.out.println("[ MAIN MENU ]");
        System.out.println("1. Burgers");
        System.out.println("2. Drinks");
        System.out.println("3. Desserts");
        System.out.println("4. List and Buy");
        System.out.println("0. 종료");
    }

    // 메뉴 출력
    public void showMenuItem(int menu) {
        int i = 1;
        if (menu == 1) {
            System.out.println();
            System.out.println("[ BURGERS MENU ]");
            for (MenuItem item : Burgers) {
                System.out.println(i + ". " + item.getName() + "/ " + item.getPrice() + "/ " + item.getDescription());
                i++;
            }
            System.out.println("0. 뒤로가기");
        } else if (menu == 2) {
            System.out.println();
            System.out.println("[ DRINKS MENU ]");
            for (MenuItem item : Drinks) {
                System.out.println(i + ". " + item.getName() + "/ " + item.getPrice() + "/ " + item.getDescription());
                i++;
            }
            System.out.println("0. 뒤로가기");
        } else if (menu == 3) {
            System.out.println();
            System.out.println("[ DESSERTS MENU ]");
            for (MenuItem item : Desserts) {
                System.out.println(i + ". " + item.getName() + "/ " + item.getPrice() + "/ " + item.getDescription());
                i++;
            }
            System.out.println("0. 뒤로가기");
        }
    }

    public List<MenuItem> getBurgers() {
        return Burgers;
    }

    public List<MenuItem> getDrinks() {
        return Drinks;
    }

    public List<MenuItem> getDesserts() {
        return Desserts;
    }


}
