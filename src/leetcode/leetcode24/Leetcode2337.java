package leetcode.leetcode24;

public class Leetcode2337 {

    public boolean canChange(String start, String target) {
        char[] s=start.toCharArray();
        char[] t=target.toCharArray();

        int i=0;
        for(int j=0;j<t.length;j++){
            if(t[j]=='_')
                continue;
            while(i<s.length&&s[i]=='_')
                i++;
            if(i==s.length||s[i]!=t[j]||s[i]=='L'&&i<j||s[i]=='R'&&i>j)
                return false;

            i++;
        }

        for(;i<s.length;i++){
            if(s[i]!='_')
                return false;
        }
        return true;
    }

}
