package lotto.util;

public class RateCalculator {

    public double calculateRate(int totalPrice, int totalPrize) {
        double rate = (double) totalPrize / totalPrice * 100;
        return Math.round(rate * 100) / 100.0;
    }
}
