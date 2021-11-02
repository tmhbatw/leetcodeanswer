package leetcode.leetcode15;

import java.net.CookieHandler;
import java.util.*;

public class Leetcode1418 {

    public List<List<String>> displayTable(List<List<String>> orders) {
        Set<String> set=new HashSet<>();
        Set<Integer> set2=new HashSet<>();
        for(List<String> list:orders){
            set.add(list.get(2));
            set2.add(Integer.parseInt(list.get(1)));
        }
        List<String> food=new ArrayList<>(set);
        Collections.sort(food);
        List<Integer> table=new ArrayList<>(set2);
        Collections.sort(table);

        Map<String,Integer> foodMap=new HashMap<>();
        for(int i=0;i<food.size();i++){
            foodMap.put(food.get(i),i);
        }
        Map<String,Integer> tableMap=new HashMap<>();
        for(int i=0;i<table.size();i++){
            tableMap.put(table.get(i)+"",i);
        }

        List<List<String>> result=new ArrayList<>();
        List<String> list=new ArrayList<>();
        list.add("Table");
        list.addAll(food);
        result.add(list);
        int[][] res=new int[table.size()][food.size()];

        for(List<String> l:orders){
            res[tableMap.get(l.get(1))][foodMap.get(l.get(2))]++;
        }
        for(int i=0;i<table.size();i++){
            List<String> l=new ArrayList<>();
            l.add(table.get(i)+"");
            for(int j=0;j<food.size();j++){
                l.add(res[i][j]+"");
            }
            result.add(l);
        }
        return result;
    }
}
