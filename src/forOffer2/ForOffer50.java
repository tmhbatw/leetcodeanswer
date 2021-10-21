package forOffer2;

import datastructure.TreeNode;

import java.util.*;

public class ForOffer50 {


    public int pathSum(TreeNode root, int targetSum) {
        if(root==null)
            return 0;

        int result=0;
        if(root.val==targetSum)
            result++;

        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        Queue<List<Integer>> list=new LinkedList<>();
        List<Integer> rootList=new ArrayList<>();
        rootList.add(root.val);
        rootList.add(0);
        list.add(rootList);

        while(!q.isEmpty()){
            TreeNode cur=q.poll();
            List<Integer> curList=list.poll();

            if(cur.left!=null){
                List<Integer> currList=new ArrayList<>(curList);
                for(int i=0;i<currList.size();i++){
                    currList.set(i,currList.get(i)+cur.left.val);
                    if(currList.get(i)==targetSum)
                        result++;
                }
                currList.add(0);
                q.add(cur.left);
                list.add(currList);
            }

            if(cur.right!=null){
                List<Integer> currList=new ArrayList<>(curList);
                for(int i=0;i<currList.size();i++){
                    currList.set(i,currList.get(i)+cur.right.val);
                    if(currList.get(i)==targetSum)
                        result++;
                }
                currList.add(0);
                q.add(cur.right);
                list.add(currList);
            }
        }

        return result;
    }

}
