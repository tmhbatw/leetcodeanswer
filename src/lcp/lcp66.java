package lcp;

import java.util.Arrays;

public class lcp66 {

    public int minNumBooths(String[] demand) {
        int[] time = new int[26];
        for (String word : demand) {
            int[] num = new int[26];
            for (char c : word.toCharArray())
                num[c - 'a']++;

            for (int i = 0; i < 26; i++)
                time[i] = Math.max(time[i], num[i]);
        }

        return Arrays.stream(time).sum();
    }


}
