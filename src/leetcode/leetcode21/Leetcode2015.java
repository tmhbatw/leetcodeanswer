package leetcode.leetcode21;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Leetcode2015 {

    public int[][] averageHeightOfBuildings(int[][] buildings) {
        TreeMap<Integer,Integer> map1=new TreeMap<>();
        TreeMap<Integer,Integer> map2=new TreeMap<>();

        for(int[] building:buildings){
            map1.put(building[0],map1.getOrDefault(building[0],0)+building[2]);
            map1.put(building[1],map1.getOrDefault(building[1],0)-building[2]);
            map2.put(building[0],map2.getOrDefault(building[0],0)+1);
            map2.put(building[1],map2.getOrDefault(building[1],0)-1);
        }

        List<int[]> list=new ArrayList<>();
        int preHeight=0;
        int preX=0;
        int preTime=0;

        int height=0;
        int time=0;
        for(int key:map1.keySet()){
            height+=map1.get(key);
            time+=map2.get(key);
            int curHeight=getHeight(height,time);
            int pre=getHeight(preHeight,preTime);
            if(pre==curHeight)
                continue;

            if(pre!=0){
                int[] res=new int[]{preX,key,pre};
                list.add(res);
            }
            preTime=time;
            preHeight=height;
            preX=key;
        }

        int[][] result=new int[list.size()][];
        for(int i=0;i<result.length;i++)
            result[i]=list.get(i);
        return result;
    }

    private int getHeight(int height,int time){
        if(time==0)
            return 0;
        return height/time;
    }
}
