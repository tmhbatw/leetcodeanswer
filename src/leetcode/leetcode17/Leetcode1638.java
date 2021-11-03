package leetcode.leetcode17;

public class Leetcode1638 {

    public int countSubstrings(String s, String t) {
        int result=0;
        for(int i=0;i<s.length();i++){
            for(int j=0;j<t.length();j++){

                int dif=0;
                for(int k=0;k<Math.min(s.length()-i,t.length()-j);k++){
                    if(s.charAt(i+k)!=t.charAt(j+k))
                        dif++;
                    if(dif==1)
                        result++;
                    if(dif>1)
                        break;
                }
            }
        }
        return result;
    }
}
