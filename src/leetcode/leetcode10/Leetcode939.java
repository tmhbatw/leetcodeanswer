package leetcode.leetcode10;

import com.sun.xml.internal.bind.v2.util.CollisionCheckStack;

import java.util.*;

public class Leetcode939 {

    public int minAreaRect(int[][] points) {
        Set<Integer> x=new HashSet<>();
        for(int[] point:points) {
            x.add(point[0]);
        }

        List<Integer> list=new ArrayList<>(x);
        Collections.sort(list);
        Map<Integer,Integer> index=new HashMap<>();
        for(int i=0;i<list.size();i++)
            index.put(list.get(i),i);

        List<Set<Integer>> set=new ArrayList<>();

        for(int i=0;i<list.size();i++){
            set.add(new HashSet<>());
        }

        for(int[] p:points){
            int i=index.get(p[0]);
            set.get(i).add(p[1]);
        }

        int result=Integer.MAX_VALUE;
        for(int i=0;i<set.size();i++){
            List<Integer> l=new ArrayList<>(set.get(i));
            Collections.sort(l);

            for(int a=0;a<l.size();a++){
                for(int b=a+1;b<l.size();b++){
                    for(int j=i+1;j<set.size();j++){
                        if(set.get(j).contains(l.get(a))&&set.get(j).contains(l.get(b))){
                            int area=(l.get(b)-l.get(a))*(list.get(j)-list.get(i));
                            result=Math.min(area,result);
                        }
                    }
                }
            }
        }

        return result==Integer.MAX_VALUE?0:result;
    }


}
