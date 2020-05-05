
import java.util.Iterator;

// An Interface gives requirements for a class that implements it
public interface Tree<E> {

    // Basics a tree should be able to implement

    // Add a node with given object to the tree
    void add(E obj);

    // Check if the tree contains the passed object
    boolean contains(E obj);

    // Remove a Node with the value of the passed object
    void remove(E obj);

    // Return an Iterator for the tree
    Iterator<E> iterator();

    Iterator<E> postIterator();
}