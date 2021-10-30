package leetcode.leetcode18;

public class Leetcode1769 {

    public int[] minOperations(String boxes) {
        int length=boxes.length();
        int[] num=new int[length];

        int distance=0;
        int left=0;
        int right=0;
        for(int i=0;i<length;i++){
            if(boxes.charAt(i)=='1'){
                right++;
                distance+=i;
            }
        }

        for(int i=0;i<length;i++){
            num[i]=distance;
            if(boxes.charAt(i)=='1'){
                left++;
                right--;
            }
            distance+=left-right;
        }

        return num;
    }
}
