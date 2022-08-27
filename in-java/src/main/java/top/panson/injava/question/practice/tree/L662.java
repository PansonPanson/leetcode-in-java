package top.panson.injava.question.practice.tree;

import javafx.util.Pair;
import top.panson.injava.question.commondata.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @create 2022-08-27 10:45
 * 二叉树最大宽度
 * @Author: Panson
 */
public class L662 {
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



        public int widthOfBinaryTree(TreeNode root) {
            if(root == null) {
                return 0;
            }
            Deque<TreeNode> deque = new ArrayDeque<>();
            deque.offer(root);
            int size = deque.size();
            int max = size;

            while(!deque.isEmpty()) {
                int left = size, right = -1;
                for(int i = 0; i < size; i++) {
                    TreeNode poll = deque.poll();
                    if(poll.val != -101) {
                        left = Math.min(left, i);
                        right = Math.max(right, i);
                    }
                    if(left == size) {
                        continue;
                    }
                    TreeNode leftNode = poll.left == null ? new TreeNode(-101) : poll.left;
                    deque.offer(leftNode);
                    TreeNode rightNode = poll.right == null ? new TreeNode(-101) : poll.right;
                    deque.offer(rightNode);
                }
                size = deque.size();
                max = Math.max(right - left + 1, max);
                if(left > right) {
                    break;
                }
            }
            return max;
        }


        /**
         * ac
         * @param root
         * @return
         */
        public int widthOfBinaryTree2(TreeNode root) {
            if(root == null) {
                return 0;
            }
            List<Pair<TreeNode, Integer>> currentLevel = new ArrayList<>();
            currentLevel.add(new Pair<>(root, 1));
            int res = 1;
            while(!currentLevel.isEmpty()) {
                List<Pair<TreeNode, Integer>> nextLevel = new ArrayList<>();
                for (Pair<TreeNode, Integer> treeNodeIntegerPair : currentLevel) {
                    if (treeNodeIntegerPair.getKey().left != null) {
                        nextLevel.add(new Pair<>(treeNodeIntegerPair.getKey().left, treeNodeIntegerPair.getValue() * 2));
                    }
                    if (treeNodeIntegerPair.getKey().right != null) {
                        nextLevel.add(new Pair<>(treeNodeIntegerPair.getKey().right, treeNodeIntegerPair.getValue() * 2 + 1));
                    }
                }
                res = Math.max(currentLevel.get(currentLevel.size() - 1).getValue() - currentLevel.get(0).getValue() + 1, res);
                currentLevel = nextLevel;
            }
            return res;
        }



    }


}
