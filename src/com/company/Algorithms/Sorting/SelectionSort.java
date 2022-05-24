package com.company.Algorithms.Sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] nums = {9, 3, 6, 2, 1, 5, 1, 6, 8, 7, 3, 0};
        System.out.println(Arrays.toString(selectionSort(nums)));
    }

    public static int[] selectionSort(int[] nums) {
        for (int i=0; i<nums.length; i++) {
            int minimumIndex = i;
            for (int j=i+1; j<nums.length; j++) {
                if (nums[j] < nums[minimumIndex]) {
                    minimumIndex = j;
                }
            }
            if (minimumIndex != i) {
                int temp = nums[i];
                nums[i] = nums[minimumIndex];
                nums[minimumIndex] = temp;
            }
        }
        return nums;
    }
}
