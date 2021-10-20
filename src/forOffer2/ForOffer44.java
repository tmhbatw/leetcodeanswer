package forOffer2;

import datastructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ForOffer44 {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int size=q.size();
            int res=Integer.MIN_VALUE;
            for(int i=0;i<size;i++){
                TreeNode cur=q.poll();
                res=Math.max(cur.val,res);
                if(cur.left!=null)
                    q.add(cur.left);
                if(cur.right!=null)
                    q.add(cur.right);
            }
            result.add(res);
        }

        return result;
    }
}
