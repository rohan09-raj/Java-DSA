package com.company.Algorithms.Sorting;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] nums = {9, 3, 6, 2, 1, 5, 1, 6, 8, 7, 3, 0};
        System.out.println(Arrays.toString(insertionSort(nums)));
    }

    public static int[] insertionSort(int[] nums) {
        for (int i=0; i<nums.length; i++) {
            int temp = nums[i];
            int j = i;
            while (j>0 && nums[j-1] > temp) {
                nums[j] = nums[j-1];
                j--;
            }
            nums[j] = temp;
        }
        return nums;
    }
}
