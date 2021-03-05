import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// Tournament winner
public class SortLinkedList {
    public static void main(String[] args) {

        LinkedList input = new LinkedList(1);
        addMany(input, new ArrayList<Integer>(Arrays.asList(1, 3, 4, 4, 4, 5, 6, 6)));
        LinkedList output = removeDuplicatesFromLinkedList(input);
    }

    public static LinkedList addMany(LinkedList ll, List<Integer> values) {
        LinkedList current = ll;
        while (current.next != null) {
            current = current.next;
        }
        for (int value : values) {
            current.next = new LinkedList(value);
            current = current.next;
        }
        return ll;
    }

    // 1, 1, 1, 3, 4, 4, 4, 5, 6, 6

    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static LinkedList removeDuplicatesFromLinkedList(LinkedList linkedList) {
        LinkedList temp = null;
        LinkedList top = linkedList;
        while (linkedList.next != null) {
            temp = linkedList;
            while (temp.next!=null && temp.value == temp.next.value)
            {
                temp = temp.next;
            }

            linkedList.next = temp.next;
            if (linkedList.next!=null)
            linkedList = linkedList.next;

        }
        return top;
    }
}
