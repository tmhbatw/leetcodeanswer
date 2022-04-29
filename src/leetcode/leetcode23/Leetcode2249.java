package leetcode.leetcode23;

public class Leetcode2249 {

    public int countLatticePoints(int[][] circles) {
        int result=0;
        for(int i=0;i<=200;i++){
            for(int j=0;j<=200;j++){
                for(int[] circle:circles){
                    if(inCircle(i,j,circle)){
                        result++;
                        break;
                    }
                }
            }
        }

        return result;
    }

    private boolean inCircle(int i ,int j ,int[] circle){
        int distance=(i-circle[0])*(i-circle[0])+(j-circle[1])*(j-circle[1]);
        return distance<=circle[2]*circle[2];
    }
}
