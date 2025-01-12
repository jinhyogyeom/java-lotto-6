package lotto.domain;
import java.util.List;

public class WinningLotto {

    private final Lotto lotto;
    private int bonusNumber;

    public WinningLotto(Lotto lotto) {
        this.lotto = lotto;
        validateWinningNumbers(lotto);
    }

    private void validateWinningNumbers(Lotto lotto) {
        if (contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    public MatchResults calculateMatch(Lotto userLotto) {
        int matchCount = (int) userLotto.getNumbers().stream()
                .filter(lotto.getNumbers()::contains)
                .count();
        boolean bonusMatched = userLotto.getNumbers().contains(bonusNumber);
        return MatchResults.valueOf(matchCount, bonusMatched);
    }


    public boolean contains(int number) {
        List<Integer> numbers = lotto.getNumbers();
        return numbers.contains(number);
    }

    public void appendBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
