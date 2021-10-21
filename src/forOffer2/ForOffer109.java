package forOffer2;

import sun.awt.image.ImageWatched;

import java.util.*;

public class ForOffer109 {

    public int openLock(String[] deadends, String target) {
        Set<String> set=new HashSet<>(Arrays.asList(deadends));
        if(set.contains("0000"))
            return -1;
        if(target.equals("0000"))
            return 0;
        Queue<String> q=new LinkedList<>();
        q.add("0000");
        Set<String> reached=new HashSet<>();
        reached.add("0000");
        int result=0;
        while(!q.isEmpty()){
            result++;
            int size=q.size();
            for(int i=0;i<size;i++){
                String cur=q.poll();
                for(String next:getNext(cur)){
                    if(next.equals(target))
                        return result;
                    if(set.contains(next)||reached.contains(next))
                        continue;
                    reached.add(next);
                    q.add(next);
                }
            }
        }
        return -1;
    }

    private String[] getNext(String s){
        String[] res=new String[8];
        int index=0;
        for(int i=0;i<s.length();i++){
            for(char next:getChar(s.charAt(i)))
                res[index++]=s.substring(0,i)+next+s.substring(i+1);
        }
        return res;
    }

    private char[] getChar(char c){
        char big=c=='9'?'0':(char)(c+1);
        char small=c=='0'?'9':(char)(c-1);
        return new char[]{big,small};
    }


}
