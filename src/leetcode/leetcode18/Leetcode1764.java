package leetcode.leetcode18;

public class Leetcode1764 {

    public boolean canChoose(int[][] groups, int[] nums) {
        int i=0;
        for(int j=0;j<nums.length;j++){
            if(i==groups.length)
                break;
            if(isSame(groups[i],nums,j)){
                j+=groups[i].length-1;
                i++;
            }
        }

        return i==groups.length;
    }

    private boolean isSame(int[] group,int[] nums,int i){
        if(nums.length-i<group.length)
            return false;

        for(int j=0;j<group.length;j++){
            if(nums[i+j]!=group[j])
                return false;
        }
        return true;
    }

}
