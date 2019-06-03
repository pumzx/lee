package com.pan.instance;

/**
 * 4. 寻找两个有序数组的中位数
给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。

        请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。

        你可以假设 nums1 和 nums2 不会同时为空。

        示例 1:

        nums1 = [1, 3]
        nums2 = [2]

        则中位数是 2.0
        示例 2:

        nums1 = [1, 2]
        nums2 = [3, 4]

        则中位数是 (2 + 3)/2 = 2.5
*/
public class No4 {
    public static void solution() {
        int[] nums1 = {1, 34};
        int[] nums2 = {1,1};
        double result = findMedianSortedArrays(nums1, nums2);
        System.out.println(result);
    }

    private static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0, j=0, index = 0;
        int n1Len = nums1.length;
        int n2Len = nums2.length;
        int sumLen = n1Len + n2Len;
        int endIndex = sumLen/2;
        boolean two = false;
        if (sumLen % 2 == 0) {
            two = true;
        }
        int n1=0, tmp = 0;
        while (true) {
            if (i != n1Len && j != n2Len) {
                tmp = nums1[i] < nums2[j] ? nums1[i++] : nums2[j++];
            } else if (i != n1Len) {
                tmp = nums1[i++];
            } else if (j != n2Len) {
                tmp = nums2[j++];
            }
            if (two) {
                if (index == endIndex - 1 ) {
                    n1 = tmp;
                } else if (index == endIndex) {
                    return  ((double)n1 + (double) tmp) / 2;
                }
            } else {
                if (index == endIndex) {
                    return tmp;
                }
            }
            index++;
        }
    }
}
