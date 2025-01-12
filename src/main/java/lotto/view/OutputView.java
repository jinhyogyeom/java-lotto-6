package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.MatchResult;
import lotto.domain.WinningResult;

import java.util.Map;

public class OutputView {

    public static void showPurchaseList(Lottos lottos) {
        for(Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void showWinningResults(Map<MatchResult, Integer> results) {
        System.out.println("당첨 통계");
        System.out.println("---");

        for (Map.Entry<MatchResult, Integer> entry : results.entrySet()) {
            System.out.printf("%s - %d개%n", entry.getKey().getDescription(), entry.getValue());
        }
    }

}
