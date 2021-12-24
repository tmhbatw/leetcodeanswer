package leetcode.leetcode22;

public class Leetcode2113 {

    public int[] elementInNums(int[] nums, int[][] queries) {
        int[] res=new int[queries.length];

        int[] num=new int[nums.length*2];
        for(int i=0;i<nums.length;i++)
            num[i]=num[i+nums.length]=nums[i];

        for(int i=0;i<queries.length;i++){
            int[] index=getIndex(num,queries[i][0]);
            res[i]=index[0]+queries[i][1]<index[1]?num[index[0]+queries[i][1]]:-1;
        }

        return res;
    }

    private int[] getIndex(int[] num,int time){
        time%=num.length;
        if(time<num.length/2)
            return new int[]{time,num.length/2};
        return new int[]{num.length/2,time};
    }
}
