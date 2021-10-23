package interview;

public class Problem16_14 {

    //直线方程为
    //（x-x1)/(x2-x1)=(y-y1)/(y2-y1);
    //(x-x1)*(y2-y1)=(y-y1)*(x2-x1);

    public int[] bestLine(int[][] points) {
        int max=0;
        int[] result=new int[]{0,1};
        for(int i=0;i<points.length-2;i++){
            for(int j=i+1;j<points.length-1;j++){

                int cur=0;
                for(int k=j+1;k<points.length;k++){
                    if((points[k][0]-points[i][0])*(points[j][1]-points[i][1])==
                            (points[k][1]-points[i][1])*(points[j][0]-points[i][0]))
                        cur++;
                }
                if(cur>max){
                    max=cur;
                    result[0]=i;
                    result[1]=j;
                }

            }
        }
        return result;
    }
}
