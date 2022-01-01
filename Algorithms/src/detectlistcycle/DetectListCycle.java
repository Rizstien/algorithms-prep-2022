package detectlistcycle;

class ListNode {
	public int val;
	public ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}

public class DetectListCycle {
	
	public ListNode detectCycle(ListNode a) {
		ListNode slow = a;
		ListNode fast = a;
		
        do{
            slow = slow.next;
            if(fast.next==null || fast.next.next==null) return null;
            fast = fast.next.next;
        }while(slow!=fast);
        
        slow = a;
        while(slow!=fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
	}

	public static void main(String[] args) {
		ListNode nodeA = new ListNode(1);
		nodeA.next = new ListNode(2);
		nodeA.next.next = new ListNode(3);
		nodeA.next.next.next = new ListNode(4);
		nodeA.next.next.next.next = new ListNode(5);
		nodeA.next.next.next.next.next = new ListNode(6);
		nodeA.next.next.next.next.next.next = nodeA.next.next;
		
		DetectListCycle obj = new DetectListCycle();
		ListNode result = obj.detectCycle(nodeA);
		
		System.out.print(result.val);
	}

}
