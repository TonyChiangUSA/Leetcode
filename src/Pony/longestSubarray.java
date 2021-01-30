package Pony;

import java.util.*;

/*
*
* Input: nums = [10,1,2,4,7,2], limit = 5
Output: 4
Explanation: The subarray [2,4,7,2] is the longest since the maximum absolute diff is |2-7| = 5 <= 5.
*
* */
public class longestSubarray {
    public int longestSubarray(int[] nums, int limit) {
        //O(N) 的取区间里的最大值和最小值
        Deque<Integer> maxDeque = new LinkedList<>();
        Deque<Integer> minDeque = new LinkedList<>();

        int res = 1;
        int left = 0, right=0;

       // find the longest subarray for every right pointer by shrinking left pointer
        while ( right < nums.length) {

            // [7,2,3,4,5]=>[7,5]
            while (!maxDeque.isEmpty() && maxDeque.peekLast() < nums[right]) {
                maxDeque.removeLast();
            }
            maxDeque.addLast(nums[right]);

            // [4,3,2,1,5]=>[4,5]
            while (!minDeque.isEmpty() && minDeque.peekLast() > nums[right]) {
                minDeque.removeLast();
            }
            minDeque.addLast(nums[right]);

            // shrink left pointer if exceed limit
            while (maxDeque.peekFirst() - minDeque.peekFirst() > limit) {
                if (maxDeque.peekFirst() == nums[left]) maxDeque.pollFirst();
                if (minDeque.peekFirst() == nums[left]) minDeque.pollFirst();
                left++;  // shrink it!
            }

            // update res
            res = Math.max(res, right - left + 1);

            right++;
        }

        return res;
    }
}
