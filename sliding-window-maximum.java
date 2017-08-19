/*
题目：
Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.
For example,
Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
Therefore, return the max sliding window as [3,3,5,5,6,7].
Note: 
You may assume k is always valid, ie: 1 ≤ k ≤ input array's size for non-empty array.
Follow up:
Could you solve it in linear time?

思路：
维护一个大小为K的max heap，依此维护一个大小为K的窗口，把新数存入heap，当heap大小到k时把堆顶数字放入结果，接着把窗口最左边的数扔掉，然后再重复放入新数的步骤。

注意：
i是从0开始的，因此当i走到k-1的位置时，堆就满了；此时窗口最左边数字对应的下标是i + 1 - k。
*/

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return nums;
        } 
        List<Integer> list = new ArrayList<>();
        PriorityQueue<Integer> heap = new PriorityQueue<>(new MyComparator());
        for (int i = 0; i < nums.length; i++) {
            if (heap.size() >= k) {
                heap.remove(nums[i - k]);
            }
            heap.offer(nums[i]);
            list.add(heap.peek());
        }
        int[] res = new int[list.size()];
        for (int j = 0; j < res.length; j++) {
            res[j] = list.get(j);
        }
        return res;
    }
}

class MyComparator implements Comparator<Integer> {
    public int compare(Integer a, Integer b) {
        return b - a;
    }
}