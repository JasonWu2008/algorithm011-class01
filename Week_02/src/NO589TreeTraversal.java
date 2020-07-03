import java.util.ArrayList;
import java.util.List;

public class NO589TreeTraversal {
    public static void main(String[] args) {
        //[1,3,5,6,2,4]
        //[1,3,5,6,2,4]
        Node root = new Node();
        root.val = 1;
        List<Node> leafNodes = new ArrayList<>();
        leafNodes.add(new Node(5));
        leafNodes.add(new Node(6));
        Node childNode = new Node(3);
        childNode.children = leafNodes;

        List<Node> children = new ArrayList<>();
        children.add(childNode);
        children.add(new Node(2));
        children.add(new Node(4));
        root.children = children;
        List<Integer> results = new NO589TreeTraversal().preorder(root);
        for (Integer result : results) {
            System.out.println(result);
        }
    }

    public List<Integer> preorder(Node root) {
        List<Integer> results = new ArrayList<>();
        if (root != null) {
            results.add(root.val);
        }
        if (root == null || root.children == null || root.children.isEmpty()) {
            return results;
        }
        for (Node child : root.children) {
            if (child.children == null || child.children.isEmpty()) {
                results.add(child.val);
            } else {
                results.addAll(preorder(child));
            }
        }
        return results;
    }

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    ;
}
