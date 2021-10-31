package leetcode.leetcode16;

import java.util.ArrayList;
import java.util.List;

public class Leetcode1557 {

    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        boolean[] degree=new boolean[n];
        for(List<Integer> edge:edges){
            degree[edge.get(1)]=true;
        }
        List<Integer> result=new ArrayList<>();
        for(int i=0;i<degree.length;i++){
            if(!degree[i])
                result.add(i);
        }
        return result;
    }
}
