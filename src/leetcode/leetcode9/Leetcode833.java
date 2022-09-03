package leetcode.leetcode9;

import java.util.Arrays;
import java.util.Comparator;

public class Leetcode833 {

    class Replace{
        int i;
        String s;
        String t;
        public Replace(int i,String s,String t){
            this.i=i;
            this.s=s;
            this.t=t;
        }
    }
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        int pre = 0;
        Replace[] nodes=new Replace[indices.length];
        for(int i=0;i<indices.length;i++){
            nodes[i]=new Replace(indices[i],sources[i],targets[i]);
        }

        Arrays.sort(nodes, Comparator.comparingInt(o -> o.i));
        StringBuilder sb=new StringBuilder();
        for(Replace node:nodes){
            if(s.startsWith(node.s, node.i)){
                sb.append(s, pre, node.i);
                sb.append(node.t);
                pre = node.i+node.s.length();
            }
        }

        return sb.append(s.substring(pre)).toString();
    }


}
