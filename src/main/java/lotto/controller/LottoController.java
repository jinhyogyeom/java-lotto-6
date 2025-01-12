package lotto.controller;

import lotto.domain.*;
import lotto.service.LottoGenerator;
import lotto.service.WinningCalculator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private Quantity quantity;
    private Lottos lottos;
    private WinningLotto winningLotto;
    private final WinningCalculator winningCalculator;
    private final LottoGenerator lottoGenerator;

    public LottoController () {
        winningCalculator = new WinningCalculator();
        lottoGenerator = new LottoGenerator();
    }

    public void startDraw() {
        getQuantity();
        generateLottos();
        getWinningNumber();
        getBonusNumber();
        calculateResults();
    }

    private void getQuantity() {
        int price = Integer.parseInt(InputView.getPrice());
        this.quantity = Quantity.of(price);
    }

    private void generateLottos() {
        this.lottos = lottoGenerator.generate(quantity.getQuantity());
        OutputView.showPurchaseList(lottos);
    }

    private void getWinningNumber() {
        String winningNumber = InputView.getWinningNumber();
        Lotto lotto = lottoGenerator.createWinningLotto(winningNumber);
        winningLotto = new WinningLotto(lotto);
    }

    private void getBonusNumber() {
        winningLotto.appendBonusNumber(InputView.getBonusNumber());
    }

    private void calculateResults() {
        WinningResult winningResult = winningCalculator.calculateWinningResult(lottos, winningLotto);
        OutputView.showWinningResults(winningResult.getResults());
    }

}
