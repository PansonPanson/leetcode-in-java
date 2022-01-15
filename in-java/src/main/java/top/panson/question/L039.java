package top.panson.question;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @create 2022-01-15 21:55
 * @Author: Panson
 */
public class L039 {
    public static void main(String[] args) {
        int[] candidates = new int[]{2,3,6,7};
        System.out.println(combinationSum(candidates, 7));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        //定义一个返回结果的集合
        List<List<Integer>> res =new ArrayList<>();
        //定义一个存储树路径上的节点值
        Deque<Integer> path = new ArrayDeque<>();
        //定义一个表示数组的长度的变量
        int len = candidates.length;
        //深度搜索
        dfs(candidates,0, target, path,res);
        //返回结果
        return res;
    }
    public static void dfs(int[] candidates, int begin,int target, Deque<Integer> path, List<List<Integer>> res ){
        //如果此时目标元素经过几次深度递归，减值，
        //就说明，数组中不存在能相加等于目标数组的元素集合
        if(target < 0){
            return;
        }
        //如果刚好减到0，说明此时路径上的元素，相加等于目标元素。
        //此时路径上的元素就符合条件，将他们加入返回结果中，并退出此次递归
        if(target == 0){
            res.add(new ArrayList<>(path));
            return;
        }
        //遍历元素，这里的i 必须要跟递归层数保持一致，要不然剪枝时，会照成重复元素
        for(int i = begin; i<candidates.length; i++){
            //将路径上的元素加入结果集合中
            path.add(candidates[i]);
            //在进行一轮剪枝到根节点的时候，下一轮的搜索的启点就不能包括上一次搜索的下标了
            //此时在拼接重复元素的时候，起点只能是大于等于当前元素的下标。
            dfs(candidates, i, target-candidates[i],path,res);
            //将元素进行删除，也叫剪枝，
            //这里必须从队列的尾部开始删除，这样才能达到从底层逐层删除
            path.removeLast();
        }
    }
}
