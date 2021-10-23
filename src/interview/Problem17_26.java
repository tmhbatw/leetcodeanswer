package interview;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem17_26 {

    public List<String> computeSimilarities(int[][] docs) {
        int n=docs.length;
        int[][] res=new int[n][n];

        Map<Integer,List<Integer>> map=new HashMap<>();
        for(int i=0;i<n;i++){
            for(int cur:docs[i]){
                if(!map.containsKey(cur)){
                    List<Integer> list=new ArrayList<>();
                    list.add(i);
                    map.put(cur,list);
                }else{
                    List<Integer> list=map.get(cur);
                    for(int ii:list){
                       res[ii][i]++;
                    }
                    list.add(i);
                }
            }
        }

        List<String> result=new ArrayList<>();
        DecimalFormat df=new DecimalFormat("0.0000");

        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                if(res[i][j]!=0){
                    result.add(i+","+j+": "+df.format(1.0*res[i][j]/
                            (docs[i].length+docs[j].length-res[i][j])));
                }
            }
        }
        return result;
    }
}
