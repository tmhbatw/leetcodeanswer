package leetcode.leetcode25;

import java.util.Arrays;

public class Leetcode2491 {

    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        int base=skill[0]+skill[skill.length-1];

        long result=0;
        for(int i=0;i<skill.length/2;i++){
            if(skill[i]+skill[skill.length-1-i]!=base)
                return -1;
            result+= (long) skill[i] *skill[skill.length-1-i];
        }

        return result;
    }

}
