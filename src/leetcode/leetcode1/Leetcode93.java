package leetcode.leetcode1;

import java.util.ArrayList;
import java.util.List;

public class Leetcode93 {
    /*Description
    * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
    * 有效的 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
    * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效的 IP 地址，
    * 但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效的 IP 地址。
    * */

    public List<String> restoreIpAddresses(String s) {
        char[] c=s.toCharArray();
        List<String> result=new ArrayList<>();
        recursion(result,c,0,0,new StringBuilder());
        return result;
    }

    private void recursion(List<String> result,char[] c,int number,int index,StringBuilder sb){
        if(index>=c.length)
            return;
        if(number==3){
            if(index==c.length-1&&c[index]=='0'){
                sb.append(0);
                result.add(sb.toString());
            }else if(c[index]!='0'){
                int cur=c[index]-'0';
                for(int i=index+1;i<c.length;i++){
                    cur=cur*10+c[i]-'0';
                    if(cur>255)
                        return;
                }
                sb.append(cur);
                result.add(sb.toString());
            }else
                return;
        }
        if(c[index]=='0'){
            StringBuilder curSb=new StringBuilder(sb);
            curSb.append(0).append('.');
            recursion(result,c,number+1,index+1,curSb);
        }else{
            int cur=0;
            for(int i=index;i<index+3;i++){
                if(i<c.length){
                    cur=cur*10+c[i]-'0';
                    if(cur>255)
                        break;
                    StringBuilder curSb=new StringBuilder(sb);
                    curSb.append(cur).append('.');
                    recursion(result,c,number+1,i+1,curSb);
                }
            }
        }
    }

    public static void main(String[] args){
        List<String> res=new Leetcode93().restoreIpAddresses("010010");
        System.out.println(res);
    }


}
