package challenge_Lv2;

public enum Discount {
    PATRIOT(10), SOLDIER(5), STUDENT(3), NORMAL(0);

    private final int discountPercent;

    Discount(int discountPercent) {
        this.discountPercent = discountPercent;
    }

    public double discount (double price) {
        return price * (100 - discountPercent) / 100;
    }
}
