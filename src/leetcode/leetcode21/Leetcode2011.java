package leetcode.leetcode21;

public class Leetcode2011 {

    public int finalValueAfterOperations(String[] operations) {
        int res=0;
        for(String cur:operations){
            char oper='+';
            for(int i=0;i<cur.length();i++){
                if(cur.charAt(i)=='-')
                    oper='-';
            }
            if(oper=='+')
                res++;
            else
                res--;
        }
        return res;
    }
}
