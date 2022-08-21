package leetcode.leetcode24;

import java.util.Arrays;

public class Leetcode2343 {

    class Node{
        String num;
        int i;
        public Node(String num,int i){
            this.num = num;
            this.i=i;
        }
    }
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        Node[] nodes=new Node[nums.length];
        for(int i=0;i<nums.length;i++){
            nodes[i]=new Node(nums[i],i);
        }

        int length=nums[0].length();
        int[] res=new int[queries.length];
        for(int i=0;i<queries.length;i++){
            int cur = i;
            Arrays.sort(nodes,(o1, o2)->{
                String oo1=o1.num.substring(length-queries[cur][1]);
                String oo2=o2.num.substring(length-queries[cur][1]);

                if(oo1.equals(oo2))
                    return o1.i-o2.i;

                return oo1.compareTo(oo2);
            });
            res[i]=nodes[queries[i][0]-1].i;
        }

        return res;
    }
}
