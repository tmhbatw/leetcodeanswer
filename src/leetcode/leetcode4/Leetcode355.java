package leetcode.leetcode4;

import java.util.*;

public class Leetcode355 {
    /*Description
    * 设计一个简化版的推特(Twitter)，可以让用户实现发送推文，关注/取消关注其他用户，
    * 能够看见关注人（包括自己）的最近十条推文。你的设计需要支持以下的几个功能：
    * postTweet(userId, tweetId): 创建一条新的推文
    * getNewsFeed(userId): 检索最近的十条推文。每个推文都必须是由此用户关注的人或者是用户自己发出的。
    * 推文必须按照时间顺序由最近的开始排序。
    * follow(followerId, followeeId): 关注一个用户
    * unfollow(followerId, followeeId): 取消关注一个用户
    * */

    class Twitter {
        Map<Integer, Set<Integer>> map1;//用来存储用户ID与推特ID之间的关系
        Map<Integer,Set<Integer>> map2;//用来存储用户ID与他所关注的用户ID之间的关系
        Map<Integer,Integer> map3;//用来存储时间ID与推特ID之间的关系
        int time;

        /** Initialize your data structure here. */
        public Twitter() {
            map1=new HashMap<>();
            map2=new HashMap<>();
            map3=new HashMap<>();
            time=0;
        }

        /** Compose a new tweet. */
        public void postTweet(int userId, int tweetId) {
            Set<Integer> set=map1.getOrDefault(userId,new HashSet<>());
            set.add(time);
            map3.put(time++,tweetId);
            map1.put(userId,set);
        }

        /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
        public List<Integer> getNewsFeed(int userId) {
            List<Integer> set=new ArrayList<>(map1.getOrDefault(userId,new HashSet<>()));
            Set<Integer> followeeId=map2.getOrDefault(userId,new HashSet<>());
            for(int cur:followeeId) {
                if(cur==userId)
                    continue;
                set.addAll(map1.getOrDefault(cur, new HashSet<>()));
            }
            Collections.sort(set);
            List<Integer> result=new ArrayList<>();
            for(int i=set.size()-1;i>=Math.max(0,set.size()-10);i--){
                result.add(map3.get(set.get(i)));
            }
            return result;
        }

        /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
        public void follow(int followerId, int followeeId) {
            Set<Integer> set=map2.getOrDefault(followerId,new HashSet<>());
            set.add(followeeId);
            map2.put(followerId,set);
        }

        /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
        public void unfollow(int followerId, int followeeId) {
            Set<Integer> set=map2.getOrDefault(followerId,new HashSet<>());
            set.remove(followeeId);
            map2.put(followerId,set);
        }
    }
}
