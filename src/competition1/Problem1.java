package competition1;

public class Problem1 {
    /*
    *
    * */

    public int nearestValidPoint(int x, int y, int[][] points) {
        int index=-1;
        int dis=Integer.MAX_VALUE;
        for(int i=0;i<points.length;i++){
            if(x==points[i][0]||y==points[i][1]){
                int curDis=Math.abs(x-points[i][0])+Math.abs(y-points[i][1]);
                if(curDis<dis){
                    dis=curDis;
                    index=i;
                }
            }
        }
        return index;
    }
}
