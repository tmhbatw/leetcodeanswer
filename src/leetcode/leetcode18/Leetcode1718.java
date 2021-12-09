package leetcode.leetcode18;

public class Leetcode1718 {


    int n;
    boolean flag=false;
    public int[] constructDistancedSequence(int n) {
        this.n=n;
        int[] res=new int[n*2-1];
        dfs(res,0,0);
        return res;
    }

    private void dfs(int[] res,int index,int cur){
        if(flag)
            return;
        if(index==res.length) {
            flag=true;
            return;
        }
        if(res[index]!=0){
            dfs(res,index+1,cur);
            return;
        }
        for(int i=n;i>=2;i--){
            if(((cur>>i)&1)==0&&index+i<res.length&&res[index+i]==0){
                res[index]=i;
                res[index+i]=i;
                cur+=(1<<i);
                dfs(res,index+1,cur);
                if(flag)
                    return;
                cur-=(1<<i);
                res[index]=0;
                res[index+i]=0;
            }
        }
        if(((cur>>1)&1)==0){
            res[index]=1;
            cur+=1<<1;
            dfs(res,index+1,cur);
            if(flag)
                return;
            res[index]=0;
        }
    }
}
