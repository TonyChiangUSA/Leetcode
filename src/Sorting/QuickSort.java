package Sorting;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {
    public static void quick(int[] nums){
        if(nums==null || nums.length==0) return;
        shuffle(nums);
        quickSort(nums,0,nums.length-1);
    }

    // 对数组元素进行随机打乱
    private static void shuffle(int[] nums) {
        int n = nums.length;
        Random rand = new Random();
        for (int i = 0 ; i < n; i++) {
            // 从 i 到最后随机选一个元素
            int r = i + rand.nextInt(n - i);
            swap(nums, i, r);
        }
    }

    // 交换数组中的两个元素
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private  static void quickSort(int[] nums, int l, int r){
        if(l>=r) return;
        int mid=partition(nums,l,r);
        quickSort(nums,l,mid);
        quickSort(nums,mid+1,r);

    }

    private static int partition(int[] nums, int l, int r){
        int pivot=nums[l];
        while (l<r){
            while (l<r && nums[r]>=pivot) r--;
            nums[l]=nums[r];
            while (l<r && nums[l]<=pivot) l++;
            nums[r]=nums[l];
        }
        nums[l]=pivot;
        return l;
    }


     public static void main(String[] args) {
        int[] arr={4,7,1,5,9,5,6};
        quick(arr);
        System.out.println(Arrays.toString(arr));
    }
}
