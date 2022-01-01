package kreverselinkedlist;

class ListNode {
	public int val;
	public ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}

public class KReverseLinkedList {
	
    public ListNode reverseList(ListNode A, int B) {
    	if(A==null || A.next==null) return A;
    	ListNode prev=null, next=A, head = A;
    	int i=0;
    	while(i++<B && next!=null) {
    		next = A.next;
    		A.next = prev;
    		prev = A;
    		A = next;
    	}
    	head.next = reverseList(next, B);
    	return prev;
    }

	public static void main(String[] args) {
		ListNode nodeA = new ListNode(1);
		nodeA.next = new ListNode(2);
		nodeA.next.next = new ListNode(3);
		nodeA.next.next.next = new ListNode(4);
		nodeA.next.next.next.next = new ListNode(5);
		nodeA.next.next.next.next.next = new ListNode(6);
		
		KReverseLinkedList obj = new KReverseLinkedList();
		ListNode result = obj.reverseList(nodeA, 2);
		
		while(result!=null) {
			System.out.print(result.val+"->");
			result = result.next;
		}
		System.out.print("null");
	}

}
