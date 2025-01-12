package lotto.service;

import lotto.domain.*;

public class WinningCalculator {

    public WinningResults calculateWinningResult(Lottos lottos, WinningLotto winningLotto) {
        WinningResults winningResults = new WinningResults();

        lottos.getLottos().forEach(lotto -> processLotto(winningResults, lotto, winningLotto));

        return winningResults;
    }

    private void processLotto(WinningResults winningResult, Lotto lotto, WinningLotto winningLotto) {
        int matchCount = countMatchingNumbers(lotto, winningLotto);
        boolean bonusMatched = isBonusNumberMatched(lotto, winningLotto);

        MatchResults matchResult = MatchResults.valueOf(matchCount, bonusMatched);
        if (matchResult != null) {
            winningResult.addMatch(matchResult);
        }
    }

    private int countMatchingNumbers(Lotto lotto, WinningLotto winningLotto) {
        return (int) lotto.getNumbers().stream()
                .filter(winningLotto::contains)
                .count();
    }

    private boolean isBonusNumberMatched(Lotto lotto, WinningLotto winningLotto) {
        return lotto.getNumbers().contains(winningLotto.getBonusNumber());
    }
}