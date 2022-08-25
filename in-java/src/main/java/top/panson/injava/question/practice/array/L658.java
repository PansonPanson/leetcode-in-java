package top.panson.injava.question.practice.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @create 2022-08-25 10:54
 * @Author: Panson
 */
public class L658 {
    class Solution {
        public List<Integer> findClosestElements(int[] arr, int k, int x) {
            int left = 0;
            int right = arr.length - 1;
            while(right - left != k -1) {
                if(x - arr[left] > arr[right] - x) {
                    left++;
                } else {
                    right--;
                }
            }
            List<Integer> res = new ArrayList<>();
            for(int i = left; i <= right; i++) {
                res.add(arr[i]);
            }
            return res;
        }
    }
}
