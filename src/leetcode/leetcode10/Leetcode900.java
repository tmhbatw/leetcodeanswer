package leetcode.leetcode10;

public class Leetcode900 {
    class RLEIterator {

        int[] encoding;
        int index;
        public RLEIterator(int[] encoding) {
            this.encoding=encoding;
            this.index=0;
        }

        public int next(int n) {
            while(index<encoding.length&&encoding[index]<n) {
                n-=encoding[index];
                index += 2;
            }
            if(index>=encoding.length)
                return -1;
            encoding[index]-=n;
            return encoding[index+1];
        }
    }
}
