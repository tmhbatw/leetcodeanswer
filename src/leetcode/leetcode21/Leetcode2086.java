package leetcode.leetcode21;

public class Leetcode2086 {

    public int minimumBuckets(String street) {
        char[] c=street.toCharArray();
        if(c.length==1)
            return c[0]=='H'?-1:0;

        int count = 0;
        for(int i=0;i<c.length;i++){
            if(c[i]=='H'){
                if(i==0&&c[i+1]=='H'||i==c.length-1&&c[i-1]=='H'
                        ||i>=1&&i<c.length-1&&c[i-1]=='H'&&c[i+1]=='H')
                    return -1;
                if(i>0&&c[i-1]=='W')
                    continue;
                if(i<c.length-1&&c[i+1]=='.'){
                    c[i+1]='W';
                }else
                    c[i-1]='W';
                count++;
            }
        }
        return count;
    }


}
