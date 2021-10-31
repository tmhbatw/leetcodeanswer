package leetcode.leetcode12;

public class Leetcode1198 {

    public int smallestCommonElement(int[][] mat) {
        int[] index=new int[mat.length];

        for(int j=0;j<mat[0].length;j++){
            int cur=mat[0][j];

            for(int i=1;i<mat.length;i++){
                while(mat[i][index[i]]<cur){
                    index[i]++;
                    if(index[i]==mat[i].length)
                        return -1;
                }
                if(mat[i][index[i]]>cur){
                    break;
                }
                if(i==mat.length-1)
                    return cur;
            }
        }
        return -1;
    }
}
