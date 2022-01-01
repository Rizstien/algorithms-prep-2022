package intersectionoflinkedlists;

class ListNode {
	public int val;
	public ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}

public class IntersectionOfLinkedLists {

	public ListNode getIntersectionNode(ListNode a, ListNode b) {

		if (a == null || b == null)
			return null;
		
		ListNode tmp = a;

		int lenA = len(tmp);
		tmp = b;
		int lenB = len(tmp);
		int diff = 0;
		if (lenA > lenB) {
			diff = lenA - lenB;
			for (int i = 0; i < diff; i++) {
				a = a.next;
			}
		} else {
			diff = lenB - lenA;
			for (int i = 0; i < diff; i++) {
				b = b.next;
			}
		}

		while (a != null) {
			if (a.val == b.val)
				return a;
			a = a.next;
			b = b.next;
		}

		return null;
	}

	int len(ListNode node) {
		int len = 0;

		while (node != null) {
			len++;
			node = node.next;
		}

		return len;

	}
	  
	public static void main(String[] args) {
		ListNode nodeA = new ListNode(1);
		nodeA.next = new ListNode(2);
		nodeA.next.next = new ListNode(8);
		nodeA.next.next.next = new ListNode(9);
		nodeA.next.next.next.next = new ListNode(7);
		
		ListNode nodeB = new ListNode(3);
		nodeB.next = new ListNode(4);
		nodeB.next.next = new ListNode(5);
		nodeB.next.next.next = new ListNode(8);
		nodeB.next.next.next.next = new ListNode(9);
		nodeB.next.next.next.next.next = new ListNode(7);
		
		IntersectionOfLinkedLists obj = new IntersectionOfLinkedLists();
		ListNode result = obj.getIntersectionNode(nodeA, nodeB);
		
		while(result!=null) {
			System.out.print(result.val+"->");
			result = result.next;
		}
		System.out.print("null");
	}

}
