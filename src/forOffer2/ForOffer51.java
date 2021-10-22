package forOffer2;

import datastructure.TreeNode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class ForOffer51 {

    public int maxPathSum(TreeNode root) {
        Stack<TreeNode> s=new Stack<>();
        Map<TreeNode, Integer> map=new HashMap<>();
        map.put(null,0);

        int result=0;
        s.add(root);
        while(!s.isEmpty()){
            TreeNode cur=s.pop();
            if(!map.containsKey(cur.left)||!map.containsKey(cur.right)){
                s.add(cur);
                if(cur.left!=null)
                    s.add(cur.left);
                if(cur.right!=null)
                    s.add(cur.right);
                continue;
            }
            int left=map.get(cur.left);
            int right=map.get(cur.right);
            result=Math.max(left+right+cur.val,result);
            map.put(cur,Math.max(left,right)+cur.val);
        }
        return result;
    }


}
