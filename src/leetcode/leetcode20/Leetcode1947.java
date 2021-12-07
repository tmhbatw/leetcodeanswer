package leetcode.leetcode20;

public class Leetcode1947 {

    int n;
    int result=0;
    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        this.n=mentors.length;
        int[][] score=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int s=0;
                for(int k=0;k<students[0].length;k++){
                    if(students[i][k]==mentors[j][k])
                        s++;
                }
                score[i][j]=s;
            }
        }
        dfs(score,0,0,0);
        return result;
    }

    private void dfs(int[][] s,int index,int state,int score){
        if(index==n){
            result=Math.max(result,score);
        }else{
            for(int i=0;i<n;i++){
                if(((state>>i)&1)==0){
                    state+=(1<<i);
                    dfs(s,index+1,state,score+s[index][i]);
                    state-=(1<<i);
                }
            }
        }
    }

}
