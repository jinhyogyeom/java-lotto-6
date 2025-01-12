package lotto.controller;

import lotto.domain.WinningResults;
import lotto.service.LottoService;
import lotto.service.WinningService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final LottoService lottoService;
    private final WinningService winningService;

    public LottoController() {
        lottoService = new LottoService();
        winningService = new WinningService();
    }

    public void run() {
        purchaseLotto();
        setWinningNumbers();
        calculateWinningStatistics();
    }

    private void purchaseLotto() {
        int price = Integer.parseInt(InputView.getPrice());
        lottoService.purchaseLotto(price);
        OutputView.showPurchaseList(lottoService.getLottos());
    }

    private void setWinningNumbers() {
        String winningNumbers = InputView.getWinningNumber();
        int bonusNumber = Integer.parseInt(InputView.getBonusNumber());
        winningService.setWinningNumbers(winningNumbers, bonusNumber);
    }

    private void calculateWinningStatistics() {
        WinningResults winningResults = winningService.calculateWinningResults(lottoService.getLottos());
        OutputView.printWinningResults(winningResults.getFilteredResults());
        OutputView.printRates(winningService.calculateRate(lottoService.getTotalPrice(), winningResults));
    }
}