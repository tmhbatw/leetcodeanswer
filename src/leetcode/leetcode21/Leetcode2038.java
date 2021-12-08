package leetcode.leetcode21;

public class Leetcode2038 {

    public boolean winnerOfGame(String colors) {
        int timeA=0;
        int timeB=0;
        for(int i=0;i<colors.length();i++){
            char cur=colors.charAt(i);
            int start=i;
            while(i<colors.length()-1&&colors.charAt(i+1)==cur)
                i++;
            start=Math.max(0,i-start-1);
            if(cur=='A')
                timeA+=start;
            else
                timeB+=start;
        }
        System.out.println(timeA+" "+timeB);
        return timeA>timeB;
    }
}
