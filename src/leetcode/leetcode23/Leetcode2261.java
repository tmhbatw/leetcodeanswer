package leetcode.leetcode23;

import java.util.HashMap;
import java.util.Map;

public class Leetcode2261 {

    class Tree{
        Map<Integer,Tree> map;
        public Tree(){
            this.map=new HashMap<>();
        }
    }

    public int countDistinct(int[] nums, int k, int p) {
        int result = 0;
        Map<Integer,Tree> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int count = 0;
            Map<Integer,Tree> cur = map;

            for(int j=i;j<nums.length;j++){
                if(nums[j]%p==0)
                    count ++;
                if(count>k)
                    break;
                if(!cur.containsKey(nums[j])){
                    result++;
                    cur.put(nums[j],new Tree());
                }
                cur = cur.get(nums[j]).map;
            }
        }

        return result;
    }
}
