package Pony;

import java.util.*;

public class numMatchingSubseq {
    /*

 For example: input = "abacbca" ---> POS = ['a', 'b', 'c'] = [ [0,2,6], [1,4], [3,5] ]

      word = "acb"
     'a' we choose 0
     'c' we choose 3
     'b' we choose 4
     [0,3,4] is an increasing order, so "acb" is a subsequence of our input.

      Time complexity is O(mklog(n) where
      n is the length of s,
      m is the length of words,
      k is the largest length of word.



*/
    public int numMatchingSubseq(String S, String[] words) {
        List<Integer>[] pos = new List[128];
        for(char ch = 'a'; ch <= 'z'; ch++)
            pos[ch] = new ArrayList<>();
        for(int i = 0; i < S.length(); i++) {
            pos[S.charAt(i)].add(i);
        }
        int ans = 0;
        outer: for(String w : words) {
            int idx = -1;
            for(char ch : w.toCharArray()) {
                idx = find(pos[ch], idx);
                if (idx == -1) continue outer;
            }
            ans++;
        }
        return ans;
    }
    private int find(List<Integer> list, int idx) {
        int l = 0, r = list.size();
        while(l < r) {
            int mid = (l + r) / 2;
            if (list.get(mid) > idx)
                r = mid;
            else
                l = mid + 1;
        }
        return l == list.size() ? -1 : list.get(l);
    }


    public static void main(String[] args) {
        String S = "abcde";
        String[] words = new String[]{"a", "bb", "acd", "ace"};
//        numMatchingSubseq(S, words);
    }
}


