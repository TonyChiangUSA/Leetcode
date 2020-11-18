package Sorting;

import java.util.Arrays;

public class MergeSort {
    public static void mergeSort(int[] nums){
        if(nums==null || nums.length==0) return;
        mergeSort(nums,0,nums.length-1);
    }

    private  static void mergeSort(int[] nums, int l, int r){
        if(l>=r) return;
        int mid=l+(r-l)/2;
        mergeSort(nums,l,mid);
        mergeSort(nums,mid+1,r);
        merge(nums,l,r);
    }

    private static void merge(int[] nums, int l, int r){
        int mid=l+(r-l)/2;
        int i=l, j=mid+1, k=0;
        int[] temp=new int[r-l+1];
        while(i<=mid || j<=r){
            if(i>mid || j<=r && nums[j]<nums[i]){
                temp[k++]=nums[j++];
            }else {
                temp[k++]=nums[i++];
            }
        }
        System.arraycopy(temp,0,nums,l,r-l+1);
    }

     public static void main(String[] args) {
        int[] arr={4,7,1,5,9,5,6};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
