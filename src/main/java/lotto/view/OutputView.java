package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;

public class OutputView {

    public static void showPurchaseList(Lottos lottos) {
        for(Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void showWinningList() {
        System.out.println();
    }

}
