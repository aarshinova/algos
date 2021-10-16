import java.util.ArrayList;
import java.util.List;

public class SumLinkedLists {

    public static void main(String[] args) {

        LinkedList ll1 = addMany(new LinkedList(2), new int[]{4, 7, 1});
        LinkedList ll2 = addMany(new LinkedList(9), new int[]{4, 5});
        sumOfLinkedLists(ll1, ll2);
    }

    public static LinkedList addMany(LinkedList linkedList, int[] values) {
        var current = linkedList;
        while (current.next != null) {
            current = current.next;
        }
        for (var value : values) {
            current.next = new LinkedList(value);
            current = current.next;
        }
        return linkedList;
    }

    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static LinkedList sumOfLinkedLists(LinkedList linkedListOne, LinkedList linkedListTwo) {
        LinkedList result = null;
        int carryOver = 0;
        LinkedList current = null;
        while (linkedListOne != null && linkedListTwo != null) {
            int sum = linkedListOne.value + linkedListTwo.value + carryOver;
            int value = 0;
            if (sum >= 10) {
                value = (sum - 10);
                carryOver = 1;
            } else {
                value = sum;
                carryOver = 0;
            }
            linkedListOne = linkedListOne.next;
            linkedListTwo = linkedListTwo.next;
            if (result == null) {
                result = new LinkedList(value);
                current = result;
            } else {
                current.next = new LinkedList(value);
                current = current.next;
            }
        }
        if (linkedListOne == null && linkedListTwo != null) {
            carryOver = getLinkedList(linkedListTwo, current, carryOver);
        } else if (linkedListOne != null && linkedListTwo == null) {
            carryOver = getLinkedList(linkedListOne, current, carryOver);
        }

        if (carryOver>0){
            current.next = new LinkedList(carryOver);
        }

        return result;
    }

    private static int getLinkedList(LinkedList list, LinkedList result, int carryOver) {
        while (list != null) {
            int sum = list.value;
            int value = 0;
            if (sum > 10) {
                value = (sum - 10) + carryOver;
                carryOver = 1;
            } else {
                value = sum + carryOver;
                carryOver = 0;
            }
            if (result == null) {
                result = new LinkedList(value);
            } else {
                result.next = new LinkedList(value);
                result = result.next;
            }
            list = list.next;
        }
        return carryOver;
    }

}
