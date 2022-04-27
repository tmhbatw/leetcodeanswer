package leetcode.leetcode23;

public class Leetcode2212 {

    int[] result=new int[]{};
    int res= 0 ;
    public int[] maximumBobPoints(int numArrows, int[] aliceArrows) {
        dfs(numArrows,aliceArrows,0,0,new int[12]);
        return result;
    }

    private void dfs(int numArrows, int[] aliceArrows,int i,int cur,int[] row){
        if(i==aliceArrows.length){
            if(cur>res){
                row[0]+=numArrows;
                result = row.clone();
                res = cur;
            }
            return;
        }

        dfs(numArrows,aliceArrows,i+1,cur,row);
        if(numArrows>aliceArrows[i]){
            int[] nextRow=row.clone();
            nextRow[i]=aliceArrows[i]+1;
            dfs(numArrows-aliceArrows[i]-1,aliceArrows,i+1,cur+i,nextRow);
        }
    }
}
