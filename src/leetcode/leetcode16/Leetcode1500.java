package leetcode.leetcode16;

import java.util.*;

public class Leetcode1500 {

    class FileSharing {

        List<Set<Integer>> list=new ArrayList<>();
        PriorityQueue<Integer> q=new PriorityQueue<>();
        Map<Integer,List<Integer>> map=new HashMap<>();
        int index=1;
        public FileSharing(int m) {
            for(int i=0;i<=m;i++)
                list.add(new HashSet<>());
        }

        public int join(List<Integer> ownedChunks) {
            int cur= q.isEmpty()?index++:q.poll();
            map.put(cur,ownedChunks);

            for(int mm:ownedChunks)
                list.get(mm).add(cur);
            return cur;
        }

        public void leave(int userID) {
            q.add(userID);
            List<Integer> m=map.get(userID);
            for(int mm:m)
                list.get(mm).remove(userID);
        }

        public List<Integer> request(int userID, int chunkID) {
            if(list.get(chunkID).size()==0)
                return new ArrayList<>();
            map.get(userID).add(chunkID);
            List<Integer> result=new ArrayList<>(list.get(chunkID));

            list.get(chunkID).add(userID);

            Collections.sort(result);
            return result;
        }
    }


}
