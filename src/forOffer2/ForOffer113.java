package forOffer2;

import java.util.*;

public class ForOffer113 {


    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] num=new int[numCourses];
        Map<Integer, List<Integer>> map=new HashMap<>();
        for(int[] cur:prerequisites){
            map.putIfAbsent(cur[1],new ArrayList<>());
            map.get(cur[1]).add(cur[0]);
            num[cur[0]]++;
        }
        int[] res=new int[numCourses];
        int index=0;
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<num.length;i++){
            if(num[i]==0)
                q.add(i);
        }
        while(!q.isEmpty()){
            int cur=q.poll();
            res[index++]=cur;
            List<Integer> list=map.getOrDefault(cur,new ArrayList<>());
            for(int next:list){
                num[next]--;
                if(num[next]==0)
                    q.add(next);
            }
        }
        System.out.println(index);
        return index==res.length?res:new int[]{};
    }


}
