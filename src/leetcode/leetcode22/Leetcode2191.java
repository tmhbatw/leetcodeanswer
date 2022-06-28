package leetcode.leetcode22;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Leetcode2191 {

    class Node{
        int key;
        int val;
        public Node(int key,int val){
            this.key=key;
            this.val=val;
        }
    }

    public int[] sortJumbled(int[] mapping, int[] nums) {
        List<Node> list=new ArrayList<>();
        for(int num:nums)
            list.add(new Node(num,getVal(num,mapping)));

        list.sort(Comparator.comparingInt(o -> o.val));
        int[] result=new int[nums.length];
        for(int i=0;i<list.size();i++)
            result[i]=list.get(i).key;


        return result;
    }

    private int getVal(int cur,int[] mapping){
        if(cur==0)
            return mapping[0];
        int result =0;
        int base = 1;
        while(cur>0){
            int last = cur%10;
            result += base*mapping[last];
            base *= 10;
            cur/=10;
        }

        return result;
    }
}
