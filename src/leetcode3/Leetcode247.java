package leetcode3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Leetcode247 {
    /*Description
    * 中心对称数是指一个数字在旋转了 180 度之后看起来依旧相同的数字（或者上下颠倒地看）。
    * 找到所有长度为 n 的中心对称数。
    * */

    public List<String> findStrobogrammatic(int n) {
        List<String> list;
        if(n%2==0)
            list= Arrays.asList("11","69","88","96","00");
        else
            list=Arrays.asList("0","1","8");

        for(int i=2;i<n;i+=2){
            List<String> cur=new ArrayList<>();
            for(String curr:list){
                cur.add('1'+curr+'1');
                cur.add('6'+curr+'9');
                cur.add('8'+curr+'8');
                cur.add('9'+curr+'6');
                cur.add('0'+curr+'0');
            }
            list=cur;
        }
        if(n>1)
            list=remove(list);
        Collections.sort(list);
        return list;
    }

    private List<String> remove(List<String> list){
        ArrayList<String> result=new ArrayList<>();
        for(String cur:list)
            if(cur.charAt(0)!='0')
                result.add(cur);
            return result;
    }
}
