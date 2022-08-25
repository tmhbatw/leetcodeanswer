package leetcode.leetcode24;

public class Leetcode2380 {

    public int secondsToRemoveOccurrences(String s) {
        int zeroTime = 0;
        int result = 0;
        int pre=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='0'){
                zeroTime++;
            }else{
                if(i==0){
                    continue;
                }
                if(zeroTime>0) {
                    pre = Math.max(pre + 1, zeroTime);
                    result = Math.max(result, pre);
                }
            }
        }

        return result;
    }
}
