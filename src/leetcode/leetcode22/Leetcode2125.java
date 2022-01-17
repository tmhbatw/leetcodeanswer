package leetcode.leetcode22;

public class Leetcode2125 {

    public int numberOfBeams(String[] bank) {
        int pre=0;
        int result=0;

        for(String cur:bank){
            int num=0;
            for(char c:cur.toCharArray())
                num+=c-'0';

            if(num==0)
                continue;

            result+=pre*num;
            pre=num;
        }
        return result;
    }


}
