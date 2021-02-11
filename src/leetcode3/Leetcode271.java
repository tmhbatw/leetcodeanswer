package leetcode3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leetcode271 {
    /*Description
    * 请你设计一个算法，可以将一个 字符串列表 编码成为一个 字符串。这个编码后的字符串是可以通过网络进行高效传送的，
    * 并且可以在接收端被解码回原来的字符串列表。
    * */

    public class Codec {

        // Encodes a list of strings to a single string.
        public String encode(List<String> strs) {
            if(strs==null||strs.size()==0)
                return Character.toString((char)258);
            StringBuilder sb=new StringBuilder();
            for(String cur:strs){
                sb.append(Character.toString((char)257)).append(" ").append(cur);
            }
            return sb.substring(1);
        }

        // Decodes a single string to a list of strings.
        public List<String> decode(String s) {
            if(s.equals(Character.toString((char)258)))
                return Collections.emptyList();
            String[] res=s.split(Character.toString((char)257));
            List<String> result=new ArrayList<>();
            for(String cur:res){
                result.add(cur.substring(1));
            }
            return result;
        }
    }

}
