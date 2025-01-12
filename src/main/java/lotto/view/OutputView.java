package lotto.view;

import lotto.domain.*;
import lotto.util.RateCalculator;

import java.util.Map;

public class OutputView {

    public static void showPurchaseList(Lottos lottos) {
        for(Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printWinningResults(Map<MatchResults, Integer> results) {
        System.out.println("당첨 통계");
        System.out.println("---");

        for (Map.Entry<MatchResults, Integer> entry : results.entrySet()) {
            System.out.printf("%s - %d개%n", entry.getKey().getDescription(), entry.getValue());
        }
    }

    public static void printRates(double rate) {
        System.out.println("총 수익률은 " + rate + "입니다.");
    }
}
