package leetcode.leetcode16;

public class Leetcode1592 {

    public String reorderSpaces(String text) {
        String[] s=text.split(" ");
        int length=0;
        int time=0;
        for(String cur:s){
            length+=cur.length();
            if(cur.length()>0)
                time++;
        }
        if(time==1){
            for(String cur:s){
                if(cur.length()>0)
                    return cur+getSpaceString(text.length()-cur.length());
            }
        }
        int spaceTime=text.length()-length;
        int space=spaceTime/(time-1);
        StringBuilder sb=new StringBuilder();
        for(String cur:s){
            if(cur.length()>0){
                sb.append(getSpaceString(space)).append(cur);
            }
        }
        sb.append(getSpaceString(spaceTime-space*(time-1)));
        return sb.substring(space);
    }

    private String getSpaceString(int cur){
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<cur;i++)
            sb.append(" ");
        return sb.toString();
    }
}
