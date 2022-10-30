package leetcode.leetcode25;

import java.util.Stack;

public class Leetcode2434 {

    public String robotWithString(String s) {
        char[] c = s.toCharArray();
        int[] lastAppearTime = new int[26];
        for (int i = 0; i < s.length(); i++)
            lastAppearTime[c[i] - 'a'] = i;

        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        int j = 0;
        for (char i = 'a'; i <= 'z'; i++) {
            int last = lastAppearTime[i - 'a'];
            while (!stack.isEmpty() && stack.peek() <= i) {
                sb.append(stack.pop());
            }
            while (j <= last) {
                if (c[j] == i) {
                    sb.append(c[j]);
                } else {
                    stack.add(c[j]);
                }
                j++;
            }
            //System.out.println(stack+" "+sb);
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.toString();
    }

}
