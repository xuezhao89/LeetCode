/*
��Ŀ��
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

˼·��
����HashMap���汻���Ԫ����ArrayList����±꣬����ArrayList���汻���Ԫ�أ�ɾ��Ԫ��ʱ�������Ԫ�ز����������һλ����Ҫ���������һλԪ�ػ�������ɾ�����һλԪ�أ�ͬʱ����HashMap��

ע�⣺
����ؼ�����һ��Ҫ��֤ÿ��Ԫ����Map��List���Ӧ�ĵ�λ��һģһ��������һ���иĶ�������һ��ҲҪ������Ӧ�Ķ�������RandomҪ��ȡ���ĸ���һ�������Map��List�ﶼ�����м�϶�������������ġ�
�����ס����ʹ�ã�map.remove(num)���ص���num��map��λ�ã�list.set(idx, num)��������idx�±��Ӧ������Ϊnum��
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
            // ����HashMap���汻���Ԫ���������е��±�
            map.put(val, map.size());
            // �������鴢�汻���Ԫ��
            nums.add(val);
            return true;
        }
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        } else {
            // ��Ҫɾ����Ԫ�ش�HashMap��ɾ�������õ����������е��±�
            int idx = map.remove(val);
            // ���Ҫɾ����Ԫ�ز�����������һλ
            if (idx < nums.size() - 1) {
                // ��Ҫɾ����Ԫ�������һλԪ�ؽ���λ��
                int lastOne = nums.get(nums.size() - 1);
                nums.set(idx, lastOne);
                // ��HashMap�����
                map.put(lastOne, idx);
            }
            // ��ɾ����������һλԪ��
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

