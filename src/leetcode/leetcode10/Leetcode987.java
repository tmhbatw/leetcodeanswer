package leetcode.leetcode10;

import datastructure.TreeNode;

import java.util.*;

public class Leetcode987 {

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Queue<TreeNode> q1=new LinkedList<>();
        Queue<Integer> q2=new LinkedList<>();
        q1.add(root);
        q2.add(0);
        TreeMap<Integer,List<Integer>> map=new TreeMap<>();
        while(!q1.isEmpty()){
            int size=q1.size();
            TreeMap<Integer,List<Integer>> curMap=new TreeMap<>();
            while(size-->0) {
                TreeNode node = q1.poll();
                int val = q2.poll();
                curMap.putIfAbsent(val, new ArrayList<>());
                curMap.get(val).add(node.val);
                addNode(q1, q2, node, val);
            }
            for(int key:curMap.keySet()){
                map.putIfAbsent(key,new ArrayList<>());
                Collections.sort(curMap.get(key));
                map.get(key).addAll(curMap.get(key));
            }
        }
        List<List<Integer>> list=new ArrayList<>();
        for(int key:map.keySet()){
            list.add(map.get(key));
        }
        return list;
    }

    public static void addNode(Queue<TreeNode> q1, Queue<Integer> q2, TreeNode node, int val) {
        if(node.left!=null){
            q1.add(node.left);
            q2.add(val-1);
        }
        if(node.right!=null){
            q1.add(node.right);
            q2.add(val+1);
        }
    }
}
