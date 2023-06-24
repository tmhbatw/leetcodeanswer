package leetcode.leetcode28;

public class Leetcode2739 {

    public int distanceTraveled(int mainTank, int additionalTank) {
        return 10 * getRealTank(mainTank, additionalTank);
    }

    private int getRealTank(int mainTank, int addTank) {
        if (mainTank < 5 || addTank == 0) {
            return mainTank;
        }
        return mainTank + 1 + Math.min((mainTank - 5) / 4, addTank - 1);
    }

}
