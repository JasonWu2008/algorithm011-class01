public class NO236LowestCommonAncestor {
    public static void main(String[] args) {
//        TreeNode result = new NO236LowestCommonAncestor().lowestCommonAncestor(createCase1(), new TreeNode(5), new TreeNode(7));
        TreeNode result = new NO236LowestCommonAncestor().lowestCommonAncestor(createCase2(), new TreeNode(4), new TreeNode(7));
        if (result != null) {
            System.out.println(result.val);
        }
    }

    private static TreeNode createCase2() {
        TreeNode root = new TreeNode(3);

        TreeNode leftNode = new TreeNode(5);
        leftNode.left = new TreeNode(6);
        leftNode.right = new TreeNode(2);
        leftNode.right.left = new TreeNode(7);
        leftNode.right.right = new TreeNode(4);

        TreeNode rightNode = new TreeNode(1);
        rightNode.left = new TreeNode(0);
        rightNode.right = new TreeNode(8);

        root.left = leftNode;
        root.right = rightNode;
        return root;
    }

    private static TreeNode createCase1() {
        TreeNode root = new TreeNode(3);

        TreeNode leftNode = new TreeNode(5);
        leftNode.left = new TreeNode(6);
        leftNode.right = new TreeNode(2);
        leftNode.right.left = new TreeNode(7);
        leftNode.right.right = new TreeNode(4);

        TreeNode rightNode = new TreeNode(1);
        rightNode.left = new TreeNode(0);
        rightNode.right = new TreeNode(8);

        root.left = leftNode;
        root.right = rightNode;
        return root;
    }


    //本质上是看qp是否在本节点(避免与树顶元素混淆)的左边和右边，如果是，本节点就是"最短公共祖先"
    //如果pq分散在本节点的两侧，那本节点一定是"最短公共祖先"
    //否则pq一定集在一侧，此时递归在一边不为空的节点找
    //DFS递归遍历整棵树
    private TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root.val == p.val || root.val == q.val) {
            return root;
        }
        TreeNode left = null;
        TreeNode right = null;
        if (root.left != null) {
            left = lowestCommonAncestor(root.left, p, q);
        }
        if (root.right != null) {
            right = lowestCommonAncestor(root.right, p, q);
        }
        if (left != null && right != null) {
            return root;
        }
        return left != null ? lowestCommonAncestor(left, p, q) : lowestCommonAncestor(right, p, q);
    }

    /**
     * Definition for a binary tree node
     */
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
