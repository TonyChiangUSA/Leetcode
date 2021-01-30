package Pony;

import java.util.Random;

public class minMoves {
    public int minMoves2(int[] A) {
        int sum = 0, median = findMedian(A, A.length/2+1);
        for (int i=0;i<A.length;i++) sum += Math.abs(A[i] - median);
        return sum;
    }

    //O(N) amortized
    public int findMedian(int[] nums, int m) {
        //corner case
        if(nums==null || nums.length==0 || m<=0) return 0 ;
        // 首先随机打乱数组
        shuffle(nums);
        int n=nums.length;
        int lo=0, hi=n-1;
        while(lo<=hi){
            int p=partition(nums,lo,hi);
            if(p>n-m){
                hi=p-1;
            }else if(p<n-m){
                lo=p+1;
            }else{
                return nums[p];
            }
        }
        return -1;
    }
    // Lomuto partition algorithm
    int partition(int[] nums, int low, int high) {
        int left = low;
        int pivot = nums[high];
        for( int i = left; i < high; ++i) {
            if( nums[i] <= pivot) {
                swap(nums, i , left);
                left++;
            }
        }
        swap(nums, left, high);
        return left;
    }

    // 对数组元素进行随机打乱
    private void shuffle(int[] nums) {
        int n = nums.length;
        Random rand = new Random();
        for (int i = 0 ; i < n; i++) {
            // 从 i 到最后随机选一个元素
            int r = i + rand.nextInt(n - i);
            swap(nums, i, r);
        }
    }

    // 交换数组中的两个元素
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
