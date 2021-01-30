package OOD;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AutocompleteSystem {
    class TrieNode implements Comparable {
        TrieNode[] children;
        String word;
        int times;
        List<TrieNode> hot;

        public TrieNode() {
            children = new TrieNode[128];
            word = null;
            times = 0;
            hot = new ArrayList<>();
        }

        @Override
        public int compareTo(Object o) {
            TrieNode node = (TrieNode) o;
            if (this.times == node.times) {
                return this.word.compareTo(node.word);
            }

            return node.times - this.times;
        }

        public void update(TrieNode node) {
            if (!this.hot.contains(node)) {
                this.hot.add(node);
            }

            Collections.sort(hot);

            if (hot.size() > 3) {
                hot.remove(hot.size() - 1);
            }
        }
    }

    TrieNode root;
    TrieNode cur;
    StringBuilder sb;

    public AutocompleteSystem(String[] sentences, int[] times) {
        root = new TrieNode();
        cur = root;
        sb = new StringBuilder();

        for (int i = 0; i < times.length; i++) {
            add(sentences[i], times[i]);
        }
    }


    public void add(String sentence, int t) {
        TrieNode p = root;

        List<TrieNode> visited = new ArrayList<>();
        for (char c : sentence.toCharArray()) {
            if (p.children[c] == null) {
                p.children[c] = new TrieNode();
            }

            p = p.children[c];
            visited.add(p);
        }

        p.word = sentence;
        p.times += t;

        for (TrieNode node : visited) {
            node.update(p);
        }
    }

    public List<String> input(char c) {
        List<String> res = new ArrayList<>();
        if (c == '#') {
            add(sb.toString(), 1);
            sb = new StringBuilder();
            cur = root;
            return res;
        }

        sb.append(c);
        if (cur != null) {
            cur = cur.children[c];
        }

        if (cur == null) return res;
        for (TrieNode node : cur.hot) {
            res.add(node.word);
        }

        return res;
    }
}
