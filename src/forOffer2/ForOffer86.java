package forOffer2;

import com.sun.org.apache.bcel.internal.generic.ANEWARRAY;

import java.util.ArrayList;
import java.util.List;

public class ForOffer86 {

    List<List<String>> result=new ArrayList<>();
    boolean[][] ss;
    public String[][] partition(String s) {
        ss=getBool(s);
        dfs(s,0, new ArrayList<>());
        String[][] res=new String[result.size()][];
        for(int i=0;i<res.length;i++) {
            res[i] = result.get(i).toArray(new String[0]);
        }
        return res;
    }

    private void dfs(String s,int i,List<String> list){
        if(i==s.length()){
            result.add(list);
            return ;
        }
        for(int j=i;j<s.length();j++){
            if(ss[i][j]){
                List<String> newList=new ArrayList<>(list);
                newList.add(s.substring(i,j+1));
                dfs(s,j+1,newList);
            }
        }
    }

    private boolean[][] getBool(String s){
        int length=s.length();
        boolean[][] res=new boolean[length][length];
        for(int i=0;i<s.length();i++){
            res[i][i]=true;
            if(i>=1&&s.charAt(i-1)==s.charAt(i))
                res[i-1][i]=true;
        }
        for(int l=2;l<length;l++){
            for(int i=0;i<length-l;i++){
                if(s.charAt(i)==s.charAt(i+l)&&res[i+1][i+l-1])
                    res[i][i+l]=true;
            }
        }
        return res;
    }
}
