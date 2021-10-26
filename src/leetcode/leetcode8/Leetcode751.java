package leetcode.leetcode8;

import java.util.ArrayList;
import java.util.List;

public class Leetcode751 {
    /*Description
    * 给定一个起始 IP 地址和一个我们需要包含的 IP 的数量n，
    * 返回用列表（最小可能的长度）表示的 CIDR块的范围。
    * CIDR 块是包含 IP 的字符串，后接斜杠和固定长度。例如：“123.45.67.89/20”。
    * 固定长度 “20” 表示在特定的范围中公共前缀位的长度。
    * */

    List<String> result=new ArrayList<>();
    public List<String> ipToCIDR(String ip, int n) {
        while(n>0){
            String str=getStr(ip);
            int base=1;
            int j=31;
            while(base*2<=n&&str.charAt(j)=='0'){
                base*=2;
                j--;
            }
            result.add(ip+"/"+(1+j));
            n-=base;
            ip=getStr(str,j);
            //在第j位加1
        }
        return result;
    }

    private String getStr(String ip, int num){
        char[] c=ip.toCharArray();
        for(int j=num;j>=0;j--){
            if(c[j]=='0'){
                c[j]='1';
                break;
            }else
                c[j]='0';
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<4;i++){
            int cur=0;
            int base=1;
            for(int j=i*8+7;j>=i*8;j--){
                if(c[j]=='1'){
                    cur+=base;
                }
                base*=2;
            }
            sb.append('.').append(cur);
        }
        return sb.substring(1);
    }

    //将一个ip串转化为一个01序列字符串
    private String getStr(String ip){
        String[] s=ip.split("\\.");
        StringBuilder sb=new StringBuilder();
        for(String cur:s){
            String curr=Integer.toBinaryString(Integer.parseInt(cur));
            for(int i=0;i<8-curr.length();i++)
                sb.append("0");
            sb.append(curr);
        }
        return sb.toString();
    }

    public static void main(String[] args){
        String text="255.0.0.7";
        System.out.println(new Leetcode751().getStr(text));
    }


}
