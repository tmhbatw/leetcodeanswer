package leetcode.leetcode4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Leetcode373 {
    /*Description
    * 给定两个以升序排列的整形数组 nums1 和 nums2, 以及一个整数 k。
    * 定义一对值(u,v)，其中第一个元素来自nums1，第二个元素来自 nums2。
    * 找到和最小的 k 对数字(u1,v1), (u2,v2) ... (uk,vk)。
    * */

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> queue=new PriorityQueue(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                int[] oo1=(int[])o1,oo2=(int[])o2;
                int sum1=nums1[oo1[0]]+nums2[oo1[1]];
                int sum2=nums1[oo2[0]]+nums2[oo2[1]];
                if(sum1==sum2)
                    return nums1[oo1[0]]-nums1[oo2[0]];
                return sum1-sum2;
            }
        });
        List<List<Integer>> result=new ArrayList<>();
        if(nums1==null||nums1.length==0||nums2==null||nums2.length==0)
            return result;
        int length1=nums1.length,length2=nums2.length;
        for(int i=0;i<length1;i++)
            queue.add(new int[]{i,0});
        while(!queue.isEmpty()&&k-->0){
            int[] cur=queue.poll();
            List<Integer> list=new ArrayList<>();
            list.add(nums1[cur[0]]);
            list.add(nums2[cur[1]]);
            result.add(list);
            if(cur[1]<length2-1)
                queue.add(new int[]{cur[0],cur[1]+1});
        }
        return result;
    }
}
