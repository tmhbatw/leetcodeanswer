package leetcode.leetcode25;

public class Leetcode2446 {

    public boolean haveConflict(String[] event1, String[] event2) {
        return big(event1[0],event2[1])||big(event2[0],event1[1]);
    }

    private boolean big(String e1,String e2){
        return e1.compareTo(e2)>=0;
    }
}
