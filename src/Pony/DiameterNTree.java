package Pony;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DiameterNTree {

    int diameter = 0;
    public int diameter(Node root) {
        height(root);
        return diameter;
    }

    /**
     * return the height of the node
     */
    protected int height(Node node) {
        if (node.children.size() == 0)
            return 0;

        // select the top two largest heights
        int maxHeight1 = 0, maxHeight2 = 0;
        for (Node child : node.children) {
            int height = height(child) + 1;
            if (height > maxHeight1) {
                maxHeight2 = maxHeight1;
                maxHeight1 = height;
            } else if (height > maxHeight2) {
                maxHeight2 = height;
            }
            // calculate the distance between the two farthest leaves nodes.
            int distance = maxHeight1 + maxHeight2;
            diameter = Math.max(diameter, distance);
        }

        return maxHeight1;
    }

    // Definition for a Node.
    class Node {
        public int val;
        public List<Node> children;


        public Node() {
            children = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            children = new ArrayList<Node>();
        }

        public Node(int _val,ArrayList<Node> _children) {
            val = _val;
            children = _children;
        }
    };

}

