import java.util.Iterator;

public class BinaryTreeTest {

    public static void main(String[] args) {

        // Showing it can use any object type
        Tree<String> treeOfStrings;
        Tree<Integer> one;
        Tree<Integer> several;


        treeOfStrings = new BinaryTree<>();
        one = new BinaryTree<>();
        one.add(0);
        several = new BinaryTree<>();
        several.add(5);
        several.add(2);
        several.add(1);
        several.add(9);
        several.add(8);
        several.add(10);
        several.remove(10);
        treeOfStrings.add("Hey");
        treeOfStrings.add("works?");
        Iterator<Integer> iterator = several.iterator();
        Iterator<Integer> postIterator = several.postIterator();
        System.out.println("Ascending");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("Descending");
        while (postIterator.hasNext()) {
            System.out.println(postIterator.next());
        }
        System.out.println(several.contains(5));
        System.out.println(treeOfStrings.contains("Hey"));
    }

}