package leetcode.leetcode12;

public class Leetcode1151 {

    public int minSwaps(int[] data) {
        int count=0;
        for(int num:data)
            count+=num;
        if(count==0)
            return 0;
        int result=count;
        int sum=0;
        for(int i=0;i<data.length;i++){
            sum+=data[i];
            if(i<count-1)
                continue;
            result=Math.min(count-sum,result);
            sum-=data[i-count+1];
        }
        return result;
    }
}
