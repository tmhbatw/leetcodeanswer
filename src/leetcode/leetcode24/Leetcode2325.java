package leetcode.leetcode24;

import java.util.HashSet;
import java.util.Set;

public class Leetcode2325 {

    public String decodeMessage(String key, String message) {
        char[] dic=new char[26];
        int index= 0;
        Set<Character> set=new HashSet<>();

        for(int i=0;i<key.length();i++){
            if(key.charAt(i)!=' '&&!set.contains(key.charAt(i))) {
                dic[key.charAt(i)-'a'] = (char)(index+'a');
                index++;
                set.add(key.charAt(i));
            }
        }

        String result = "";
        for(int i=0;i<message.length();i++){
            if(message.charAt(i)==' ')
                result += ' ';
            else
                result += dic[message.charAt(i)-'a'];
        }

        return result;
    }


}
