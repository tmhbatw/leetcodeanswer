package leetcode.leetcode25;

public class Leetcode2400 {

    //最远到达k+startPos点，最左到达k-startPos点，一共2*k+1个点
    public int numberOfWays(int startPos, int endPos, int k) {
        int[] res=new int[k*2+1];
        endPos=(k-startPos)+endPos;
        if(endPos<0||endPos>2*k)
            return 0;
        int mod=1000000007;
        res[k]=1;
        for(int i=0;i<k;i++){
            int[] cur=new int[k*2+1];
            for(int j=0;j<cur.length;j++){
                if(j==0){
                    cur[j]=res[j+1];
                }else if(j==cur.length-1){
                    cur[j]=res[j-1];
                }else{
                    cur[j]=(res[j-1]+res[j+1])%mod;
                }
            }
            res=cur;
        }
        return res[endPos];
    }


}
