package interview;

import java.util.ArrayList;
import java.util.List;

public class Problem16_3 {

    public double[] intersection(int[] start1, int[] end1, int[] start2, int[] end2) {
        int[] val1=getVal(start1,end1);
        int[] val2=getVal(start2,end2);
        if(val1[0]*val2[1]==val1[1]*val2[0]) {
            if(val1[2]==val2[2]){
                if(start1[0]==end1[0]&&end1[0]==start2[0]&&start2[0]==end2[0]){
                    int min1=Math.min(start1[1],end1[1]);
                    int max1=Math.max(start1[1],end1[1]);
                    int min2=Math.min(start2[1],end2[1]);
                    int max2=Math.max(start2[1],end2[1]);

                    if(min2>max1||max2<min1)
                        return new double[]{};
                    return new double[]{start1[0],Math.max(min1,min2)};
                }
                if(start1[0]>end1[0]){
                    int[] temp=start1;
                    start1=end1;
                    end1=temp;
                }
                if(start2[0]>end2[0]){
                    int[] temp=start2;
                    start2=end2;
                    end2=temp;
                }
                if(start2[0]>end1[0]||end2[0]<start1[0])
                    return new double[]{};
                if(start2[0]>start1[0])
                    return new double[]{start2[0],start2[1]};
                return new double[]{start1[0],start1[1]};
            }
            return new double[]{};
        }

        //( B2C1 - B1C2 ) / ( A1B2 - A2B1)
        double x=(val1[1]*val2[2]-val2[1]*val1[2])*1.0/(val1[0]*val2[1]-val2[0]*val1[1]);
        //(A1C2 - A2C1) / ( A1B2 - A2B1)
        double y=(val2[0]*val1[2]-val1[0]*val2[2])*1.0/(val1[0]*val2[1]-val2[0]*val1[1]);


        if(x>Math.max(start1[0],end1[0])||x<Math.min(start1[0],end1[0])
                ||y>Math.max(start1[1],end1[1])||y<Math.min(start1[1],end1[1])
                ||x>Math.max(start2[0],end2[0])||x<Math.min(start2[0],end2[0])
                ||y>Math.max(start2[1],end2[1])||y<Math.min(start2[1],end2[1]))
            return new double[]{};
        return new double[]{x,y};
    }


    //(y-y1)/(y2-y1)=(x-x1)/(x2-x1)
    //(x2-x1)y-(x2-x1)y1+(y1-y2)x-(y1-y2)x1=0
    private int[] getVal(int[] point1,int[] point2){
        int a=point1[1]-point2[1];
        int b=point2[0]-point1[0];
        int c=(point1[0]-point2[0])*point1[1]-(point1[1]-point2[1])*point1[0];
        return new int[]{a,b,c};
    }
}
