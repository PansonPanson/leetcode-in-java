package top.panson.injava.question.practice.tree;

import top.panson.injava.question.commondata.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 二叉树的中序遍历
 * @create 2022-01-25 19:32
 * @Author: Panson
 */
public class L094 {

    public class Solution1 {
        /**
         * 递归
         *
         * @param root
         * @return
         */
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            if (root == null) {
                return res;
            }
            inorder(res, root);
            return res;
        }

        private void inorder(List<Integer> res, TreeNode root) {
            if (root == null) {
                return;
            }
            inorder(res, root.left);
            res.add(root.val);
            inorder(res, root.right);
        }
    }


//    /**
//     * 迭代
//     */
//    public class Solution2 {
//        public List<Integer> inorderTraversal(TreeNode root) {
//            List<Integer> res = new ArrayList<>();
//            if(root == null)
//            Deque<Integer>
//        }
//    }
}
