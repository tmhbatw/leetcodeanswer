package leetcode.leetcode24;

public class Leetcode2375 {

    public String smallestNumber(String pattern) {
        int start=1;
        String result="";
        for(int i=0;i<pattern.length();i++){
            int count=1;
            char cur=pattern.charAt(i);
            while(i<pattern.length()-1&&pattern.charAt(i+1)==cur){
                count ++;
                i++;
            }
            if(cur=='I'){
                count --;
                if(count==i) {
                    count++;
                }
                if(i==pattern.length()-1){
                    count++;
                }
                for (int j = 0; j < count; j++) {
                    result += (start++);
                }
            }
            else {
                for (int j=start+count;j>=start;j--)
                    result+=j;
                start = start+count+1;
            }
        }
        return result;
    }
}
