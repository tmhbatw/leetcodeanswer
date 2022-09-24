package leetcode.leetcode8;

import java.util.ArrayList;
import java.util.List;

public class Leetcode722 {

    public List<String> removeComments(String[] source) {
        List<String> result=new ArrayList<>();
        boolean flag=false;
        StringBuilder sb=new StringBuilder();

        for(String s:source){
            while(s.length()!=0){
                if(flag){
                    if(s.contains("*/")){
                        int index=s.indexOf("*/");
                        s=s.substring(index+2);
                        flag=false;
                    }else{
                        s="";
                    }
                }else{
                    int index1=s.indexOf("//");
                    int index2=s.indexOf("/*");
                    if(index1==-1){
                        if(index2==-1){
                            sb.append(s);
                            s="";
                        }else{
                            sb.append(s, 0, index2);
                            s=s.substring(index2+2);
                            flag=true;
                        }
                    }else{
                        if(index2==-1||index1<index2){
                            sb.append(s,0,index1);
                            s="";
                        }else{
                            sb.append(s, 0, index2);
                            s=s.substring(index2+2);
                            flag=true;
                        }
                    }
                }
            }
            if(sb.length()>0&&!flag) {
                result.add(sb.toString());
                sb=new StringBuilder();
            }
        }
        if(sb.length()>0)
            result.add(sb.toString());

        return result;
    }
}
