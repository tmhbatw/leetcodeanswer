package leetcode.leetcode8;

import java.util.ArrayList;
import java.util.List;

public class Leetcode751 {
    /*Description
    * 给定一个起始 IP 地址 ip 和一个我们需要包含的 IP 的数量
    *  n，返回用列表（最小可能的长度）表示的 CIDR块的范围。 
    * CIDR 块是包含 IP 的字符串，后接斜杠和固定长度。例如：“123.45.67.89/20”。
    * 固定长度 “20” 表示在特定的范围中公共前缀位的长度。
    * */

    public List<String> ipToCIDR(String ip, int n) {
        List<String> result=new ArrayList<>();
        String[] ipp=ip.split("\\.");
        int last=Integer.parseInt(ipp[3]);
        while(n>0){
            int count=1;
            int index=0;
            while(n>=count*2&&((last>>index)&1)==0){
                count*=2;
                index++;
            }
            n-=count;
            result.add(ipp[0]+"."+ipp[1]+"."+ipp[2]+"."+last+"/"+(32-index));
            for(index=31;index>=0;index--){
                if(((last>>index)&1)==1){
                    break;
                }
            }
            last=1<<(32-index);
        }
        return result;
    }
}
