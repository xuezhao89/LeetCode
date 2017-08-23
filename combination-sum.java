/*
题目：
Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
The same repeated number may be chosen from C unlimited number of times.
Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [2, 3, 6, 7] and target 7, 
A solution set is: 
[
  [7],
  [2, 2, 3]
]

思路：
如果当前和已经大于目标，说明该路径错误；如果当前和等于目标，说明找到一条正确路径，保存到结果里；如果小于目标，则对剩余所有可能性进行DFS：包括当前被选数字在内之后的每个数字都是一种可能性，先加入元素，再进行搜索，递归回来再移出元素。

注意：
先对数组进行排序，避免重复搜索。
*/

class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        Arrays.sort(candidates);
        List<Integer> tmp = new ArrayList<>();
        helper(candidates, 0, target, tmp);
        return res;
    }
    
    private void helper(int[] nums, int idx, int target, List<Integer> tmp) {
        if (target == 0) {
            res.add(new ArrayList<Integer>(tmp));
        } else if (target < 0) {
            return;
        } else {
            for (int i = idx; i < nums.length; i++) {
                tmp.add(nums[i]);
                helper(nums, i, target - nums[i], tmp);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}
