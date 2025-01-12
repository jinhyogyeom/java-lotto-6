package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    private final List<Integer> numbers;
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 45;
    private static final int LOTTO_SIZE = 6;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
        validate(numbers);
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateNumbers(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("[ERROR] 여섯 개의 숫자를 입력해주세요");
        }
    }

    private void validateNumbers(List<Integer> numbers) {
        Set<Integer> numset = new HashSet<>();
        for(Integer number : numbers) {
            validateRange(number);
            numset.add(number);
        }
        validateDuplicate(numset);
    }

    private void validateDuplicate(Set<Integer> numset) {
        if(numset.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자가 존재합니다");
        }
    }

    private void validateRange(Integer number){
        if(number > MAX_RANGE || number < MIN_RANGE) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
