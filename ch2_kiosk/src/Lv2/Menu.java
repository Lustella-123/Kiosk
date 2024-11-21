package Lv2;

import java.util.ArrayList;
import java.util.List;

public class Menu {

    // 버거 메뉴 생성
    private MenuItem ShackBurger = new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거");
    private MenuItem SmokeShack = new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");
    private MenuItem CheeseBurger = new MenuItem("CheeseBurger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
    private MenuItem Hamburger = new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거");

    public MenuItem getShackBurger() {
        return ShackBurger;
    }

    public MenuItem getSmokeShack() {
        return SmokeShack;
    }

    public MenuItem getCheeseBurger() {
        return CheeseBurger;
    }

    public MenuItem getHamburger() {
        return Hamburger;
    }

}
