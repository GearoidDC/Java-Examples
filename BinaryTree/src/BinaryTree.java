
import java.util.Stack;
import java.util.Iterator;

// Uses comparable for nodes and
public class BinaryTree<E extends Comparable<E>> implements Tree<E> {

    // First node in the tree
    private TreeNode<E> root;

    // Makes an empty tree
    public BinaryTree() {
        root = null;
    }

    // Adds a object to the tree
    public void add(E obj) {
        // If the root is null we add the node there
        if (root == null) {
            root = new TreeNode<>(obj, null, null);
        } else {
            root.insert(obj);
        }
    }

    // Checks if the tree contains the object passed
    public boolean contains(E obj) {
        // if the tree is empty
        if (root == null) {
            return false;
        } else {
            return (root.find(obj) != null);
        }
    }

    // Removes the first node it finds which matches the value given
    @Override
    public void remove(E obj) {
        if (root != null) {
            root = root.remove(obj, root);
        }
    }

    // Iterates through the tree in ascending order
    private class PreOrderIterator implements Iterator<E> {
        private Stack<TreeNode<E>> nodes = new Stack<>();

        // Makes an iterator for the current tree
        public PreOrderIterator() {
            pushLeft(root);
        }

        // Returns the next node value in the tree or null if it is empty
        public E next() {
            if (nodes.isEmpty()) {
                return null;
            }
            TreeNode<E> node = nodes.pop();
            pushLeft(node.right);
            return node.val;
        }

        // Checks if there is another object in the current stack
        public boolean hasNext() {
            return !nodes.isEmpty();
        }

        // Throws an exception Iterator.remove() method is used
        public void remove() {
            throw new UnsupportedOperationException();
        }

        // Pushes nodes on to the stack
        private void pushLeft(TreeNode<E> node) {
            while (node != null) {
                nodes.push(node);
                node = node.left;
            }
        }
    }
    // Iterates through the tree in ascending order
    private class PostOrderIterator implements Iterator<E> {
        private Stack<TreeNode<E>> nodes = new Stack<>();

        // Makes an iterator for the current tree
        public PostOrderIterator() {
            pushRight(root);
        }

        // Returns the next node value in the tree or null if it is empty
        public E next() {
            if (nodes.isEmpty()) {
                return null;
            }
            TreeNode<E> node = nodes.pop();
            pushRight(node.left);
            return node.val;
        }

        // Checks if there is another object in the current stack
        public boolean hasNext() {
            return !nodes.isEmpty();
        }

        // Throws an exception Iterator.remove() method is used
        public void remove() {
            throw new UnsupportedOperationException();
        }

        // Pushes nodes on to the stack
        private void pushRight(TreeNode<E> node) {
            while (node != null) {
                nodes.push(node);
                node = node.right;
            }
        }
    }

    // Returns an iterator object for a tree
    public Iterator<E> iterator() {
        return new PreOrderIterator();
    }

    public Iterator<E> postIterator(){
        return new PostOrderIterator();
    }
}