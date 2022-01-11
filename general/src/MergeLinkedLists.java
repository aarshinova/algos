public class MergeLinkedLists {
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

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result = new ListNode(0);
        ListNode curr = result;

        while(list1!=null || list2!=null){
            if ((list1!=null && list2!=null && list1.val<list2.val) || (list1!=null && list2==null)) {
                curr.next = new ListNode(list1.val);
                list1 = list1.next;
                curr = curr.next;
                continue;
            }

            if ((list1!=null && list2!=null && list2.val<list1.val) || (list2!=null && list1==null)){
                curr.next = new ListNode(list2.val);
                list2 = list2.next;
                curr = curr.next;
                continue;
            }

            if (list1!=null && list2!=null && list1.val==list2.val){
                curr.next = new ListNode(list2.val);
                curr = curr.next;
                curr.next = new ListNode(list1.val);
                list2 = list2.next;
                list1 = list1.next;
                curr = curr.next;
            }
        }

        return result.next;
    }
}
