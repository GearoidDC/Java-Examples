package linktest;

public class LinkedNodes {

    // Initialize head and tail of the linked list
    private Node head = null;
    private Node tail = null;

    // Adds a new node to the linkedList
    public void addNode(int data) {

        // Create a new node
        Node newNode = new Node(data);

        // Checks if the list is empty
        if (isEmpty()) {
            // If list is empty head and tail are the same
            head = newNode;
        } else {
            // The new node is added after the tail
            tail.next = newNode;
            // Set the tail as the newNode
        }
        tail = newNode;
    }

    public void addNodeAt(int data, int index) {

        // Create a new node
        Node newNode = new Node(data);

        int i = 1;
        int size = size();
        if (size < index || index < 0) {
            System.out.println("Your index " + index + " is out of bounds");
        } else {
            if (index == 0) {
                newNode.next = head;
                head = newNode;
            } else {
                Node current = head.next;
                Node prev = head;
                while (i != index) {
                    prev = current;
                    current = current.next;
                    i++;
                }
                prev.next = newNode;
                newNode.next = current;
            }

        }

    }

    // Returns the number of nodes in the linkedList
    public int size() {
        int size = 0;
        Node current = head;

        // Adds one to count until we get past the last node
        while (current != null) {
            size++;
            current = current.next;
        }
        return size;
    }

    // Remove node with given value
    public void removeValueNode(int data) {

        // Sets ups of a head and trailing node
        Node current = head, prev = current;
        // If head node is the select node set the head node to next node
        if (current != null && current.data == data) {
            head = null;
            head = current.next;
        } else {
            // Move through Nodes until list ends or the data is found
            while (current != null && current.data != data) {
                prev = current;
                current = current.next;
            }
            if (current != null) {
                // Unlink the node
                prev.next = current.next;
            } else {
                System.out.println("No such value exists");
            }

        }
    }

    // Removes a node at select index
    public void removeNodeAt(int index) {
        Node current = head, prev = current;
        int i = 1;
        if (current != null && index == 0) {
            head = null;
            head = current.next;
        } else {
            current = current.next;
            // Move through Nodes until list ends or the index is reached
            while (current != null && i != index) {
                prev = current;
                current = current.next;
                i++;
            }
            if (current != null) {
                // Unlink the node
                prev.next = current.next;
            } else {
                System.out.println("No such value exists");
            }
        }

    }

    // Print out the average value of the nodes
    public void averageNode() {
        int total = 0;
        if (isEmpty()) {
            System.out.println("Average: " + total);
        } else {
            Node current = head;
            while (current != null) {
                total += current.data;
                current = current.next;
            }
            System.out.println("Average: " + (total / size()));
        }


    }

    // Return if the linked list is empty or not
    public boolean isEmpty() {
        return head == null;
    }

    // Print out the list of nodes
    public void display() {

        Node current = head;

        if (head == null) {
            System.out.println("List is empty");
        } else {
            // Print ouf each of the nodes in the Linked list.
            System.out.println("Nodes of linked list: ");
            while (current != null) {
                System.out.print(current.data + " ");
                current = current.next;
            }
            System.out.println();
        }
    }
}