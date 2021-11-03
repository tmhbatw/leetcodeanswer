package leetcode.leetcode6;

import java.util.ArrayList;
import java.util.List;

public class Leetcode544 {

    public String findContestMatch(int n) {
        List<String> list=new ArrayList<>();
        for(int i=1;i<=n;i++)
            list.add(i+"");
        while(list.size()>1){
            List<String> newList=new ArrayList<>();
            for(int i=0;i<list.size()/2;i++){
                newList.add("("+list.get(i)+","+list.get(list.size()-1-i)+")");
            }
            list=newList;
        }
        return list.get(0);
    }
}
