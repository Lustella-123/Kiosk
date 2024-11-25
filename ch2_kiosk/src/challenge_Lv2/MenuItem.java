package challenge_Lv2;

public class MenuItem<T, S> { // 제네릭으로 교체
    private final S name;
    private final T price;
    private final S description;

    public MenuItem(S name, T price, S description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    // Getter and Setter
    public S getName() {
        return name;
    }

    public T getPrice() {
        return price;
    }

    public S getDescription() {
        return description;
    }
}
