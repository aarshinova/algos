public class AddTwoNumbersLinkedList {
    public static void main(String[] args) {

        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4, null);
        l1.next.next = new ListNode(3, null);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6, null);
        l2.next.next = new ListNode(4, null);

        System.out.println("Answer " + addTwoNumbers(l1, l2));
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = 0;
        int carryOn = 0;
        int val1 = 0;
        int val2 = 0;
        ListNode result = new ListNode(0);
        ListNode tmp = result;

        while (l1 != null || l2 != null) {
            sum = 0;

            if (l1 != null) {
                sum += l1.val;
            }
            if (l2 != null) {
                sum += l2.val;
            }

            sum += carryOn;
            carryOn = (sum >= 10) ? 1 : 0;
            sum = (carryOn > 0) ? sum - 10 : sum;

            tmp.next = new ListNode(sum);

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }

            tmp = tmp.next;
        }

        if (carryOn > 0) {
            tmp.next = new ListNode(carryOn);
        }

        return result.next;

    }
}
