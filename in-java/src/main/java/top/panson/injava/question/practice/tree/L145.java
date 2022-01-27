package top.panson.injava.question.practice.tree;

import top.panson.injava.question.commondata.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @create 2022-01-27 16:42
 * @Author: Panson
 */
public class L145 {
    public class Solution1 {
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            if (root == null) {
                return res;
            }
            postOrder(res, root);
            return res;
        }

        private void postOrder(List<Integer> res, TreeNode root) {
            if (root == null) {
                return;
            }
            postOrder(res, root.left);
            postOrder(res, root.right);
            res.add(root.val);
        }
    }

    public class Solution {
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            if (root == null) {
                return res;
            }
            Deque<Object> stack = new LinkedList<>();
            stack.push(root);
            while(!stack.isEmpty()) {
                Object pop = stack.pop();
                if(pop instanceof Integer) {
                    res.add((Integer) pop);
                } else {
                    TreeNode node = (TreeNode) pop;
                    stack.push(node.val);
                    if(node.right != null) {
                        stack.push(node.right);
                    }
                    if(node.left != null) {
                        stack.push(node.left);
                    }
                }
            }
            return res;
        }
    }

}
