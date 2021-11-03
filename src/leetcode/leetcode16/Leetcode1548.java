package leetcode.leetcode16;

import java.util.*;

public class Leetcode1548 {
    public List<Integer> mostSimilar(int n, int[][] roads,
                                     String[] names, String[] targetPath) {
        Map<String,Integer> map=new HashMap<>();
        int length=names.length;
        for(int i=0;i<length;i++)
            map.put(names[i],i);
        Map<Integer,List<Integer>> map1=new HashMap<>();
        for(int i=0;i<n;i++)
            map1.put(i,new ArrayList<>());
        for(int[] road:roads){
            map1.get(road[0]).add(road[1]);
            map1.get(road[1]).add(road[0]);
        }
        int[] count=new int[length];
        int[] target=new int[targetPath.length];
        for(int i=0;i<targetPath.length;i++){
            target[i]=map.getOrDefault(targetPath[i],-1);
        }

        for(int j=0;j<length;j++){
            if(j!=target[0])
                count[j]=1;
        }
        System.out.println(Arrays.toString(count));

        int[][] res=new int[target.length][length];

        for(int i=1;i<target.length;i++){
            int[] newCount=new int[length];
            Arrays.fill(newCount,Integer.MAX_VALUE);
            for(int j=0;j<length;j++){
                if(count[j]==Integer.MAX_VALUE)
                    continue;
                List<Integer> list=map1.get(j);
                for(int next:list){
                    if(newCount[next]>count[j]){
                        newCount[next]=count[j];
                        res[i][next]=j;
                    }
                }
            }
            for(int j=0;j<length;j++){
                if(newCount[j]<Integer.MAX_VALUE&&j!=target[i])
                    newCount[j]++;
            }
            count=newCount;
            System.out.println(Arrays.toString(count));
        }

        List<Integer> result=new ArrayList<>();
        int pre=0;
        int max=count[0];
        for(int j=1;j<length;j++){
            if(count[j]<max){
                pre=j;
                max=count[j];
            }
        }
        result.add(pre);
        for(int i=target.length-1;i>=1;i--){
            result.add(res[i][pre]);
            pre=res[i][pre];
        }
        Collections.reverse(result);
        return result;
    }
}
