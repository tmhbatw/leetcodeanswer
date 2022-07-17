package leetcode.leetcode15;

public class Leetcode1404 {

    public int numSteps(String s) {
        char[] cur=s.toCharArray();
        int count =0;

        int add=0;
        for(int i=s.length()-1;i>=1;i--){
            int c=cur[i]-'0'+add;
            if(c==0){
                add=0;
                count++;
            }else if(c==1){
                add=1;
                count+=2;
            }else{
                add=1;
                count++;
            }
        }

        return count+add;
    }
}
