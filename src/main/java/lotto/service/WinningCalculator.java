package lotto.service;

import lotto.domain.*;

public class WinningCalculator {

    public WinningResult calculateWinningResult(Lottos lottos, WinningLotto winningLotto) {
        WinningResult winningResult = new WinningResult();

        lottos.getLottos().forEach(lotto -> processLotto(winningResult, lotto, winningLotto));

        return winningResult;
    }

    private void processLotto(WinningResult winningResult, Lotto lotto, WinningLotto winningLotto) {
        int matchCount = countMatchingNumbers(lotto, winningLotto);
        boolean bonusMatched = isBonusNumberMatched(lotto, winningLotto);

        MatchResult matchResult = MatchResult.valueOf(matchCount, bonusMatched);
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