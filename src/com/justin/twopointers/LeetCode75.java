package com.justin.twopointers;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/sort-colors/
 */
public class LeetCode75 {
    public static void sortColors(int[] nums) {
        int i = 0, leftBoundIndex = 0, rightBoundIndex = nums.length - 1;

        while(i <= rightBoundIndex) {
            if (nums[i] == 0) {
                swap(nums, leftBoundIndex, i);
                leftBoundIndex++;
                i++;
            } else if (nums[i] == 2) {
                swap(nums, i, rightBoundIndex);
                rightBoundIndex--;
            } else {
                i++;
            }
        }
    }

    public static void swap(int[] array, int left, int right) {
        int leftV = array[left];
        int rightV = array[right];
        array[left] = rightV;
        array[right] = leftV;
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 2,0,2,1,1,0 };
        sortColors(nums);
        System.out.println(Arrays.stream(nums).mapToObj(String::valueOf).collect(Collectors.joining(",")));
    }
}
