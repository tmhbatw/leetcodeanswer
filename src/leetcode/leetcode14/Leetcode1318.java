package leetcode.leetcode14;

public class Leetcode1318 {

    public int minFlips(int a, int b, int c) {
        int result=0;
        for(int i=0;i<31;i++){
            int aa=getRes(a,i);
            int bb=getRes(b,i);
            int cc=getRes(c,i);

            if(cc==1&&((aa|bb)==0))
                result++;
            if(cc==0) {
                if(aa==1)
                    result++;
                if(bb==1)
                    result++;
            }
        }
        return result;
    }

    private int getRes(int a,int i){
        return (a>>i)&1;
    }
}
