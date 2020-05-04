package linktest;

public class LinkedListTest {

    public static void main(String[] args) {

        LinkedNodes nodeList = new LinkedNodes();

        // Add nodes to the list
        nodeList.addNode(1);
        nodeList.addNode(2);
        nodeList.addNode(3);
        nodeList.addNode(4);

        // Add a node at a point
        nodeList.addNodeAt(6, -1);
        nodeList.addNodeAt(7, 3);

        // Display the value of the nodes in a list
        nodeList.display();

        // Remove the first node of a certain value
        nodeList.removeValueNode(3);

        // Remove a node at a select index
        nodeList.removeNodeAt(0);

        // Display the value of the nodes in a list
        nodeList.display();

        // Get average of nodes
        nodeList.averageNode();

        // Prints out whether or not the list is empty
        System.out.println("Is this Linked list empty?: " + nodeList.isEmpty());

        // Prints out the size of the list
        System.out.println("Size of list: " + nodeList.size());
    }
}
