package lotto.controller;

import lotto.domain.*;
import lotto.service.LottoGenerator;
import lotto.util.RateCalculator;
import lotto.service.WinningCalculator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private Quantity quantity;
    private Lottos lottos;
    private WinningLotto winningLotto;
    private WinningResults winningResults;
    private final WinningCalculator winningCalculator;
    private final LottoGenerator lottoGenerator;
    private final RateCalculator rateCalculator;

    public LottoController() {
        winningCalculator = new WinningCalculator();
        lottoGenerator = new LottoGenerator();
        rateCalculator = new RateCalculator();
    }

    public void run() {
        purchaseLotto();
        setWinningNumber();
        getWinningStatics();
    }

    public void purchaseLotto() {
        getQuantity();
        generateLottos();
    }

    public void setWinningNumber() {
        getWinningNumber();
        getBonusNumber();
    }

    public void getWinningStatics() {
        printResults();
        printRate();
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

    private void printResults() {
        winningResults = winningCalculator.calculateWinningResult(lottos, winningLotto);
        OutputView.printWinningResults(winningResults.getResults());
    }

    private void printRate() {
        int totalPrize = winningResults.calculateTotal();
        double rate = rateCalculator.calculateRate(quantity.getTotalPrice(), totalPrize);
        OutputView.printRates(rate);
    }
}
