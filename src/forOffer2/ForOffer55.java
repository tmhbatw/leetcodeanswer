package forOffer2;

import datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class ForOffer55 {

    class BSTIterator {

        List<TreeNode> list=new ArrayList<>();
        int index=0;
        public BSTIterator(TreeNode root) {
            dfs(root);
        }

        private void dfs(TreeNode root){
            if(root==null)
                return;
            dfs(root.left);
            list.add(root);
            dfs(root.right);
        }

        public int next() {
            return list.get(index++).val;
        }

        public boolean hasNext() {
            return index<list.size();
        }
    }
}
