package leetcode.leetcode18;

public class Leetcode1759 {

    public int countHomogenous(String s) {
        long result = 0;
        for(int i=0;i<s.length();i++){
            int start = i;
            while(i<s.length()-1&&s.charAt(i+1)==s.charAt(i))
                i++;
            result+=getRes(i-start+1);
        }

        return (int)(result%1000000007);
    }

    private long getRes(int cur){
        return (long)cur*(cur+1)/2;
    }
}
