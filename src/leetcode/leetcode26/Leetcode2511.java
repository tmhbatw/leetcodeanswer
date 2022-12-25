package leetcode.leetcode26;

public class Leetcode2511 {

    public int captureForts(int[] forts) {
        int result = 0;
        for (int i = 0; i < forts.length; i++) {
            if (forts[i] != 1)
                continue;
            int ii = i;
            while (ii >= 1 && forts[ii - 1] == 0)
                ii--;
            if (ii >= 1 && forts[ii - 1] == -1)
                result = Math.max(result, i - ii);

            ii = i;
            while (ii < forts.length - 1 && forts[ii + 1] == 0)
                ii++;
            if (ii < forts.length - 1 && forts[ii + 1] == -1)
                result = Math.max(result, ii - i);
        }
        return result;
    }

}
