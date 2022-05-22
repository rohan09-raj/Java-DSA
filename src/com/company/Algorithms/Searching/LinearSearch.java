package com.company.Algorithms.Searching;

public class LinearSearch {
    public static void main(String[] args) {
        int[] nums = {1,6,2,1,45,7,3,2};
        System.out.println(linearSearch(nums, 45));
    }

    public static boolean linearSearch(int[] nums, int value) {
        for(int i=0; i<nums.length; i++) {
            if (nums[i] == value) {
                System.out.println("Value : " + value);
                System.out.println("Found at Index : " + i);
                return true;
            }
        }

        System.out.println("Value : " + value + " Not Found!!!");
        return false;
    }
}
