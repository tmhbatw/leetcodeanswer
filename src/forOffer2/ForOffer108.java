package forOffer2;

import java.util.*;

public class ForOffer108 {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int result=1;
        Map<String,Boolean> map=new HashMap<>();
        for(String cur:wordList)
            map.put(cur,true);
        map.put(beginWord,false);
        Queue<String> q=new LinkedList<>();
        q.add(beginWord);
        while(!q.isEmpty()){
            result++;
            int size=q.size();
            while(size-->0){
                String cur=q.poll();
                List<String> list=getWordList(cur,map);
                for(String curr:list){
                    if(curr.equals(endWord))
                        return result;
                    q.add(curr);
                }
            }
        }
        return 0;
    }

    private List<String> getWordList(String cur,Map<String,Boolean> map){
        List<String> res=new ArrayList<>();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<cur.length();i++){
            char curr=cur.charAt(i);
            for(int j=0;j<26;j++){
                char c=(char)(j+'a');
                String left=cur.substring(i+1);
                if(c!=curr){
                    sb.append(c);
                    if(map.getOrDefault(sb.toString()+left,false)) {
                        res.add(sb.toString() + left);
                        map.put(sb.toString()+left,false);
                    }
                    sb.deleteCharAt(i);
                }
            }
            sb.append(curr);
        }
        return res;
    }
}
