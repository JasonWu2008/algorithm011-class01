import java.util.ArrayList;
import java.util.List;

public class NO77CombineNumbers {
    public static void main(String[] args) {
        int n = 9;
        int k = 4;

        new NO77CombineNumbers().combine(n, k);
    }

    private List<List<Integer>> combine(int n, int k) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.deep = 0;
        putOnTree(treeNode, n, k);
        ArrayList<List<Integer>> results = new ArrayList<>();
        return results;
    }

    //n:1-9,k:4
    //每一层最大子节点值为：max_children_value = n-k+1+deep
    private void putOnTree(TreeNode parentNode, int n, int k) {
        TreeNode lastChild = parentNode.lastChild();
        if (parentNode.getParent() == null && parentNode.getDeep() == k - 1 && lastChild != null && lastChild.getVal() == n) {
            return;
        }
        if (lastChild == null) {
            parentNode.setDeep(parentNode.getDeep() + 1);
            TreeNode current = new TreeNode(parentNode.getVal() + 1);
            current.setDeep(parentNode.getDeep());
            parentNode.getChildren().add(current);
            current.setParent(parentNode);
            if (parentNode.getDeep() == k - 1) {//p:3,c:4
                putOnTree(parentNode, n, k);
            } else {
                putOnTree(current, n, k);//p:1,2,c:2,3
            }
        } else {
            if (lastChild.getVal() == n - k + 1 + parentNode.getDeep()) {//当前节点是最后一个元素，则回溯"父节点的父节点"//deep=3，last=9
                if (parentNode.getParent() != null) {//父元素不是根节点，则回溯父节点的父节点
                    putOnTree(parentNode.getParent(), n, k);
                }
            } else {
                TreeNode current = new TreeNode(lastChild.getVal() + 1);//{p:3, c:4,5,6,7,8}, {p:2,p.last:3,c:4}
                current.setDeep(parentNode.getDeep());
                parentNode.getChildren().add(current);
                current.setParent(parentNode);
                if (parentNode.getDeep() == k - 1) {//p:3,c:4
                    putOnTree(parentNode, n, k);
                } else {
                    putOnTree(current, n, k);//p:1,2,c:2,3
                }
            }
        }
    }

    public class TreeNode {
        int val;
        int deep;
        TreeNode parent;
        List<TreeNode> children = new ArrayList<>();

        void setVal(int val) {
            this.val = val;
        }

        List<TreeNode> getChildren() {
            return children;
        }

        int getDeep() {
            return deep;
        }

        void setDeep(int deep) {
            this.deep = deep;
        }

        int getVal() {
            return val;
        }

        TreeNode getParent() {
            return parent;
        }

        void setParent(TreeNode parent) {
            this.parent = parent;
        }

        private TreeNode lastChild() {
            if (children.isEmpty()) {
                return null;
            }
            return children.get(children.size() - 1);
        }

        TreeNode(int x) {
            val = x;
        }
    }
}
