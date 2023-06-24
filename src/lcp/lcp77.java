package lcp;

import java.util.Arrays;

public class lcp77 {

    public int runeReserve(int[] runes) {
        Arrays.sort(runes);
        int result = 1;
        int pre = 1;

        for (int i = 1; i < runes.length; i++) {
            if (runes[i] - runes[i - 1] <= 1) {
                pre++;
                result = Math.max(pre, result);
            } else {
                pre = 1;
            }
        }
        return result;
    }

}
