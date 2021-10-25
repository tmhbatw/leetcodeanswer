package interview;

public class Problem17_23 {

    public int[] findSquare(int[][] matrix) {
        int max=-1;
        int[] result=new int[3];
        int r=matrix.length,l=matrix[0].length;
        int[][] row=new int[r][l+1];
        for(int i=0;i<r;i++){
            for(int j=0;j<l;j++){
                row[i][j+1]=row[i][j]+matrix[i][j];
            }
        }
        int[][] col=new int[r+1][l];
        for(int j=0;j<l;j++){
            for(int i=0;i<r;i++){
                col[i+1][j]=col[i][j]+matrix[i][j];
            }
        }

        for(int i=0;i<r;i++){
            for(int j=0;j<l;j++){
                for(int n=0;n<Math.min(r-i,l-j);n++){
                    int ii=i+n;
                    int jj=j+n;
                    if(row[i][jj+1]-row[i][j]>0||col[ii+1][j]-col[i][j]>0)
                        break;
                    if(row[i][jj+1]-row[i][j]==0&&row[ii][jj+1]-row[ii][j]==0
                            &&col[ii+1][j]-col[i][j]==0&&col[ii+1][jj]-col[i][jj]==0){
                        if(n>max){
                            max=n;
                            result=new int[]{i,j,n+1};
                        }
                    }
                }
            }
        }

        return max==-1?new int[]{}:result;
    }
}
