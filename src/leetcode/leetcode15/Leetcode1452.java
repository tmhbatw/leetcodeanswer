package leetcode.leetcode15;

import java.util.*;

public class Leetcode1452 {

    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        List<List<Integer>> l=new ArrayList<>();

        Map<String,Integer> map=new HashMap<>();
        int index=0;
        for(List<String> list:favoriteCompanies){
            List<Integer> curList=new ArrayList<>();
            for(String s:list) {
                map.putIfAbsent(s,index++);
                curList.add(map.get(s));
            }
            Collections.sort(curList);
            l.add(curList);
        }

        List<Integer> result=new ArrayList<>();
        for(int i=0;i<l.size();i++){
            boolean flag=true;
            for(int j=0;j<l.size()&&flag;j++){
                if(i==j)
                    continue;
                if(isMatch(l.get(j),l.get(i)))
                    flag=false;
            }
            if(flag)
                result.add(i);
        }
        return result;
    }

    private boolean isMatch(List<Integer> l1,List<Integer> l2){
        int i=0;
        for(int num:l2){
            while(i<l1.size()&&l1.get(i)<num)
                i++;
            if(i==l1.size()||l1.get(i)>num)
                return false;
            i++;
        }
        return true;
    }
}
