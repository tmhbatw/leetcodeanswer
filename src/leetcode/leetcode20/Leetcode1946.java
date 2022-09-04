package leetcode.leetcode20;

import java.util.HashMap;
import java.util.Map;

public class Leetcode1946 {

    public String maximumNumber(String num, int[] change) {
        StringBuilder sb=new StringBuilder();
        Map<Integer,Integer> map=new HashMap<>();

        for(int i=0;i<num.length();i++){
            int n=num.charAt(i)-'0';
            if(change[n]>n){
                sb.append(num, 0, i);

                sb.append(change[n]);

                while(i<num.length()-1&&change[num.charAt(i+1)-'0']>=(num.charAt(i+1)-'0')){
                    sb.append(change[num.charAt(++i)-'0']);
                }
                sb.append(num.substring(i+1));

                return sb.toString();
            }
        }
        return num;
    }


}
