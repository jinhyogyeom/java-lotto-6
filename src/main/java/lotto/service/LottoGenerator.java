package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.util.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {

    private final RandomNumberGenerator randomNumberGenerator;

    public LottoGenerator() {
        randomNumberGenerator = new RandomNumberGenerator();
    }

    public Lottos generate(int quantity) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            lottoList.add(new Lotto(randomNumberGenerator.getRandomNumbers()));
        }
        return new Lottos(lottoList);
    }

    public Lotto createWinningLotto(String winningNumber) {
        List<Integer> winningNumbers = parseNumbers(winningNumber);
        return new Lotto(winningNumbers);
    }

    private List<Integer> parseNumbers(String input) {
        String[] tokens = input.split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String token : tokens) {
            numbers.add(Integer.parseInt(token.trim()));
        }
        return numbers;
    }
}