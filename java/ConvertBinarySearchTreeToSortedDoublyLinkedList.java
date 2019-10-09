package xiao8;

import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;

public class ConvertBinarySearchTreeToSortedDoublyLinkedList {
    public Node treeToDoublyList(Node root) {
        Node prev = new Node();

        Node curr = root;
        Stack<Node> stack = new Stack<>();

        Node start = null;

        while (!stack.isEmpty() || curr != null) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                Node visit = stack.pop();

                if (start == null) {
                    start = visit;
                }

                curr = visit.right;

                prev.right = visit;
                visit.left = prev;
                prev = prev.right;
            }
        }

        prev.right = start;
        start.left = prev;

        return start;
    }

    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };
}
