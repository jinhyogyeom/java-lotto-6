package lotto.service;

import lotto.domain.Lottos;
import lotto.domain.WinningLotto;
import lotto.domain.WinningResults;
import lotto.util.LottoGenerator;
import lotto.util.RateCalculator;

public class WinningService {

    private WinningLotto winningLotto;
    private final RateCalculator rateCalculator;
    private final LottoGenerator lottoGenerator;

    public WinningService() {
        rateCalculator = new RateCalculator();
        lottoGenerator = new LottoGenerator();
    }

    public void setWinningNumbers(String winningNumbers, int bonusNumber) {
        winningLotto = new WinningLotto(lottoGenerator.createWinningLotto(winningNumbers));
        winningLotto.appendBonusNumber(bonusNumber);
    }

    public WinningResults calculateWinningResults(Lottos lottos) {
        WinningResults winningResults = new WinningResults();
        lottos.getLottos().forEach(lotto ->
                winningResults.addMatch(winningLotto.calculateMatch(lotto))
        );
        return winningResults;
    }

    public double calculateRate(int totalPrice, WinningResults winningResults) {
        int totalPrize = winningResults.calculateTotalPrize();
        return rateCalculator.calculateRate(totalPrice, totalPrize);
    }
}