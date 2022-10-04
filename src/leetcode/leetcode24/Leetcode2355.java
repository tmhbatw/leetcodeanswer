package leetcode.leetcode24;

import java.util.Stack;

public class Leetcode2355 {

    public long maximumBooks(int[] books) {
        long result = 0;
        long[] dp = new long[books.length + 1];
        Stack<Integer> s = new Stack<>();
        s.add(0);

        int[] book = new int[books.length + 1];
        System.arraycopy(books, 0, book, 1, books.length);
        //books[j]-books[i]>j-i
        //books[j]-j>=books[i]-i时说明到i就不行了
        for (int i = 1; i < book.length; i++) {
            while (book[s.peek()] - s.peek() > book[i] - i) {
                s.pop();
            }
            dp[i] = dp[s.peek()] + getRes(book[i], i - s.peek());
            result = Math.max(dp[i], result);
            s.add(i);
        }

        return result;
    }

    private long getRes(int book, int time) {
        long first = book - time + 1;
        if (first < 0) {
            return (long) (book + 1) * book / 2;
        }
        return (first + book) * time / 2;
    }

}
