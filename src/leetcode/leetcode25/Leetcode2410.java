package leetcode.leetcode25;

import java.util.Arrays;

public class Leetcode2410 {

    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);

        int result = 0;
        int j=0;

        for(int player :players){
            while(j<trainers.length&&trainers[j]<player)
                j++;
            if(j==trainers.length)
                break;
            j++;
            result++;
        }

        return result;
    }


}
