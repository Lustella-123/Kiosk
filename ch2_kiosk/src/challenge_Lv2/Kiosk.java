package challenge_Lv2;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Kiosk {
    private List<Menu> menus;
    private List<MenuItem<Double, String>> shoppingCart = new ArrayList<>();

    public Kiosk(List<Menu> menus) {
        this.menus = menus;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            displayMainMenu();
            try {
                int choice = scanner.nextInt();
                exit = handleMainMenuChoice(choice, scanner);
            } catch (InputMismatchException e) {
                System.out.println("정수를 입력해주세요.");
                scanner.next();
            }
        }
    }

    private void displayMainMenu() {
        System.out.println("[ MAIN MENU ]");
        for (int i = 0; i < menus.size(); i++) {
            System.out.println((i + 1) + ". " + menus.get(i).getCategoryName());
        }
        System.out.println("0. 종료");
        if (!shoppingCart.isEmpty()) {
            System.out.println("\n[ ORDER MENU ]");
            System.out.println("4. Orders");
            System.out.println("5. Cancel");
        }
    }

    private boolean handleMainMenuChoice(int choice, Scanner scanner) {
        if (choice == 0) {
            System.out.println("프로그램을 종료합니다.");
            return true;
        } else if (choice > 0 && choice <= menus.size()) {
            handleSubMenuChoice(choice - 1, scanner);
        } else if (!shoppingCart.isEmpty()) {
            handleOrderMenuChoice(choice, scanner);
        } else {
            System.out.println("잘못된 입력입니다.");
        }
        return false;
    }

    private void handleSubMenuChoice(int menuIndex, Scanner scanner) {
        menus.get(menuIndex).displayMenu();
        try {
            int subChoice = scanner.nextInt();
            if (subChoice == 0) {
                System.out.println("뒤로가기");
            } else if (subChoice > 0 && subChoice <= menus.get(menuIndex).getMenuItems().size()) {
                MenuItem<Double, String> selectedItem = menus.get(menuIndex).getMenuItems().get(subChoice - 1);
                handleMenuItemSelection(selectedItem, scanner);
            } else {
                System.out.println("잘못된 입력입니다.");
            }
        } catch (InputMismatchException e) {
            System.out.println("정수를 입력해주세요.");
            scanner.next();
        }
    }

    private void handleMenuItemSelection(MenuItem<Double, String> selectedItem, Scanner scanner) {
        System.out.println("선택한 메뉴: " + selectedItem.getName() + " | W " + selectedItem.getPrice() + " | " + selectedItem.getDescription());
        System.out.println("\n위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인      2. 취소");

        try {
            int cartChoice = scanner.nextInt();
            if (cartChoice == 1) {
                shoppingCart.add(selectedItem);
                System.out.println("\n" + selectedItem.getName() + "이 장바구니에 추가되었습니다.");
            } else {
                System.out.println("장바구니에 추가하지 않았습니다.");
            }
        } catch (InputMismatchException e) {
            System.out.println("잘못된 입력입니다.");
            scanner.next();
        }
    }

    private void handleOrderMenuChoice(int choice, Scanner scanner) {
        if (choice == 4) {
            processOrder(scanner);
        } else if (choice == 5) {
            System.out.println("프로그램을 종료합니다.");
            System.exit(0);
        } else {
            System.out.println("잘못된 입력입니다.");
        }
    }

    private void processOrder(Scanner scanner) {
        double totalPrice = displayShoppingCart();
        System.out.println("\n1. 주문      2. 제거      3. 메뉴판");
        try {
            int orderChoice = scanner.nextInt();
            switch (orderChoice) {
                case 1 -> completeOrder(totalPrice, scanner);
                case 2 -> removeItemFromCart(scanner);
                case 3 -> System.out.println("메뉴판으로 돌아갑니다.");
                default -> System.out.println("잘못된 입력입니다.");
            }
        } catch (InputMismatchException e) {
            System.out.println("정수를 입력해주세요.");
            scanner.next();
        }
    }

    private double displayShoppingCart() {
        double totalPrice = 0;
        System.out.println("아래와 같이 주문하시겠습니까?\n");
        System.out.println("[ Orders ]");
        for (int i = 0; i < shoppingCart.size(); i++) {
            MenuItem<Double, String> item = shoppingCart.get(i);
            System.out.println((i + 1) + ". " + item.getName() + " | W " + item.getPrice() + " | " + item.getDescription());
            totalPrice += item.getPrice();
        }
        System.out.println("\n[ Total ]");
        System.out.println("W " + totalPrice);
        return totalPrice;
    }

    private void completeOrder(double totalPrice, Scanner scanner) {
        System.out.println("\n할인 정보를 입력해주세요.");
        System.out.println("1. 국가유공자 : 10%\n2. 군인      : 5%\n3. 학생      : 3%\n4. 일반      : 0%");

        try {
            int discountChoice = scanner.nextInt();
            totalPrice = applyDiscount(totalPrice, discountChoice);
            System.out.println("\n주문이 완료되었습니다. 금액은 W " + totalPrice + "입니다.");
            System.exit(0);
        } catch (InputMismatchException e) {
            System.out.println("정수를 입력해주세요.");
            scanner.next();
        }
    }

    private double applyDiscount(double totalPrice, int discountChoice) {
        return switch (discountChoice) {
            case 1 -> Discount.PATRIOT.discount(totalPrice);
            case 2 -> Discount.SOLDIER.discount(totalPrice);
            case 3 -> Discount.STUDENT.discount(totalPrice);
            case 4 -> totalPrice;
            default -> {
                System.out.println("잘못된 입력입니다.");
                yield totalPrice;
            }
        };
    }

    private void removeItemFromCart(Scanner scanner) {
        System.out.println("장바구니에서 제거할 항목 번호를 입력해주세요.");
        try {
            int itemToRemove = scanner.nextInt();
            if (itemToRemove > 0 && itemToRemove <= shoppingCart.size()) {
                shoppingCart = IntStream.range(0, shoppingCart.size())
                        .filter(i -> i != (itemToRemove - 1))
                        .mapToObj(shoppingCart::get)
                        .collect(Collectors.toCollection(ArrayList::new));
                System.out.println("선택 항목이 장바구니에서 제거되었습니다.");
            } else {
                System.out.println("잘못된 번호입니다.");
            }
        } catch (InputMismatchException e) {
            System.out.println("정수를 입력해주세요.");
            scanner.next();
        }
    }
}
