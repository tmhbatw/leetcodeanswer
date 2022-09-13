package leetcode.leetcode19;

public class Leetcode1898 {

    public int maximumRemovals(String s, String p, int[] removable) {
        int l=0,r=removable.length;
        while(l<r){
            int mid = (l+r+1)/2;
            if(match(s,p,removable,mid)){
                l=mid;
            }else{
                r=mid-1;
            }
        }
        return l;
    }

    private boolean match(String s,String p,int[] remove,int mid){
        boolean[] move=new boolean[s.length()];
        for(int i=0;i<mid;i++)
            move[remove[i]]=true;

        int j=0;
        for(int i=0;i<s.length();i++){
            if(move[i])
                continue;
            if(s.charAt(i)==p.charAt(j)){
                j++;
                if(j==p.length())
                    return true;
            }
        }
        return false;
    }


}
