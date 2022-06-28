package leetcode.leetcode23;

public class Leetcode2201 {

    public int digArtifacts(int n, int[][] artifacts, int[][] dig) {
        boolean[][] reached=new boolean[n][n];
        for(int[] d:dig){
            reached[d[0]][d[1]]=true;
        }

        int result = 0;
        for(int[] a:artifacts){
            boolean add=true;
            for(int i =a[0];i<=a[2]&&add;i++){
                for(int j = a[1]; j<=a[3]; j++){
                    if(!reached[i][j]){
                        add=false;
                        break;
                    }
                }
            }
            if(add)
                result++;
        }

        return result;
    }
}
