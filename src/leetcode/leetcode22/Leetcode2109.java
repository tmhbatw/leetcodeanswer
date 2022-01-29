package leetcode.leetcode22;

public class Leetcode2109 {

    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb=new StringBuilder();

        int pre=0;
        for(int space:spaces){
            sb.append(s, pre, space).append(" ");
            pre=space;
        }

        sb.append(s.substring(spaces[spaces.length-1]));

        return sb.toString();
    }
}
