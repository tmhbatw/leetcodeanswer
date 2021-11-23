package leetcode.leetcode21;

public class Leetcode2078 {

    public int maxDistance(int[] colors) {
        int result=0;
        for(int i=0;i<colors.length;i++){
            for(int j=colors.length-1;j>i;j--){
                if(colors[i]!=colors[j]) {
                    result = Math.max(result, j - i);
                    break;
                }
            }
        }
        return result;
    }
}
