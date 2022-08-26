package leetcode.leetcode21;

import java.util.Arrays;

public class Leetcode2002 {

    int result=0;
    public int maxProduct(String s) {
        dfs(s.toCharArray(),"","",0);
        return result;
    }

    private void dfs(char[] c,String cur1,String cur2,int i){
        if(i==c.length){
            result=Math.max(result,getRes(cur1,cur2));
            return;
        }
        dfs(c,cur1+c[i],cur2,i+1);
        dfs(c,cur1,cur2+c[i],i+1);
    }
    private int getRes(String cur1,String cur2){
        return getRes(cur1)*getRes(cur2);
    }


    private int getRes(String cur){
        if(cur.length()==0)
            return 0;
        char[] c=cur.toCharArray();
        int[][] res=new int[c.length][c.length];
        for(int i=0;i<res.length;i++){
            for(int j=0;j<res.length-i;j++){
                if(i==0){
                    res[j][j]=1;
                    continue;
                }
                int k=j+i;
                if(c[j]==c[k]){
                    res[j][k]=2+res[j+1][k-1];
                }else{
                    res[j][k]=Math.max(res[j+1][k],res[j][k-1]);
                }
            }
        }

        return res[0][c.length-1];
    }

    public static void main(String[] args){
        String t="leetcode";
        new Leetcode2002().getRes(t);
    }

}
