import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class NO105BuildTree {
    //value:index pairs
    private Map<Integer, Integer> inOrderMap = new HashMap<>();
    //value:node pairs
    private Map<Integer, TreeNode> nodeValAndNodeMap = new HashMap<>();
    private Set<Integer> visited = new HashSet<>();

    public static void main(String[] args) {
        /*int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};*/

        /**
         *      0
         *    /   \
         *   1     2
         *  / \   / \
         * 3  5  6  8
         *   /    \
         *  4     7
         *
         */
        int[] preorder = {0, 1, 3, 5, 4, 2, 6, 7, 8};
        int[] inorder = {3, 1, 4, 5, 0, 6, 7, 2, 8};
        TreeNode treeNode = new NO105BuildTree().buildTree(preorder, inorder);
        printTreeNode(treeNode);
        System.out.println(treeNode);
    }

    private static void printTreeNode(TreeNode treeNode) {
        System.out.println(treeNode.val);
        if (treeNode.left != null) {
            printTreeNode(treeNode.left);
        }
        if (treeNode.right != null) {
            printTreeNode(treeNode.right);
        }
    }

    private TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0 || preorder.length != inorder.length) {
            return null;
        }
        for (int i = 0; i < inorder.length; i++) {
            inOrderMap.put(inorder[i], i);
            nodeValAndNodeMap.put(preorder[i], new TreeNode(preorder[i]));
        }
        TreeNode treeNode = nodeValAndNodeMap.get(preorder[0]);
        visited.add(treeNode.val);
        build(treeNode, preorder, inorder);
        return treeNode;
    }

    //终止条件：访问过的元素已满
    /***
     填充判断有没有填充,是通过用成员visited的Set来判断，当加到左节点或右节点后同时会加到visited列表里
     整个过程有4个分支：
     branch1:拿父节点值到中序遍历列表里找"左"边节点，没有填充时，放在父节点左节点，以"本节点"作为"根节点"，递归下探，比如节点：1，3，6
     branch2:拿父节点值到中序遍历列表里找"左"边节点，有填充时，此时需要往右节点放，进入branch3:
     拿父节点到中序遍历列表里找"右"边节点,又份两种情况：
     branch3:如果没有填充，直接放在右节点上，比如节点：5,2,8
     branch4:如果有填充，拿出"右"节点替换父节点，比如节点：2，7（2是放在5的右边还是0的右边）
     ***/
    private void build(TreeNode parentNode, int[] preorder, int[] inorder) {
        if (visited.size() == preorder.length) {
            return;
        }
        TreeNode currentNode = nodeValAndNodeMap.get(preorder[visited.size()]);
        if (parentNode.left == null) {
            int leftNode = findLeftNode(parentNode.val, inorder);
            if (leftNode != Integer.MIN_VALUE && !visited.contains(leftNode)) {
                parentNode.left = currentNode;
                visited.add(currentNode.val);
                build(currentNode, preorder, inorder);//1,3,6
            } else {
                buildRight(parentNode, preorder, inorder);
            }
        } else {
            buildRight(parentNode, preorder, inorder);
        }
    }

    private void buildRight(TreeNode parentNode, int[] preorder, int[] inorder) {
        int rightNodeValue = findRightNode(parentNode.val, inorder);
        if (!visited.contains(rightNodeValue)) {//5,2,8
            TreeNode currentNode = nodeValAndNodeMap.get(preorder[visited.size()]);
            visited.add(currentNode.val);
            parentNode.right = currentNode;
            build(currentNode, preorder, inorder);
        } else {
            build(nodeValAndNodeMap.get(rightNodeValue), preorder, inorder);//2,7
        }
    }

    private int findRightNode(int parentValue, int[] inorder) {
        Integer inorderIndex = inOrderMap.get(parentValue);
        if (inorderIndex == inOrderMap.size() - 1) {
            return Integer.MIN_VALUE;
        }
        return inorder[inorderIndex + 1];
    }

    private int findLeftNode(int parentValue, int[] inorder) {
        Integer inorderIndex = inOrderMap.get(parentValue);
        if (inorderIndex == 0) {
            return Integer.MIN_VALUE;
        }
        return inorder[inorderIndex - 1];
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
