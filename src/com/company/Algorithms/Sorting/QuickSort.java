package com.company.Algorithms.Sorting;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] nums = {9,2,5,6,3,1,8,0,7,4};
        System.out.println(Arrays.toString(quickSort(nums, 0, nums.length-1)));
    }

    public static int[] quickSort(int[] nums, int start, int end) {
        if (start < end) {
            int pivot = partition(nums, start, end);
            quickSort(nums, start, pivot-1);
            quickSort(nums, pivot+1, end);
        }

        return nums;
    }

    public static int partition(int[] nums, int start, int end) {
        int i = start-1;
        for (int j=start; j<=end; j++) {
            if (nums[j] <= nums[end]) {
                i++;
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        return i;
    }
}
