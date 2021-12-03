package leetcode.leetcode8;

import java.util.*;

public class Leetcode721 {

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String,String> emailToName=new HashMap<>();
        Map<String,String> map=new HashMap<>();

        for(List<String> account:accounts){
            String name=account.get(0);
            String father;
            for(int i=1;i<account.size();i++){
                if(i==1){

                }
            }
        }

        List<List<String>> result=new ArrayList<>();
        return result;
    }

    private String getType(Map<String,String> map,String cur){
        if(map.get(cur).equals(cur))
            return cur;
        return getType(map,map.get(cur));
    }
}
