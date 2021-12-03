package leetcode.leetcode11;

import java.util.ArrayList;
import java.util.List;

public class Leetcode1055 {

    public int shortestWay(String source, String target) {
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<26;i++)
            list.add(new ArrayList<>());
        for(int i=0;i<source.length();i++){
            list.get(source.charAt(i)-'a').add(i);
        }

        int count=0;
        int pre=source.length();

        for(char t:target.toCharArray()){
            List<Integer> l=list.get(t-'a');
            if(l.size()==0)
                return -1;

            int r=l.size()-1;
            if(pre>=l.get(r)){
                count++;
                pre=l.get(0);
            }else{
                int left=0;
                while(left<r){
                    int mid=(left+r)/2;
                    if(l.get(mid)<=pre)
                        left=mid+1;
                    else
                        r=mid;
                }
                pre=l.get(left);
            }
            //System.out.println(count+" "+pre);
        }
        return count;
    }
}
