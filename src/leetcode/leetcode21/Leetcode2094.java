package leetcode.leetcode21;

import java.util.*;

public class Leetcode2094 {

    public int[] findEvenNumbers(int[] digits) {
        Set<Integer> list=new HashSet<>();

        for(int i=0;i<digits.length;i++){
            if(digits[i]==0)
                continue;
            for(int j=0;j<digits.length;j++){
                if(i==j)
                    continue;
                for(int l=0;l<digits.length;l++){
                    if(i==l||j==l||digits[l]%2==1)
                        continue;
                    list.add(digits[i]*100+digits[j]*10+digits[l]);
                }
            }
        }

        int[] res=new int[list.size()];
        int index=0;
        for(int cur:list)
            res[index++]=cur;
        Arrays.sort(res);
        return res;
    }
}
