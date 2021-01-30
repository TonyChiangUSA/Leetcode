package test;

import java.util.Arrays;
import java.util.Random;

public class Test {
    private static void quickSort(int[] nums){
        shuffle(nums);
        quickSort(nums,0,nums.length-1);
    }

    private static void quickSort(int[] nums, int lo, int hi) {
        if(lo>=hi) return;
        int pivot=patition(nums,lo,hi);
        quickSort(nums,lo,pivot-1);
        quickSort(nums,pivot+1,hi);
    }

    private static int patition(int[] nums, int lo, int hi) {
        int pivot=nums[hi];
        int left=lo;
        for (int i=left;i<hi;i++){
            if(nums[i]<=pivot){
                swap(nums,i,left);
                left++;
            }
        }
        swap(nums,left,hi);
        return left;
    }

    private static void shuffle(int[] nums) {
        Random r=new Random();
        int n=nums.length;
        for (int i=0;i<n;i++){
            int j=i+r.nextInt(n-i);
            swap(nums,i,j);
        }
    }

    private static void swap(int[] nums, int i, int j){
        int tmp=nums[j];
        nums[j]=nums[i];
        nums[i]=tmp;
    }

    public static void main(String[] args) {
        int[] nums={1,5,3,2,6,9};
        quickSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
