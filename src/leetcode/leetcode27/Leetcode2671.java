package leetcode.leetcode27;

import java.util.HashMap;
import java.util.Map;

public class Leetcode2671 {

    class FrequencyTracker {
        int[] numFrequencyMap,frequencyNumMap;
        public FrequencyTracker() {
            numFrequencyMap = new int[100001];
            frequencyNumMap = new int[100001];
        }

        public void add(int number) {
            frequencyNumMap[numFrequencyMap[number]]--;
            numFrequencyMap[number]++;
            frequencyNumMap[numFrequencyMap[number]]++;
        }

        public void deleteOne(int number) {
            if (numFrequencyMap[number] > 0) {
                frequencyNumMap[numFrequencyMap[number]]--;
                numFrequencyMap[number]--;
                frequencyNumMap[numFrequencyMap[number]]++;
            }
        }

        public boolean hasFrequency(int frequency) {
            return frequencyNumMap[frequency] > 0;
        }
    }

}
