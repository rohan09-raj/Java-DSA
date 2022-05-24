package com.company.Algorithms.Sorting;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] nums = {9,2,5,6,3,1,8,0,7,4};
        System.out.println(Arrays.toString(mergeSort(nums, 0, nums.length-1)));
    }

    public static int[] mergeSort(int[] nums, int left, int right) {
        if (left < right) {
            int middle = (left + right)/2;
            mergeSort(nums, left, middle);
            mergeSort(nums, middle+1, right);
            merge(nums, left, middle, right);
        }

        return nums;
    }

    public static void merge(int[] nums, int left, int middle, int right) {
        int[] leftTempArray = new int[middle-left+2];
        int[] rightTempArray = new int[right-middle+1];

        int x=0;
        while(x<=middle-left) {
            leftTempArray[x] = nums[left+x];
            x++;
        }

        for (int i=0; i<right-middle; i++) {
            rightTempArray[i] = nums[middle+i+1];
        }

        leftTempArray[middle-left+1] = Integer.MAX_VALUE;
        rightTempArray[right-middle] = Integer.MAX_VALUE;

        int i=0, j=0;
        for (int k= left; k<=right; k++) {
            if (leftTempArray[i] < rightTempArray[j]) {
                nums[k] = leftTempArray[i];
                i++;
            } else {
                nums[k] = rightTempArray[j];
                j++;
            }
        }
    }
}
