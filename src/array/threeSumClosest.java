package array;

import java.util.*;

public class threeSumClosest {

    public static int threeSumClosest(int[] nums, int target) {
        if(nums==null || nums.length==0) return 0;
        Arrays.sort(nums);
        int res=Integer.MAX_VALUE;
        for(int base=0;base<nums.length-2;base++){
            if(base>=1 && nums[base]==nums[base-1]) continue;
            int lo=base+1, hi=nums.length-1;
            while(lo<hi){
                int sum=nums[lo]+nums[hi]+nums[base];
                if(sum==target){
                    return target;
                }else if(sum <target){
                    res=Math.min(res,Math.abs(sum-target));
                    lo++;
                }else{
                    res=Math.min(res,Math.abs(sum-target));
                    hi--;
                }
            }

        }
        return res+target;
    }

    public static void main(String[] args) {
        int[] nums={-1,2,1,-4};
        System.out.println(threeSumClosest(nums, 1));
    }
}
