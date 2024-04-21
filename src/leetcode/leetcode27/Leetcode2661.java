package leetcode.leetcode27;

public class Leetcode2661 {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        if(mat.length==0){
            return 0;
        }
        int m = mat.length,n=mat[0].length;
        int[] rowMap = new int[m*n],colMap = new int[m*n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                rowMap[mat[i][j]-1] = i;
                colMap[mat[i][j]-1]=j;
            }
        }
        int[] rowCount = new int[m],colCount =new int[n];
        for(int i=0;i<arr.length;i++) {
            int num = arr[i];
            rowCount[rowMap[num-1]]++;
            colCount[colMap[num-1]]++;
            if (rowCount[rowMap[num-1]]==n||colCount[colMap[num-1]]==m) {
                return i;
            }
        }
        return -1;
    }
}
