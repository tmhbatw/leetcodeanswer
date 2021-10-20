package forOffer2;

import java.util.HashSet;
import java.util.Set;

public class ForOffer116 {

    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        int[] type=new int[n];
        for(int i=0;i<n;i++)
            type[i]=i;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(isConnected[i][j]==1){
                    int type1=getType(type,i);
                    int type2=getType(type,j);
                    if(type1==type2)
                        continue;
                    type[type1]=type[type2];
                }
            }
        }
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<n;i++){
            set.add(getType(type,i));
        }
        return set.size();
    }

    private int getType(int[] type,int cur){
        if(type[cur]==cur)
            return cur;
        return getType(type,type[cur]);
    }
}
