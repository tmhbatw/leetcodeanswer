package leetcode.leetcode25;

public class Leetcode2490 {

    public boolean isCircularSentence(String sentence) {
        String[] list=sentence.split(" ");
        for(int i=0;i<list.length;i++){
            int next=i==list.length-1?0:i+1;
            if(list[next].charAt(0)!=list[i].charAt(list[i].length()-1))
                return false;
        }

        return true;
    }

}
