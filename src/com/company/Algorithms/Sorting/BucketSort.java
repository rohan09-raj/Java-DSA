package com.company.Algorithms.Sorting;

import java.util.*;

public class BucketSort {
    public static void main(String[] args) {
        int[] nums = {9,2,5,6,3,1,8,0,7,4};
        System.out.println(Arrays.toString(bucketSort(nums)));
    }

    public static int[] bucketSort(int[] nums) {
        int numberOfBuckets = (int) Math.ceil(Math.sqrt(nums.length));
        int maxValue = Integer.MIN_VALUE;

        // Finding Maximum Value
        for (int value: nums) {
            if (value > maxValue) {
                maxValue = value;
            }
        }

        // Creating Buckets
        ArrayList<Integer>[] buckets = new ArrayList[numberOfBuckets];
        for (int i=0; i<buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }

        // Distributing the values among buckets
        for (int value: nums) {
            int bucketNumber = (int) Math.ceil(((float)value * numberOfBuckets) / (float)maxValue);
            if(bucketNumber > 0) {
                buckets[bucketNumber-1].add(value);
            }
        }

        // Sort the Buckets
        for (ArrayList<Integer> bucket: buckets) {
            Collections.sort(bucket);
        }

        // Merge the Lists into one Array
        int[] sortedNums = new int[nums.length];
        int index = 0;
        for (ArrayList<Integer> bucket: buckets) {
            for (int value: bucket) {
                sortedNums[index] = value;
                index++;
            }
        }

        return sortedNums;
    }
}
