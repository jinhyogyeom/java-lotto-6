package lotto.domain;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

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

    public Map<MatchResult, Integer> getResults() {
        return results.entrySet().stream()
                .filter(entry -> entry.getKey() != MatchResult.NONE) // NONE 제외
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}