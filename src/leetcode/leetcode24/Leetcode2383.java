package leetcode.leetcode24;

import java.util.Arrays;

public class Leetcode2383 {

    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int result =0 ;
        for (int j : experience) {
            if (initialExperience <= j) {
                result += j - initialExperience + 1;
                initialExperience = j + 1;
            }
            initialExperience+=j;
        }

        return result+Math.max(0, Arrays.stream(energy).sum()+1-initialEnergy);
    }
}
