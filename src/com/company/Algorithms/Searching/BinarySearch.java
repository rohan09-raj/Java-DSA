package com.company.Algorithms.Searching;

public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = {1,2,5,6,7,8,16,23,32,39,47};
        binarySearch(nums, 32);
    }

    public static boolean binarySearch(int[] nums, int value) {
        int start = 0;
        int end = nums.length - 1;
        int middle = (start + end)/2;

        while(nums[middle] != value && start <= end) {
            if (value < nums[middle]) {
                end = middle - 1;
            } else {
                start = middle + 1;
            }
            middle = (start + end)/2;
        }

        if (nums[middle] == value) {
            System.out.println("Value : " + value);
            System.out.println("Found at Index : " + middle);
            return true;
        }

        System.out.println("Value : " + value + " Not Found!!!");
        return false;
    }
}
