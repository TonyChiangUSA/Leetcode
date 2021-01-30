package slidingWindow;

import java.util.*;

public class minWindow {

    int[][] dirs = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    public int findCircleNum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int res = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    res++;
                    dfs(grid, i, j, rows, cols, visited);
                }
            }
        }
        return res;
    }

    /**
     * time : O(m * n)
     * space : O(m * n)
     *
     * @param grid
     */

    private void dfs(int[][] grid, int x, int y, int rows, int cols, boolean[][] visited) {
        if (x < 0 || y < 0 || x >= rows || y >= cols || grid[x][y] == 0 || visited[x][y]) return;
        visited[x][y] = true;
        for (int[] dir : dirs) {
            int newX = x + dir[0];
            int newY = y + dir[1];
            dfs(grid, newX, newY, rows, cols, visited);
        }
    }

    public int numSubseq2(int[] A, int target) {
        Arrays.sort(A);
        int res = 0, n = A.length, l = 0, r = n - 1, mod = (int) 1e9 + 7;
        int[] pows = new int[n];
        pows[0] = 1;
        for (int i = 1; i < n; ++i)
            pows[i] = pows[i - 1] * 2 % mod;
        while (l <= r) {
            if (A[l] + A[r] > target) {
                r--;
            } else {
                res = (res + pows[r - l]) % mod;
            }
        }

        return res;
    }

    public static String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for (char c : t.toCharArray()) need.put(c, need.getOrDefault(c, 0) + 1);

        int left = 0, right = 0;
        int valid = 0;
        // 记录最小覆盖子串的起始索引及长度
        int start = 0, len = Integer.MAX_VALUE;
        while (right < s.length()) {
            // c 是将移入窗口的字符
            char c = s.charAt(right);
            // 右移窗口
            right++;
            // 进行窗口内数据的一系列更新
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c)))
                    valid++;
            }

            // 判断左侧窗口是否要收缩
            while (valid == need.size()) {
                // 在这里更新最小覆盖子串
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                // d 是将移出窗口的字符
                char d = s.charAt(left);
                // 左移窗口
                left++;
                // 进行窗口内数据的一系列更新
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d)))
                        valid--;
                    window.put(d, window.getOrDefault(d, 0) - 1);
                }
            }
        }
        // 返回最小覆盖子串
        return len == Integer.MAX_VALUE ?
                "" : s.substring(start, start + len);
    }

    //O(N) amortized
    public static int findKthLargest(int[] nums, int k) {
        //corner case
        if (nums == null || nums.length == 0 || k <= 0) return 0;
        // 首先随机打乱数组
//        shuffle(nums);
        int n = nums.length;
        int lo = 0, hi = n - 1;
        while (lo <= hi) {
            int p = partition(nums, lo, hi);
            if (p > n - k) {
                hi = p - 1;
            } else if (p < n - k) {
                lo = p + 1;
            } else {
                return nums[p];
            }
        }
        return -1;
    }

    // Lomuto partition algorithm
    private static int partition(int[] nums, int low, int high) {
        int left = low;
        int pivot = nums[high];
        for (int i = left; i < high; ++i) {
            if (nums[i] <= pivot) {
                swap(nums, i, left);
                left++;
            }
        }
        swap(nums, left, high);
        return left;
    }

    // 对数组元素进行随机打乱
    private static void shuffle(int[] nums) {
        int n = nums.length;
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
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

    public static boolean canPartitionKSubsets(int[] nums, int k) {
        int total=0;
        for(int n:nums){
            total+=n;
        }
        if (total%k!=0) return false;

        int[] visited=new int[16];
        return helper(nums,0,0,0,visited,k,total);
    }

    private static boolean helper(int[] nums, int cur,int group,int sum,int[] visited,int k,int total){

        if(group==k) return true;
        if (sum > total/k) return false;
        if(total/k==sum) {
            helper(nums,0,group+1,0,visited,k,total);
        }

        for(int i=cur;i<nums.length;i++){
            if(visited[i]==1) continue;
            visited[i]=1;
            if(helper(nums,i,group,sum+nums[i],visited,k,total)) {
                return true;
            }
            visited[i]=0;
        }

        return false;
    }
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        int[] nums = {4, 3, 2, 3, 5, 2, 1};
        System.out.println(canPartitionKSubsets(nums,4));
    }
}
