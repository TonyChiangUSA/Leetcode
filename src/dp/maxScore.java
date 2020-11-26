package dp;

import java.util.Arrays;

public class maxScore {
    public static int maxScore(int[] nums, int k){
        if(nums==null || nums.length==0) return 0;
        int n=nums.length;
        int[][] memo=new int[n][n];
        return helper(nums,0,n-1,k,memo);
    }

    public int networkDelayTime(int[][] times, int N, int K) {
        int[] dis = new int[N];
        Arrays.fill(dis, -1);
        //K到K的最短距离初始化为0
        dis[K - 1] = 0;
        //BF只做V-1次循环，最后一次是检测negative cycle
        for (int i = 1; i < N; i++) {
            for (int[] edge : times) {
                int u = edge[0] - 1, v = edge[1] - 1, w = edge[2];
                dis[v] = Math.min(dis[v], dis[u] + w);
            }
        }
        int res = -1;
        for (int i: dis) {
            res = Math.max(i, res);
        }
        return res ;
    }


    private static int helper(int[] nums, int l, int r, int k, int[][] memo){
        if(k==1) return Math.max(nums[l],nums[r]);
        if(memo[l][r]!=0) return memo[l][r];
        int subL= helper(nums,l+1,r,k-1,memo);
        memo[l+1][r]=subL;
        int left=nums[l]+subL;
        int subR= helper(nums,l,r-1,k-1,memo);
        memo[l][r-1]=subR;
        int right=nums[r]+subR;

        int res=Math.max(left,right);
        memo[l][r]=res;
        return res;
    }

    public static void main(String[] args) {
        int[] nums={1,2,3,4,5,6,1};
        int res=maxScore(nums,3);
        System.out.println(res);
    }
}
