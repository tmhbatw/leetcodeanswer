package leetcode.leetcode18;

import java.util.*;

public class Leetcode1722 {

    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n=source.length;
        Union u=new Union(n);

        for(int[] edge:allowedSwaps){
            u.union(edge[0],edge[1]);
        }

        Map<Integer, List<Integer>> map=new HashMap<>();
        for(int i=0;i<n;i++){
            int t=u.getType(i);
            map.putIfAbsent(t,new ArrayList<>());
            map.get(t).add(i);
        }

        int result=0;
        for(int key:map.keySet()){
            List<Integer> l1=new ArrayList<>();
            List<Integer> l2=new ArrayList<>();
            for(int i:map.get(key)){
                l1.add(source[i]);
                l2.add(target[i]);
            }
            result+=getDif(l1,l2);
        }
        return result;
    }

    private int getDif(List<Integer> l1,List<Integer> l2){
        Collections.sort(l1);
        Collections.sort(l2);

        int diff=0;
        int j=0;
        for(int i=0;i<l1.size();i++){
            while(j<l2.size()&&l2.get(j)<l1.get(i))
                j++;
            if(j==l2.size()||!l2.get(j).equals(l1.get(i)))
                diff++;
            else
                j++;
        }
        return diff;
    }



    class Union {
        int[] time;
        int[] type;

        public Union(int n) {
            this.time = new int[n + 1];
            this.type = new int[n + 1];
            for (int i = 0; i < time.length; i++) {
                time[i] = 1;
                type[i] = i;
            }
        }

        private int getType(int n) {
            if (type[n] == n)
                return n;
            return getType(type[n]);
        }

        private boolean union(int a, int b) {
            int t1 = getType(a);
            int t2 = getType(b);

            if (t1 == t2)
                return false;
            if (time[t1] < time[t2]) {
                time[t2] += time[t1];
                type[t1] = t2;
            } else {
                time[t1] += time[t2];
                type[t2] = t1;
            }
            return true;
        }
    }
}
