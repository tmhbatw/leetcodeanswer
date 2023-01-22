package leetcode.leetcode26;

public class Leetcode2525 {

    public String categorizeBox(int length, int width, int height, int mass) {
        String result = "";
        long volume = 1;
        volume = volume * length * width * height;
        if (volume >= 1000000000 || length >= 10000 || width >= 10000 || height >= 10000) {
            result = "Bulky";
        }

        if (mass >= 100) {
            if (result.equals("Bulky")) {
                return "Both";
            }
            result = "Heavy";
        }
        return result.equals("") ? "Neither" : result;
    }

}
