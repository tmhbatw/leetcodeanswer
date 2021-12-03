package leetcode.leetcode16;

import java.security.cert.CollectionCertStoreParameters;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Leetcode1584 {

    public int minCostConnectPoints(int[][] points) {
        List<int[]> list=new ArrayList<>();
        for(int i=0;i<points.length;i++){
            for(int j=1;j<points.length;j++){
                list.add(new int[]{i,j,Math.abs(points[i][0]-points[j][0])
                        +Math.abs(points[i][1]-points[j][1])});
            }
        }

        Collections.sort(list,(o1,o2)->{
            return o1[2]-o2[2];
        });

        int[] type=new int[points.length];
        for(int i=0;i<type.length;i++)
            type[i]=i;

        int result=0;
        int n=points.length;
        for(int[] edge:list){
            int t1=getType(type,edge[0]);
            int t2=getType(type,edge[1]);
            if(t1!=t2){
                n--;
                result+=edge[2];
                type[t2]=t1;
            }
            if(n==1)
                break;
        }

        return result;
    }

    private int getType(int[] type,int cur){
        if(type[cur]==cur)
            return cur;
        return getType(type,type[cur]);
    }
}
