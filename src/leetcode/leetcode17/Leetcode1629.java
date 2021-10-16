package leetcode.leetcode17;

public class Leetcode1629 {

    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int pre=0;
        int maxVal=0;
        char res='a';
        for(int i=0;i<releaseTimes.length;i++){
            int cur=releaseTimes[i]-pre;
            if(cur>maxVal){
                maxVal=cur;
                res=keysPressed.charAt(i);
            }else if(cur==maxVal)
                res= (char) Math.max(res,keysPressed.charAt(i));
            pre=releaseTimes[i];
        }
        return res;
    }
}
