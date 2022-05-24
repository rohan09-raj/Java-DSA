package com.company.Algorithms.Sorting;
import java.util.*;

public class HeapSort {
    public static void main(String[] args) {
        int[] nums = {9,2,5,6,3,1,8,0,7,4};
        System.out.println(Arrays.toString(heapSort(nums)));
    }

    public static int[] heapSort(int[] nums) {
        int n = nums.length;

        //Rearrange array (building heap)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(nums, n, i);
        }

        //Extract elements from heap one by one
        for (int i = n - 1; i >= 0; i--) {
            //Current root moved to the end
            int tmp = nums[0];
            nums[0] = nums[i];
            nums[i] = tmp;

            heapify(nums, i, 0);//calling max heapify on the heap reduced
        }

        return nums;
    }

    public static void heapify(int[] nums, int n, int i) {
        int max = i; //Initialize max as root
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;

        //If left child is greater than root
        if (leftChild < n && nums[leftChild] > nums[max])
            max = leftChild;

        //If right child is greater than max
        if (rightChild < n && nums[rightChild] > nums[max])
            max = rightChild;

        //If max is not root
        if (max != i) {
            int swap = nums[i];
            nums[i] = nums[max];
            nums[max] = swap;

            //heapify the affected sub-tree recursively
            heapify(nums, n, max);
        }
    }
}
