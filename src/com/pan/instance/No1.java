package com.pan.instance;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class No1 {
    public static void solution() {
        int[] nums = {2, 7, 11, 15};
        int target = 13;
        int[] index = solution(nums, target, 3);
        Arrays.stream(index).forEach(System.out::println);
    }

    /*
    1. 两数之和

    给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

    你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。

    示例:

    给定 nums = [2, 7, 11, 15], target = 9

    因为 nums[0] + nums[1] = 2 + 7 = 9
    所以返回 [0, 1]
    */

    private static int[] solution(int[] nums, int target, int way) {
        switch (way) {
            case 1:
                return twoSum1(nums, target);
            case 2:
                return twoSum2(nums, target);
            case 3:
                return twoSum3(nums, target);
        }
        return null;
    }

    private static int[] twoSum1(int[] nums, int target) {
        int[] index = new int[2];
        // 1 直接遍历
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    index[0] = i;
                    index[1] = j;
                    return index;
                }
            }
        }
        return null;
    }

    private static int[] twoSum2(int[] nums, int target) {
        int[] index = new int[2];
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            map.put(target-nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                index[0] = i;
                index[1] = map.get(nums[i]);
                return index;
            }
        }
        return null;

    }

    private static int[] twoSum3(int[] nums, int target) {
        int[] index = new int[2];
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 1; i < nums.length; i++) {
            map.put(target-nums[i-1], i-1);
            if (map.containsKey(nums[i])) {
                index[0] = map.get(nums[i]);
                index[1] = i;
                return index;
            }
        }
        return null;

    }
}
