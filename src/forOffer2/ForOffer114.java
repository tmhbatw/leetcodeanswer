package forOffer2;

import java.util.*;

public class ForOffer114 {

    public String alienOrder(String[] words) {
        Map<Character, List<Character>> map=new HashMap<>();
        Map<Character,Integer> val=new HashMap<>();

        for(int i=1;i<words.length;i++){
            for(int j=0;j<Math.min(words[i].length(),words[i-1].length());j++){
                if(words[i-1].charAt(j)!=words[i].charAt(j)){
                    val.put(words[i].charAt(j),val.getOrDefault(words[i].charAt(j),0)+1);
                    val.putIfAbsent(words[i-1].charAt(j),0);
                    map.putIfAbsent(words[i-1].charAt(j),new ArrayList<>());
                    map.get(words[i-1].charAt(j)).add(words[i].charAt(j));
                    break;
                }
                if(j==Math.min(words[i].length(),words[i-1].length())-1&&words[i].length()<words[i-1].length())
                    return "";
            }
        }

        Queue<Character> q=new LinkedList<>();
        for(Map.Entry<Character,Integer> entry:val.entrySet()){
            if(entry.getValue()==0)
                q.add(entry.getKey());
        }

        StringBuilder sb=new StringBuilder();
        while(!q.isEmpty()){
            char c=q.poll();
            sb.append(c);
            List<Character> next=map.getOrDefault(c,new ArrayList<>());
            for(char n:next){
                val.put(n,val.get(n)-1);
                if(val.get(n)==0)
                    q.add(n);
            }
        }

        System.out.println(sb);

        if(sb.length()!=val.size())
            return "";

        Set<Character> set=new HashSet<>();
        for(int i=0;i<sb.length();i++)
            set.add(sb.charAt(i));

        for(String word:words){
            for(int i=0;i<word.length();i++){
                if(!set.contains(word.charAt(i))){
                    set.add(word.charAt(i));
                    sb.append(word.charAt(i));
                }
            }
        }
        return sb.toString();
    }

}
