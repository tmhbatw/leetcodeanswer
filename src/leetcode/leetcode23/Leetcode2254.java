package leetcode.leetcode23;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Leetcode2254 {

    class VideoSharingPlatform {

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        Map<Integer, String> map = new HashMap<>();
        Map<Integer, Integer> view = new HashMap<>();
        Map<Integer, Integer> like = new HashMap<>();
        Map<Integer, Integer> dislike = new HashMap<>();
        int index;

        public VideoSharingPlatform() {
            this.index = 0;
        }

        public int upload(String video) {
            int cur = index;
            if (!queue.isEmpty()) {
                cur = queue.poll();
            } else
                index++;
            map.put(cur, video);
            view.put(cur, 0);
            like.put(cur, 0);
            dislike.put(cur, 0);
            return cur;
        }

        public void remove(int videoId) {
            map.remove(videoId);
            view.remove(videoId);
            like.remove(videoId);
            dislike.remove(videoId);
            if (index > videoId)
                queue.add(videoId);
        }

        public String watch(int videoId, int startMinute, int endMinute) {
            if (!map.containsKey(videoId))
                return "-1";
            view.put(videoId, view.get(videoId) + 1);
            return map.get(videoId).substring(startMinute, Math.min(map.get(videoId).length(),
                    endMinute + 1));
        }

        public void like(int videoId) {
            if (like.containsKey(videoId))
                like.put(videoId, like.get(videoId) + 1);
        }

        public void dislike(int videoId) {
            if (dislike.containsKey(videoId)) {
                dislike.put(videoId, dislike.get(videoId) + 1);
            }
        }

        public int[] getLikesAndDislikes(int videoId) {
            if (like.containsKey(videoId))
                return new int[]{-1};
            int[] result = new int[2];
            result[0] = like.get(videoId);
            result[1] = dislike.get(videoId);
            return result;
        }

        public int getViews(int videoId) {
            return view.getOrDefault(videoId, -1);
        }
    }


}
