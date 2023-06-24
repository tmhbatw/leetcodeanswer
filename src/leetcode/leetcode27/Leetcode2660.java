package leetcode.leetcode27;

public class Leetcode2660 {

    public int isWinner(int[] player1, int[] player2) {
        int score1 = getScore(player1);
        int score2 = getScore(player2);
        return score1 > score2 ? 1 : score1 == score2 ? 0 : 2;
    }

    private int getScore(int[] scores) {
        int sum = 0;
        for (int i = 0; i < scores.length; i++) {
            if (i >= 1 && scores[i - 1] == 10 || i >= 2 && scores[i - 2] == 10) {
                sum += scores[i] * 2;
            } else {
                sum += scores[i];
            }
        }
        return sum;
    }
}
