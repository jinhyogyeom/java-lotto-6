package lotto.domain;
import java.util.HashMap;
import java.util.Map;

public class WinningResult {
    private final Map<MatchResult, Integer> results = new HashMap<>();

    public WinningResult() {
        for (MatchResult matchResult : MatchResult.values()) {
            results.put(matchResult, 0);
        }
    }

    public void addMatch(MatchResult matchResult) {
        results.put(matchResult, results.get(matchResult) + 1);
    }

    public int getCount(MatchResult matchResult) {
        return results.get(matchResult);
    }

    public void printResults() {
        for (MatchResult matchResult : MatchResult.values()) {
            System.out.printf("%s - %d개%n", matchResult.getDescription(), getCount(matchResult));
        }
    }

    public int calculateTotalPrize() {
        return results.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
    }
}