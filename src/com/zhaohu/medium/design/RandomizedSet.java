package com.zhaohu.medium.design;

import java.util.*;

public class RandomizedSet {

    List<Integer> nums;
    Map<Integer, Integer> map;
    Random random;

    public RandomizedSet() {
        nums = new ArrayList<>();
        map = new HashMap<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val))
            return false;

        map.put(val, nums.size());
        nums.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val))
            return false;
        int last = nums.get(nums.size() - 1);
        int index = map.get(val);
        nums.set(index, last);
        map.put(last,index);
        map.remove(val);
        nums.remove(nums.size() - 1);

        return true;

    }

    public int getRandom() {
        return nums.get(random.nextInt(nums.size()));
    }
}
