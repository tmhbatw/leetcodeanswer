package leetcode.leetcode21;

public class Leetcode2013 {

    class DetectSquares {

        int[][] time;
        public DetectSquares() {
            this.time=new int[1001][1001];
        }

        public void add(int[] point) {
            time[point[0]][point[1]]++;
        }

        public int count(int[] point) {
            //先找x轴的另一个点
            int count=0;
            int x=point[0],y=point[1];
            for(int j=0;j<=1000;j++){
                if(j==y)
                    continue;
                if(time[x][j]!=0){
                    //判断能不能构成正方形
                    int edge=Math.abs(y-j);
                    int small=x-edge;
                    if(small>=0){
                        count+=time[small][y]*time[small][j]*time[x][j];
                    }
                    int big=x+edge;
                    if(big<=1000){
                        count+=time[big][y]*time[big][j]*time[x][j];
                    }
                }
            }
            return count;
        }
    }
}
