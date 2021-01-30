package BFS;

import java.util.*;

public class WordLadder {

//
//    private int[] rowDir = {1, -1, 0, 0};
//    private int[] colDir = {0, 0, 1, -1};

    private int[][] dirs={{0,1},{0,-1},{-1,0},{0,1}};
    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0) return -1;
        int rows = grid.length, cols = grid[0].length;
        int[][] canReach = new int[rows][cols];
        int[][] dist = new int[rows][cols];
        Set<Integer> st=new HashSet<>();
        int totalBuildings = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    totalBuildings++;
                    if (!bfs(grid, i, j, dist, canReach)) return -1;
                }
            }
        }

        int minDis = Integer.MAX_VALUE;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (canReach[i][j] == totalBuildings &&
                        dist[i][j] < minDis) {
                    minDis = dist[i][j];
                }
            }
        }

        return minDis == Integer.MAX_VALUE ? -1 : minDis;
    }

    private boolean bfs(int[][] grid, int row, int col, int[][] dist, int[][] canReach) {
        int rows = grid.length, cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{row, col});
        visited[row][col] = true;

        int d = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            d++;
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                int x = cur[0];
                int y = cur[1];
                for(int[] dir:dirs){
                    int newX = dir[0] + x;
                    int newY = dir[1] + y;
                    if (!isValid(grid, newX, newY, visited)) continue;
                    if (grid[newX][newY] == 0) {
                        dist[newX][newY] += d;
                        canReach[newX][newY]++;
                        q.offer(new int[]{newX, newY});
                    }
                    visited[newX][newY] = true;
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean isValid(int[][] grid, int x, int y, boolean[][] visited) {
        if (x > grid.length - 1 ||
                x < 0 || y < 0 || y > grid[0].length - 1) return false;
        if (visited[x][y]) return false;
        if(grid[x][y] == 2) return false;

        return true;
    }
    //单向BFS
    public int ladderLengthOneDirectionBFS(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);

        if (!dict.contains(endWord)) return 0;

        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);

        int steps = 0;

        while (!q.isEmpty()) {
            steps++;
            int size = q.size();
            for (int s = 0; s < size; s++) {
                String cur = q.poll();
                char[] chs = cur.toCharArray();
                for (int i = 0; i < chs.length; ++i) {
                    char ch = chs[i];
                    for (char c = 'a'; c <= 'z'; ++c) {
                        if (c == ch) continue;
                        chs[i] = c;
                        String t = new String(chs);
                        if (t.equals(endWord)) return steps + 1;
                        if (!dict.contains(t)) continue;
                        //不能走重复路线比如hit->hot->hit->...
                        dict.remove(t);
                        q.offer(t);
                    }
                    chs[i] = ch;
                }
            }
        }
        return 0;
    }

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res=new LinkedList<>();
        if(s==null || s.length()==0 || words==null || words.length==0) return res;
        //<String,Count>
        Map<String,Integer> map=new HashMap<>();
        for(String word:words){
            map.put(word, map.getOrDefault(word,0)+1);
        }
        int wordsLen=words.length;
        int wordLen=words[0].length();
        int windowSize=wordLen*wordsLen;
        for(int i=0;i<s.length()-windowSize+1;i++){
            String substr=s.substring(i,i+wordsLen);
            if(isConcat(substr,map,wordLen)){
                res.add(i);
            }
        }

        return res;
    }

    private boolean isConcat(String s, Map<String,Integer> map, int wordLen) {
        Map<String,Integer> map_2=new HashMap<>();
        for(int i=0;i<s.length();i++) {
            String subStr = s.substring(i, i + wordLen);
            map_2.put(subStr, map_2.getOrDefault(subStr, 0) + 1);
            if (!map.containsKey(subStr) || map_2.get(subStr) > map.get(subStr)) {
                return false;
            }
        }
        return true;
    }

    //双向BFS
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) return 0;

        Set<String> q1 = new HashSet<>();
        Set<String> q2 = new HashSet<>();
        q1.add(beginWord);
        q2.add(endWord);

        int l = beginWord.length();
        int steps = 0;

        while (!q1.isEmpty() && !q2.isEmpty()) {
            ++steps;

            if (q1.size() > q2.size()) {
                Set<String> tmp = q1;
                q1 = q2;
                q2 = tmp;
            }

            Set<String> q = new HashSet<>();

            for (String w : q1) {
                char[] chs = w.toCharArray();
                for (int i = 0; i < l; ++i) {
                    char ch = chs[i];
                    for (char c = 'a'; c <= 'z'; ++c) {
                        chs[i] = c;
                        String t = new String(chs);
                        if (q2.contains(t)) return steps + 1;
                        if (!dict.contains(t)) continue;
                        dict.remove(t);
                        q.add(t);
                    }
                    chs[i] = ch;
                }
            }

            q1 = q;
        }
        return 0;
    }
}
