package lotto.domain;

public class Quantity {
    private final int quantity;

    private Quantity(int quantity) {
        this.quantity = quantity;
    }

    public static Quantity of(int price) {
        if (price % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위만 입력 가능합니다.");
        }
        return new Quantity(price / 1000);
    }

    public int getQuantity() {
        return quantity;
    }
}
