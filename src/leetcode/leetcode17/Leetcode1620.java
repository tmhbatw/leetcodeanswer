package leetcode.leetcode17;

public class Leetcode1620 {

    public int[] bestCoordinate(int[][] towers, int radius) {
        double cur=0;
        int[] res=new int[2];
        for(int i=0;i<=50;i++){
            for(int j=0;j<=50;j++){

                double curr=0;
                for (int[] tower : towers) {

                    double dis = getDis(i, j, tower);
                    if (dis <= radius) {
                        curr += (int)((tower[2]) / (1 + dis));
                    }
                }
                if(curr>cur){
                    cur=curr;
                    res[0]=i;
                    res[1]=j;
                }

            }
        }

        return res;
    }

    private double getDis(int x,int y,int[] tower){
        return Math.sqrt((x-tower[0])*(x-tower[0])+(y-tower[1])*(y-tower[1]));
    }

}
