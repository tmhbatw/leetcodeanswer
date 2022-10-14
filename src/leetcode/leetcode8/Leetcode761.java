package leetcode.leetcode8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leetcode761 {

    public String makeLargestSpecial(String s) {
        if (s.length() <= 2)
            return s;

        List<String> list = new ArrayList<>();
        int count = 0;
        int pre = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1')
                count++;
            else
                count--;
            if (count == 0) {
                list.add("1" + makeLargestSpecial(s.substring(pre + 1, i)) + "0");
                pre = i + 1;
            }
        }

        Collections.sort(list);
        StringBuilder result = new StringBuilder();
        for (int j = list.size() - 1; j >= 0; j--)
            result.append(list.get(j));

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println("hello world!");
    }
}
