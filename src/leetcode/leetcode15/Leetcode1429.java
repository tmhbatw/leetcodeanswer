package leetcode.leetcode15;

import apple.laf.JRSUIUtils;

import java.util.*;

public class Leetcode1429 {

    class FirstUnique {

        LinkedHashSet<Integer> set= new LinkedHashSet<>();
        Set<Integer> remove=new HashSet<>();
        public FirstUnique(int[] nums) {
            for(int num:nums)
                add(num);
        }

        public int showFirstUnique() {
            if(set.isEmpty())
                return -1;
            System.out.println(set);
            Iterator<Integer> i=set.iterator();
            return i.next();
        }

        public void add(int value) {
            if(remove.contains(value))
                return;
            if(set.contains(value)) {
                remove.add(value);
                set.remove(value);
                return;
            }
            set.add(value);
        }
    }
}
