// This class sets up the nodes for the tree
public class TreeNode<T extends Comparable<T>> implements Comparable<TreeNode<T>>{
    // value of node
    public T val;

    // Each node has a left and right node
    public TreeNode<T> left, right;

    // Constructor for Tree nodes
    public TreeNode(T val, TreeNode<T> left, TreeNode<T> right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    // Adds object to the tree
    public void insert(T obj) {
        // Uses the compareTo method to check if the value should go left or right
        if (val.compareTo(obj) < 0) {
            // If the node right is not empty call the method again
            if (right != null) {
                right.insert(obj);
            }
            // Else set the right node of the current tree as the new node
            else {
                right = new TreeNode<>(obj, null, null);
            }
        } else {
            if (left != null) {
                left.insert(obj);
            } else {
                left = new TreeNode<>(obj, null, null);
            }
        }
    }

    // Searches the tree for a node with value equal to the given value
    public TreeNode<T> find(T obj) {
        int temp = val.compareTo(obj);
        if (temp == 0) {
            return this;
        }
        if (temp < 0) {
            return (right == null) ? null : right.find(obj);
        }
        return (left == null) ? null : left.find(obj);
    }

    // Removes the node with the value given and moves the child nodes
    public TreeNode<T> remove(T obj, TreeNode<T> temp) {
        if (temp == null) {
            return null;
        }
        if (obj.compareTo(temp.val) < 0) {
            temp.left = remove(obj, temp.left);
        } else if (obj.compareTo(temp.val) > 0) {
            temp.right = remove(obj, temp.right);
        } else if (temp.left != null && temp.right != null) {
            temp.val = findMin(temp.right).val;
            temp.right = remove(temp.val, temp.right);
        } else {
            temp = (temp.left != null) ? temp.left : temp.right;
        }
        return temp;
    }

    // Returns the most left node value in a subtree
    private TreeNode<T> findMin(TreeNode<T> temp) {
        if (temp == null) {
            return null;
        } else if (temp.left == null) {
            return temp;
        }
        return findMin(temp.left);
    }
    // hmm
    @Override
    public int compareTo(TreeNode<T> node){
        return this.val.compareTo(node.val);
    }
}