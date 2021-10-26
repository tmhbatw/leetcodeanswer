package leetcode.leetcode5;

public class Leetcode470 {

    public int rand7(){
        return (int) (Math.random()*7)+1;
    }

    public int rand10() {
        int count=0;
        for(int i=0;i<10;i++)
            count+=rand7();
        return count%10+1;
    }
}
