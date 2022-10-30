package step3.model;

public class CountBoard {

    private int[] countBoard = new int[7];

    public void plusCount(int rank) {
        countBoard[rank]++;
    }

    public int oneRankResult(int rank) {
        return countBoard[rank];
    }

    public long calculateTotalRankReward() {
        long totalReward = 0;
        for (MatchReward reward : MatchReward.values()) {
            totalReward += countBoard[reward.getMatchCount()] * reward.getReward();
        }
        return totalReward;
    }

    public String showRankResult() {
        StringBuffer sb = new StringBuffer();
        for (MatchReward reward : MatchReward.values()) {
            sb.append(reward.getMatchCount() + "개 일치 (" + reward.getReward() + ")- "+ countBoard[reward.getMatchCount()] +"개\n");
        }
        return sb.toString();
    }
}
