package palindromelist;

class ListNode {
    public int val;
    public ListNode next;
    ListNode(int x) { val = x; next = null; }
}


public class PalindromeList {

    public static void main(String[] args) {
        ListNode nodeA = new ListNode(1);
        nodeA.next = new ListNode(1);
        nodeA.next.next = new ListNode(6);
        nodeA.next.next.next = new ListNode(4);
        nodeA.next.next.next.next = new ListNode(1);

        PalindromeList obj = new PalindromeList();
        System.out.println(obj.lPalin(nodeA));
    }


    public int lPalin(ListNode A) {
        if(A==null) return 0;
        ListNode headA = copy(A);
        ListNode revA = reverseList(A);
        while(headA!=null){
            if(headA.val!=revA.val) return 0;
            headA=headA.next;
            revA=revA.next;
        }
        return 1;
    }

    public ListNode copy(ListNode A){
        ListNode copy = null, head = null;
        while(A!=null){
            if(copy==null) {
                copy = new ListNode(A.val);
                head = copy;
                A = A.next;
            }else {
                copy.next = new ListNode(A.val);
                copy = copy.next;
                A = A.next;
            }
        }

        return head;
    }

    public ListNode reverseList(ListNode A){
        ListNode prev = null;
        ListNode next = null;
        ListNode curr = A;
        return reverseList(curr, next, prev);
    }

    public ListNode reverseList(ListNode curr, ListNode next, ListNode prev) {
        if(curr==null) return prev;
        else{
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return reverseList(curr, next, prev);
    }

}
