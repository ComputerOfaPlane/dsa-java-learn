// Node class representing each element of the linked list
class Node {
    int data;       // Stores the data
    Node next;      // Reference to the next node

    // Constructor to initialize a node
    Node(int val, Node n) {
        this.data = val;
        this.next = n;
    }
}

class Main {
    public static void main(String[] args) {
        // Sample array to convert into a linked list
        int arr[] = {99, 44, 91, 23, 40, 70, 14, 58, 68, 51, 5, 47, 93, 4, 22};
        
        // Convert array to linked list
        Node start = convertToList(arr);
        print(start); // Print original list

        // Delete element at index 0 (head of the list)
        start = delete(start, 0);
        print(start); // Print list after deletion

        // Insert value 23 at index 14
        start = insert(start, 14, 23);
        print(start); // Print list after insertion
    }

    // Converts an array into a singly linked list and returns the head node
    static Node convertToList(int arr[]) {
        // Initialize the head with the first element
        Node start = new Node(arr[0], null);
        Node temp = start;

        // Loop through the rest of the array and create new nodes
        for (int i = 1; i < arr.length; i++) {
            Node newnode = new Node(arr[i], null); // New node with value
            temp.next = newnode; // Link previous node to the new one
            temp = newnode; // Move temp to the new last node
        }
        return start; // Return head of the list
    }

    // Inserts a new node with given value at specified index
    static Node insert(Node head, int index, int value) {
        // Special case: inserting at the head
        if (index == 0) {
            return new Node(value, head);
        }

        Node temp = head;

        // Traverse to the node just before the insertion point
        for (int i = 0; i < index - 1; i++) {
            if (temp == null) return head; // If index is out of bounds, return unchanged
            temp = temp.next;
        }

        if (temp == null) return head; // If list ends before reaching index

        // Create new node and adjust links
        Node newnode = new Node(value, temp.next);
        temp.next = newnode;

        return head; // Return head of the updated list
    }

    // Deletes the node at a given index and returns the (possibly new) head
    static Node delete(Node head, int index) {
        // Empty list case
        if (head == null) return head;

        // Special case: deleting the head node
        if (index == 0) return head.next;

        Node temp = head;

        // Traverse to the node just before the one to delete
        for (int i = 0; i < index - 1; i++) {
            if (temp == null || temp.next == null) return head; // Index out of bounds
            temp = temp.next;
        }

        // Remove the node by skipping it
        if (temp.next != null) {
            temp.next = temp.next.next;
        }

        return head; // Return head of the updated list
    }

    // Prints the linked list in readable format
    static void print(Node head) {
        // Handle empty list
        if (head == null) {
            System.out.println("empty list");
            return;
        }

        Node temp = head;
        // Traverse and print all nodes
        while (temp != null) {
            System.out.print(temp.data); // Print current node's data
            if (temp.next != null) System.out.print("->"); // Arrow if not the last node
            temp = temp.next; // Move to next node
        }
        System.out.println(); // New line after printing the list
    }
}
