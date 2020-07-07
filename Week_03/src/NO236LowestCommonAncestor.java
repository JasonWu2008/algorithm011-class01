public class NO236LowestCommonAncestor {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode p = new TreeNode(6);
        TreeNode q = new TreeNode(7);
        TreeNode result = new NO236LowestCommonAncestor().lowestCommonAncestor(root, p, q);
        System.out.println(result.val);
    }

    //本质上是看qp是否在本节点(避免与树顶元素混淆)的左边和右边，如果是本节点就是"最短公共祖先"
    //如果两个节点分散在本节点的两侧，那本节点一定是"最短公共祖先"，
    //如果两个节点集在一侧，如果找到一个
    //DFS递归遍历整棵树
    private TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        lowestCommonAncestor(root.left,p,q);
        return null;
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
