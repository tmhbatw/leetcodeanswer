package leetcode.leetcode19;

public class Leetcode1869 {

    public boolean checkZeroOnes(String s) {
        int length1=0;
        int length2=0;
        for(int i=0;i<s.length();i++){
            char cur=s.charAt(i);
            int start=i;
            while(i<s.length()-1&&s.charAt(i+1)==cur)
                i++;
            if(cur=='1')
                length1=Math.max(length1,i-start+1);
            else
                length2=Math.max(length2,i-start+1);
        }
        return length1>length2;
    }
}
