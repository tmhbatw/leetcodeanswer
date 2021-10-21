package forOffer2;

import java.util.ArrayList;
import java.util.List;

public class ForOffer87 {

    List<String> result=new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        dfs(0,new StringBuilder(),s,0);
        return result;
    }

    private void dfs(int index,StringBuilder sb,String s,int time){
        if(index==s.length()&&time==4){
            result.add(sb.substring(1));
        }
        if(index==s.length()||time==4){
            return;
        }
        if(s.charAt(index)=='0'){
            sb.append(".").append("0");
            dfs(index+1,sb,s,time+1);
        }else{
            for(int i=index+1;i<=Math.min(s.length(),index+3);i++){
                int cur=Integer.parseInt(s.substring(index,i));
                if(cur<=255){
                    StringBuilder curSb=new StringBuilder(sb);
                    curSb.append(".").append(cur);
                    dfs(i,curSb,s,time+1);
                }
            }
        }
    }
}
