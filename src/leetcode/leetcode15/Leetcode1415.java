package leetcode.leetcode15;

public class Leetcode1415 {

    public String getHappyString(int n, int k) {
        int max=3;
        for(int i=1;i<n;i++)
            max*=2;
        if(max<k)
            return "";
        StringBuilder sb=new StringBuilder();
        char pre='d';
        char cur='a';

        max/=3;
        for(int i=0;i<n;i++){
            while(k>max){
                k-=max;
                cur=addChar(cur,pre);
            }
            sb.append(cur);
            pre=cur;
            cur='a'==pre?'b':'a';

            max/=2;
        }
        return sb.toString();
    }

    private char addChar(char cur,char pre){
        cur=(char)(cur+1);
        if(cur==pre)
            return (char)(pre+1);
        return cur;
    }

}
