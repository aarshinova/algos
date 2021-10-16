import java.util.ArrayList;
import java.util.List;

public class FindKElementLinkedList {
    public static void main(String[] args) {

        TestLinkedList test = new TestLinkedList(0);
        test.addMany(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        //int[] expected = {0, 1, 2, 3, 4, 5, 7, 8, 9};
        removeKthNodeFromEnd(test, 10);
        print(test);
    }

    private static void print(LinkedList test) {
        while (test != null) {
            System.out.print(test.value + " -> ");
            test = test.next;
        }
    }

    public static void removeKthNodeFromEnd(LinkedList head, int k) {
        System.out.println("head value now " + head.value);
        int length = calculLength(head);
        int counter = length - k - 1;
        while (counter > 0 && head!=null) {
            head = head.next;
            counter--;
        }
        System.out.println("Counter now " + counter);
        if (counter == 0) {
           System.out.println("val now " + head.value);
            System.out.println("val next " + head.next.value);
            System.out.println("to be replaced by " + head.next.next.value);

            head.next = head.next.next;
            System.out.println("val now " + head.next.value);

        }else if (counter<0){
            head.value = head.next.value;
            head.next = head.next.next;
        }
    }

    private static int calculLength(LinkedList head) {
        int len = 0;

        while (head != null) {
            head = head.next;
            len++;
        }
        System.out.println("Len " + len);
        return len;
    }

    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }

    static class TestLinkedList extends LinkedList {

        public TestLinkedList(int value) {
            super(value);
        }

        public void addMany(int[] values) {
            LinkedList current = this;
            while (current.next != null) {
                current = current.next;
            }
            for (int value : values) {
                current.next = new LinkedList(value);
                current = current.next;
            }
        }

        public List<Integer> getNodesInArray() {
            List<Integer> nodes = new ArrayList<Integer>();
            LinkedList current = this;
            while (current != null) {
                nodes.add(current.value);
                current = current.next;
            }
            return nodes;
        }
    }


}
