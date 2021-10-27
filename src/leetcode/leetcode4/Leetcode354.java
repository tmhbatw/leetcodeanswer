package leetcode.leetcode4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode354 {

    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes,(o1,o2)->{
            if(o1[0]==o2[0]){
                return o2[1]-o1[1];
            }
            return o1[0]-o2[0];
        });

        List<Integer> list=new ArrayList<>();
        for(int[] envelop:envelopes){
            if(list.isEmpty()||envelop[1]>list.get(list.size()-1))
                list.add(envelop[1]);
            int l=0,r=list.size()-1;
            while(l<r){
                int mid=(l+r)/2;
                if(list.get(mid)<envelop[1])
                    l=mid+1;
                else
                    r=mid;
            }
            list.set(l,envelop[1]);
        }

        return list.size();
    }
}
