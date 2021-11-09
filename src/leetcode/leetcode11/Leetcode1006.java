package leetcode.leetcode11;

public class Leetcode1006 {
    public int clumsy(int n) {
        if(n==1)
            return 1;
        if(n==2)
            return 2;
        if(n==3)
            return 6;

        int result=n*(n-1)/(n-2);
        boolean add=true;

        for(int j=n-3;j>=1;j--){
            if(add)
                result+=j;
            else{
                int cur=j;
                if(j>=3){
                    cur=cur*(j-1)/(j-2);
                    j-=2;
                }else if(j>=2) {
                    cur = cur * (--j);
                }
                result-=cur;
            }
            add=!add;
        }
        return result;
    }


}
