package Tree;

import java.util.*;

public class inorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;

        }
        return list;
    }

    /*
     *      7
     *     / \
     *    3   5
     *   / \  /
     *  1  4  9
     *
     * 731 + 734 + 759
     **/

    private static List<String> pathSum(TreeNode root) {
        List<String> res = new ArrayList<>();
        helper(root, res, new StringBuilder());
        return res;
    }

    private static void helper(TreeNode root, List<String> res, StringBuilder sb) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            sb.append(root.val);
            res.add(sb.toString());
        }
        sb.append(root.val);
        helper(root.left, res, sb);
        helper(root.right, res, sb);

    }

    class Tuple {
        TreeNode node;
        int x;  //horizontal
        int depth;  //depth

        Tuple(TreeNode n, int x, int depth) {
            node = n;
            this.x = x;
            this.depth = depth;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        Map<Integer, List<Tuple>> map = new HashMap<>(); //x -> list (some nodes might have same y in the list)

        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(root, 0, 0));
        int min = 0, max = 0;
        while (!q.isEmpty()) {
            Tuple p = q.poll();

            min = Math.min(min, p.x);
            max = Math.max(max, p.x);

            map.computeIfAbsent(p.x,v->new ArrayList<>()).add(p);

            if (p.node.left != null) q.add(new Tuple(p.node.left, p.x - 1, p.depth + 1));
            if (p.node.right != null) q.add(new Tuple(p.node.right, p.x + 1, p.depth + 1));
        }

        for (int i = min; i <= max; i++) {
            Collections.sort(map.get(i), new Comparator<Tuple>() {
                public int compare(Tuple a, Tuple b) {
                    if (a.depth == b.depth) //when y is equal, sort it by value
                        return a.node.val - b.node.val;
                    return 0; //otherwise don't change the order as BFS ganrantees that top nodes are visited first
                }
            });
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < map.get(i).size(); j++) {
                list.add(map.get(i).get(j).node.val);
            }
            lists.add(list);
        }
        return lists;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(9);

        System.out.println(pathSum(root));
    }
}
