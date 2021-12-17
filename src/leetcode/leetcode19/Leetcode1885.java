package leetcode.leetcode19;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Leetcode1885 {


    public long countPairs(int[] nums1, int[] nums2) {
        int length=nums1.length;

        //首先获取所有的nums1[i]-nums2[i]的情况
        int[] diff=new int[length];
        for(int i=0;i<length;i++)
            diff[i]=nums1[i]-nums2[i];

        Arrays.sort(diff);
        int index=1;
        TreeMap<Integer,Integer> map=new TreeMap<>();

        for(int j=length-1;j>=0;j--){
            while(j>=1&&diff[j]==diff[j-1])
                j--;
            map.put(diff[j],index++);
        }

        long result=0;
        TreeArray tree=new TreeArray(index);

        for(int i=0;i<length;i++){
            Integer val=map.ceilingKey(nums2[i]-nums1[i]+1);
            if(val!=null){
                result+=tree.getRes(map.get(val));
            }


            tree.update(map.get(nums1[i]-nums2[i]));
        }

        return result;
    }

    class TreeArray{
        int n;
        int[] num;
        public TreeArray(int n){
            this.n=n;
            this.num=new int[n];
        }

        private int lowbit(int x){
            return x&(-x);
        }

        private void update(int x){
            while(x<num.length){
                num[x]++;
                x+=lowbit(x);
            }
        }

        private int getRes(int x){
            int result=0;
            while(x>0){
                result+=num[x];
                x-=lowbit(x);
            }
            return result;
        }
    }


}
