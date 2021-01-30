package Sorting;

import java.util.Arrays;

public class MergeSort {

    public static void mergeSort(int[] nums) {
        if (nums == null || nums.length == 0) return;
        mergeSort2(nums);
    }

    private static void mergeSort(int[] nums, int lo, int hi) {
        if (lo >= hi) return;
        int mid = lo + (hi - lo) / 2;
        mergeSort(nums, lo, mid);
        mergeSort(nums, mid + 1, hi);
        merge(nums, lo, hi);
    }

    private static void merge(int[] nums, int lo, int hi) {
        int mid = lo + (hi - lo) / 2;
        int i = lo, j = mid + 1, k = 0;
        int[] temp = new int[hi - lo + 1];
        while (i <= mid && j <= hi) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
            while (i <= mid) {
                temp[k++] = nums[i++];
            }

            while (j <= hi) {
                temp[k++] = nums[j++];
            }
        }
        System.arraycopy(temp, 0, nums, lo, hi - lo + 1);
    }

    private static void mergeSort2(int[] nums) {
        int size, i, lo, mid, hi;
        int n = nums.length;
        for (size = 2; size <= n; size *= 2) {
            for (i = 0; i + size - 1 < n; i += size) {
                lo = i;
                hi = i + size - 1;
                mid = lo + (hi - lo) / 2;
                merge2(nums, lo, mid, hi);
            }
        }

        if (size / 2 < n) {
            merge2(nums, 0, size / 2 - 1, n - 1);
        }
    }

    private static void merge2(int[] nums, int l, int mid, int r) {
        int[] tmp = new int[r - l + 1];
        int i = l, j = mid + 1, k = 0;
        while (i <= mid && j <= r) {
            if (nums[i] > nums[j]) {
                tmp[k++] = nums[j++];
            } else {
                tmp[k++] = nums[i++];
            }
        }

        while (i <= mid) {
            tmp[k++] = nums[i++];
        }

        while (j <= r) {
            tmp[k++] = nums[j++];
        }

        System.arraycopy(tmp, 0, nums, l, r - l + 1);
    }

    public static void main(String[] args) {
        int[] arr = {5, 1, 1, 2, 0, 0};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
