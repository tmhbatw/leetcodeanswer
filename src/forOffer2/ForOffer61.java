package forOffer2;

import java.util.*;

public class ForOffer61 {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> q=new PriorityQueue<>((o1,o2)->{
            return o1[2]-o2[2];
        });
        q.add(new int[]{0,0,nums1[0]+nums2[0]});
        List<List<Integer>> result=new ArrayList<>();
        Set<Integer> set=new HashSet<>();
        while(true){
            if(q.isEmpty()||result.size()==k)
                return result;
            int[] cur=q.poll();
            if(set.contains(cur[0]*1000+cur[1])) {
                continue;
            }
            set.add(cur[0]*1000+cur[1]);
            List<Integer> list=new ArrayList<>();
            list.add(nums1[cur[0]]);
            list.add(nums2[cur[1]]);
            result.add(list);
            if(cur[1]<nums2.length-1)
                q.add(new int[]{cur[0],cur[1]+1,nums1[cur[0]]+nums2[cur[1]+1]});
            if(cur[0]<nums1.length-1)
                q.add(new int[]{cur[0]+1,cur[1],nums1[cur[0]+1]+nums2[cur[1]]});

        }
    }
}
