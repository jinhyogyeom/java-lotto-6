package lotto.domain;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class WinningResults {

    private final Map<MatchResults, Integer> results = new HashMap<>();

    public WinningResults() {
        for (MatchResults matchResults : MatchResults.values()) {
            results.put(matchResults, 0);
        }
    }

    public void addMatch(MatchResults matchResults) {
        results.put(matchResults, results.get(matchResults) + 1);
    }

    public Map<MatchResults, Integer> getResults() {
        return results.entrySet().stream()
                .filter(entry -> entry.getKey() != MatchResults.NONE) // NONE 제외
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}