package lcp;

import java.util.Arrays;
import java.util.LinkedList;

public class lcp72 {

    public int[] supplyWagon(int[] supplies) {
        int time = (supplies.length + 1) / 2;
        LinkedList<Integer> list = new LinkedList<>();
        for (int num : supplies) {
            list.add(num);
        }

        while (time-- > 0) {
            supplies = remove(supplies);
            System.out.println(Arrays.toString(supplies));
        }
        return supplies;
    }

    private int[] remove(int[] supplies) {
        int index = 0;
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < supplies.length - 1; i++) {
            int cur = supplies[i] + supplies[i + 1];
            if (cur < result) {
                index = i;
                result = cur;
            }
        }
        supplies[index] += supplies[index + 1];
        int[] res = new int[supplies.length - 1];
        int j = 0;
        for (int i = 0; i < supplies.length; i++) {
            if (i != index + 1) {
                res[j++] = supplies[i];
            }
        }
        return res;
    }
}
