package leetcode.leetcode19;

public class Leetcode1881 {

    public String maxValue(String n, int x) {
        if(n.charAt(0)!='-'){
            for(int i=0;i<n.length();i++){
                if(n.charAt(i)-'0'<x)
                    return n.substring(0,i)+x+n.substring(i);
            }
            return n+x;
        }

        for(int i=1;i<n.length();i++){
            if(n.charAt(i)-'0'>x)
                return n.substring(0,i)+x+n.substring(i);
        }
        return n+x;
    }


}
