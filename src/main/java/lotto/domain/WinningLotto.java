package lotto.domain;


import java.util.List;

public class WinningLotto {
    private final Lotto lotto;
    private int bonusNumber;

    public WinningLotto(Lotto lotto) {
        validateWinningNumbers(lotto);
        this.lotto = lotto;
    }

    private void validateWinningNumbers(Lotto lotto) {
        if (contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    public boolean contains(int number) {
        List<Integer> numbers = lotto.getNumbers();
        return numbers.contains(number);
    }

    public void appendBonusNumber(String bonusNumber) {
        this.bonusNumber = Integer.parseInt(bonusNumber);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
