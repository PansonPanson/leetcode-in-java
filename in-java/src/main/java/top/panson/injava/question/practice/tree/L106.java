package top.panson.injava.question.practice.tree;

import top.panson.injava.question.commondata.TreeNode;

/**
 * @create 2022-03-20 23:11
 * @Author: Panson
 */
public class L106 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    class Solution {
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
        }
        public TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
            if(postStart > postEnd) {
                return null;
            }

            int rootVal = postorder[postEnd];
            int index  = postorder.length - 1;
            for(int i = inStart; i <= inEnd; i++) {
                if(inorder[i] == rootVal) {
                    index = i;
                    break;
                }
            }

            TreeNode root = new TreeNode(rootVal);
            int leftSize = index - inStart;
            root.left = buildTree(inorder, inStart, index - 1, postorder, postStart, postStart + leftSize - 1);
            root.right = buildTree(inorder, inStart + leftSize + 1, inEnd, postorder, postStart + leftSize, postEnd - 1);
            return root;
        }
    }
}
