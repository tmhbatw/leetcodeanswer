package lcp;

import java.util.Arrays;

public class lcp51 {

    int result=-1;
    int[] materials;
    int[][] cookbooks;
    int[][] attribute;

    public int perfectMenu(int[] materials, int[][] cookbooks,
                           int[][] attribute, int limit) {
        this.materials = materials;
        this.cookbooks = cookbooks;
        this.attribute = attribute;
        dfs(materials.clone(),0,0,0,limit);
        return result;
    }

    private void dfs(int[] curm ,int index, int l,int cur,int limit){
        if(index==cookbooks.length){
            if(l>=limit){
                result=Math.max(cur,result);
            }
            return;
        }
        if(isBig(curm,cookbooks[index])){
            int[] nextm=curm.clone();
            for(int i=0;i<cookbooks[index].length;i++){
                nextm[i]-=cookbooks[index][i];
            }
            dfs(nextm,index+1,l+attribute[index][1],cur+attribute[index][0],limit);
        }

        dfs(curm,index+1,l,cur,limit);
    }

    private boolean isBig(int[] curm, int[] cost){
        for(int i=0;i<curm.length;i++){
            if(curm[i]<cost[i])
                return false;
        }
        return true;
    }

    public static void main(String[] args){
        int[] num=new int[]{1,2,3};
        int[] num2=num.clone();
        num2[0]=0;
        System.out.println(Arrays.toString(num));
        System.out.println(Arrays.toString(num2));
    }
}
