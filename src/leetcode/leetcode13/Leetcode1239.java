package leetcode.leetcode13;

import java.util.List;

public class Leetcode1239 {

    int result=0;
    public int maxLength(List<String> arr) {
        dfs(arr,0,0,0);
        return result;
    }

    private void dfs(List<String> arr,int index,int cur,int size){
        if(index==arr.size())
            return;
        dfs(arr,index+1,cur,size);
        for(char c:arr.get(index).toCharArray()){
            if((cur&(1<<(c-'a')))==0){
                cur|=(1<<(c-'a'));
            }else
                return;
        }
        size+=arr.get(index).length();
        result=Math.max(result,size);
        dfs(arr,index+1,cur,size);
    }
}
