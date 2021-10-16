package leetcode.leetcode19;

public class Leetcode1826 {

    public int badSensor(int[] sensor1, int[] sensor2) {
        int n = 0;
        for(int i = 0; i < sensor1.length - 1; i++) {
            if(sensor1[i] != sensor2[i]) {
                n++;
            }
        }
        if (n == 0) {
            return -1;
        }

        for(int i = 0; i < sensor1.length -1; i++) {
            if (sensor1[i] != sensor2[i]) {
                int k = 0, m = 0;
                for(int j = i+1; j < sensor1.length; j++) {
                    if (sensor1[j - 1] == sensor2[j]) {
                        k++;
                    }
                    if (sensor2[j - 1] == sensor1[j]) {
                        m++;
                    }
                }
                if(k == sensor1.length - i - 1 && m == sensor1.length - i - 1) {
                    return -1;
                }

                if (k == sensor1.length - i - 1) {
                    return 1;
                } else {
                    return 2;
                }

            }
        }
        return -1;
    }

}
