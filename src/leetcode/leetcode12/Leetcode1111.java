package leetcode.leetcode12;

import java.util.Stack;

public class Leetcode1111 {

    public int[] maxDepthAfterSplit(String seq) {
        Stack<Integer> s=new Stack<>();
        int distance=0;
        int[] res=new int[seq.length()];

        for(int i=0;i<seq.length();i++){
            if(seq.charAt(i)=='('){
                s.add(i);
                distance++;
            }
            else{
                int cur=s.pop();
                if(distance%2==1){
                    res[cur]=1;
                    res[i]=1;
                }
                distance--;

            }
        }
        return res;
    }
}
