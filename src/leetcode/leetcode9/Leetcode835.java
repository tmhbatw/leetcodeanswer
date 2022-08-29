package leetcode.leetcode9;

public class Leetcode835 {

    public int largestOverlap(int[][] img1, int[][] img2) {
        int n=img1.length;
        int result=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){


                result= Math.max(getRes(img1,img2,i,j),result);
                result= Math.max(getRes(img2,img1,i,j),result);


            }
        }

        return result;
    }

    private int getRes(int[][] img1,int[][] img2,int i,int j){
        int n=img1.length;
        int count = 0;
        for(int ii=i;ii<n;ii++){
            for(int jj=j;jj<n;jj++){
                if(img2[ii-i][jj-j]==img1[ii][jj]&&img1[ii][jj]==1)
                    count++;
            }
        }
        int count2=0;
        for(int ii=i;ii<n;ii++){
            for(int jj=j;jj<n;jj++){
                if(img2[ii-i][jj]==img1[ii][jj-j]&&img1[ii][jj-j]==1)
                    count2++;
            }
        }
        return Math.max(count,count2);
    }

}
