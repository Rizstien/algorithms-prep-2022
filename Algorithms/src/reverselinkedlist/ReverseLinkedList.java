package reverselinkedlist;

class ListNode {
	public int val;
	public ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}

public class ReverseLinkedList {

	public ListNode reverseList(ListNode A) {
        ListNode next = null;
        ListNode prev = null;
        ListNode curr = A;
        return reverseList(curr, next, prev);
    }

    public ListNode reverseList(ListNode curr, ListNode next, ListNode prev) {
        if(curr == null) return prev;
        else{
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next; 
        }

        return reverseList(curr, next, prev);
    }
    	
	public static void main(String[] args) {
		ListNode nodeA = new ListNode(1);
		nodeA.next = new ListNode(2);
		nodeA.next.next = new ListNode(8);
		nodeA.next.next.next = new ListNode(9);
		nodeA.next.next.next.next = new ListNode(7);
		
		ReverseLinkedList obj = new ReverseLinkedList();
		ListNode result = obj.reverseList(nodeA);
		
		while(result!=null) {
			System.out.print(result.val+"->");
			result = result.next;
		}
		System.out.print("null");

	}

}
