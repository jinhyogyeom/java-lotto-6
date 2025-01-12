package lotto.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class WinningResults {

    private final Map<MatchResults, Integer> results = new HashMap<>();

    public WinningResults() {
        for (MatchResults matchResult : MatchResults.values()) {
            results.put(matchResult, 0);
        }
    }

    public void addMatch(MatchResults matchResult) {
        results.put(matchResult, results.get(matchResult) + 1);
    }

    public Map<MatchResults, Integer> getFilteredResults() {
        Map<MatchResults, Integer> filteredResults = new HashMap<>();
        for (Map.Entry<MatchResults, Integer> entry : results.entrySet()) {
            if (entry.getKey() != MatchResults.NONE) {
                filteredResults.put(entry.getKey(), entry.getValue());
            }
        }
        return Collections.unmodifiableMap(filteredResults);
    }

    public int calculateTotalPrize() {
        return results.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
    }
}