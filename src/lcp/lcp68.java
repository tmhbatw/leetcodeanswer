package lcp;

import java.util.HashMap;
import java.util.Map;

public class lcp68 {

    public int beautifulBouquet(int[] flowers, int cnt) {
        Map<Integer, Integer> map = new HashMap<>();
        long result = 0;
        int mod = 1000000007;
        int j = 0;

        for (int i = 0; i < flowers.length; i++) {
            while (j < flowers.length && map.getOrDefault(flowers[j], 0) < cnt) {
                map.put(flowers[j], map.getOrDefault(flowers[j++], 0) + 1);
            }

            long cur = j - i;
            result += cur;
            map.put(flowers[i], map.get(flowers[i]) - 1);
            //System.out.println(i+" "+j+" "+map);
        }
        return (int) (result % mod);
    }

    public static void main(String[] args) {
        System.out.println("hello world!");
    }

}
