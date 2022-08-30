package leetcode.leetcode12;

public class Leetcode1156 {

    public int maxRepOpt1(String text) {
        int[] time=new int[26];
        for(char c:text.toCharArray())
            time[c-'a']++;

        int result=1;

        char pre = text.charAt(0);
        int start = 0;
        boolean diff = false;
        int diffIndex=-1;
        for(int i=1;i<text.length();i++){
            if(text.charAt(i)==pre){
                continue;
            }
            if (!diff) {
                diff = true;
                diffIndex = i;
                continue;
            }

            result = Math.max(result,Math.min(time[pre-'a'],i-start));
            if(i-diffIndex>=3){
                diff=false;
                start = diffIndex+1;
                diffIndex = -1;
                i--;
            }else{
                diff=false;
                start = diffIndex;
                i=diffIndex;
                diffIndex = -1;
                pre=text.charAt(i);
            }

        }
        int last = text.length()-start;
        if(!diff){
            last ++;
        }
        result=Math.max(result,Math.min(last,time[pre-'a']));
        return result;
    }

}
