public class LinkedList<E> {
    private Node head;
    private int size;

    /** Initialize your data structure here. */
    public LinkedList() {

    }

    // Definition of a node for singly-linked list, it contains a value and a pointer to the next node.
    public class SinglyListNode {
        int val;
        SinglyListNode next;
        SinglyListNode(int x) { val = x; }
    }


    // Complexity of visiting an element at a LinkedList: O(N)
    class Node{
        int val;
        Node next;
        public Node(int val){
            this.val = val;
        }
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index < 0 || index >= size) return -1;
        if(size == 1) return head.val;
        Node curr = head;
        for(int i = 0; i < index; i++){
            curr = curr.next;
        }
        return curr.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index > size) return;
        if(index <= 0) {
            Node prev = head;
            head = new Node(val);
            head.next = prev;
            size++;
        }
        else{
            size++;
            Node curr = head;
            for(int i = 0; i < index - 1; i++){
                curr = curr.next;
            }
            Node node = new Node(val);
            node.next = curr.next;
            curr.next = node;
        }
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) return;
        size--;

        if (index == 0) {
            head = head.next;
            return;
        }

        Node curr = head;
        for(int i = 0; i < index - 1; i++){
            curr = curr.next;
        }
        curr.next = curr.next.next;
    }

}

