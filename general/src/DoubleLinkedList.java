import java.util.*;

// Feel free to add new properties and methods to the class.
class Program {
    static class DoublyLinkedList {
        public Node head;
        public Node tail;

        public void setHead(Node node) {
            if (node == null){
                return;
            }
            if (this.head==null){
                this.head = node;
                this.tail = node;
                return;
            }
            insertBefore(head, node);
        }

        public void setTail(Node node) {
            if (this.tail==null){
                setHead(node);
            }
            insertAfter(tail, node);
        }


    public void insertBefore(Node node, Node nodeToInsert) {
        if (nodeToInsert == head || nodeToInsert == tail) {
            return;
        }
        remove(nodeToInsert);
        Node tmp = node.prev;
        node.prev = nodeToInsert;
        if (tmp != null) {
            nodeToInsert.prev = tmp;
            node.prev.next = nodeToInsert;
        } else {
            this.head = nodeToInsert;
        }
        nodeToInsert.next = node;
    }

    public void insertAfter(Node node, Node nodeToInsert) {
        if (nodeToInsert == head || nodeToInsert == tail) {
            return;
        }
        remove(nodeToInsert);
        Node tmp = node.next;
        node.next = nodeToInsert;
        nodeToInsert.next = tmp;
        nodeToInsert.prev = node;
        tmp.prev = nodeToInsert;
        if (node.next == null){
            this.tail = nodeToInsert;
        }
    }

    public void insertAtPosition(int position, Node nodeToInsert) {
        if (position==1){
            setHead(nodeToInsert);
        }
        Node node = head;
        int currentPos = 1;
        while (node!=null && currentPos++!=position){
            node = node.next;
        }
        if(node!=null){
            insertBefore(node, nodeToInsert);
        }else {
            setTail(nodeToInsert);
        }
    }

    public void removeNodesWithValue(int value) {
        Node node = head;
        while (node!=null){
            Node nodeToRemove = node;
            node = node.next;
            if (nodeToRemove.value == value) remove(nodeToRemove);
        }
    }

    public void remove(Node node) {
        if (node == head) head = head.next;
        if (node == tail) tail = tail.prev;
        removeNodeBindings(node);
    }

    public boolean containsNodeWithValue(int value) {
        Node node = head;
        while (node!=null && node.value!=value) node = node.next;
        return node!=null;
    }

    public void removeNodeBindings(Node node){
        if (node.prev!=null) node.prev.next = node.next;
        if (node.next!=null) node.next.prev = node.prev;
        node.prev = null;
        node.next = null;
    }
}

// Do not edit the class below.
static class Node {
    public int value;
    public Node prev;
    public Node next;

    public Node(int value) {
        this.value = value;
    }
}
}
