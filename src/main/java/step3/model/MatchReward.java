package step3.model;

public enum MatchReward {
    THREE_MATCH(3, 5_000L),
    FOUR_MATCH(4, 50_000L),
    FIVE_MATCH(5, 1_500_000L),
    SIX_MATCH(6, 2_000_000_000L);

    final private long reward;
    final private int matchCount;

    public long getReward() {
        return reward;
    }
    public int getMatchCount() {
        return matchCount;
    }

    MatchReward(int matchCount, long reward) {
        this.matchCount = matchCount;
        this.reward = reward;
    }
}
