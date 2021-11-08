package leetcode.leetcode17;

import java.util.*;

public class Leetcode1600 {
    class ThroneInheritance {

        Map<String, List<String>> map;
        Set<String> death;
        String king;
        public ThroneInheritance(String kingName) {
            this.king=kingName;
            this.map=new HashMap<>();
            this.death=new HashSet<>();
        }

        public void birth(String parentName, String childName) {
            map.putIfAbsent(parentName,new ArrayList<>());
            map.get(parentName).add(childName);
        }

        public void death(String name) {
            this.death.add(name);
        }

        public List<String> getInheritanceOrder() {
            List<String> result=new ArrayList<>();
            dfs(result,king);
            return result;
        }

        private void dfs(List<String> list,String cur){
            if(!death.contains(cur))
                list.add(cur);
            for(String next:map.getOrDefault(cur,new ArrayList<>()))
                dfs(list,next);
        }
    }
}
