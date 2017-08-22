/*
题目：
Design a data structure that supports all following operations in average O(1) time.
insert(val): Inserts an item val to the set if not already present.
remove(val): Removes an item val from the set if present.
getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.
Example:
// Init an empty set.
RandomizedSet randomSet = new RandomizedSet();
// Inserts 1 to the set. Returns true as 1 was inserted successfully.
randomSet.insert(1);
// Returns false as 2 does not exist in the set.
randomSet.remove(2);
// Inserts 2 to the set, returns true. Set now contains [1,2].
randomSet.insert(2);
// getRandom should return either 1 or 2 randomly.
randomSet.getRandom();
// Removes 1 from the set, returns true. Set now contains [2].
randomSet.remove(1);
// 2 was already in the set, so return false.
randomSet.insert(2);
// Since 2 is the only number in the set, getRandom always return 2.
randomSet.getRandom();

思路：
利用HashMap储存被添加元素在ArrayList里的下标，利用ArrayList储存被添加元素；删除元素时，如果该元素不是数组最后一位，需要将其与最后一位元素互换，再删除最后一位元素，同时更新HashMap。

注意：
解题关键在于一定要保证每个元素在Map和List里对应的的位置一模一样，其中一个有改动，另外一个也要作出相应改动；另外Random要求被取到的概率一样，因此Map和List里都不能有间隙，必须是连续的。
另外记住以下使用：map.remove(num)返回的是num在map的位置；list.set(idx, num)可以设置idx下标对应的数字为num；
*/

public class RandomizedSet {
    Map<Integer, Integer> map;
    List<Integer> nums;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<>();
        nums = new ArrayList<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        } else {
            // 利用HashMap储存被添加元素在数组中的下标
            map.put(val, map.size());
            // 利用数组储存被添加元素
            nums.add(val);
            return true;
        }
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        } else {
            // 把要删除的元素从HashMap中删掉，并得到其在数组中的下标
            int idx = map.remove(val);
            // 如果要删除的元素不是数组的最后一位
            if (idx < nums.size() - 1) {
                // 把要删除的元素与最后一位元素交换位置
                int lastOne = nums.get(nums.size() - 1);
                nums.set(idx, lastOne);
                // 在HashMap里更新
                map.put(lastOne, idx);
            }
            // 再删除数组的最后一位元素
            nums.remove(nums.size() - 1);
            return true;
        }
    }
    
    /** Get a random element from the set. */
    // Random rdm = new Random();
    public int getRandom() {
        // return nums.get(rdm.nextInt(nums.size()));
        return nums.get((int) Math.random() * nums.size());
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */

