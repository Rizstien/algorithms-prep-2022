package reorderlinkedlist;

class ListNode {
	public int val;
	public ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}

public class ReorderLinkedList {
	
    public ListNode reorderList(ListNode A) {
        if(A==null || A.next == null) return A;
        ListNode part1 = A;
        ListNode part1Head = part1;
        ListNode part2 = A;
        int len = len(A);
        for(int i=0;i<len/2;i++) {
        	part2 = part2.next;
        }
        for(int i=0;i<(len/2)-1;i++) {
        	part1 = part1.next;
        }
        part1.next = null;
        part1 = part1Head;
        part2 = reverse(part2);
        
        ListNode result = null;
        ListNode head = result;
        
        while(part1!=null && part2!=null){
            if(result==null) {
            	result = new ListNode(part1.val);
            	result.next = new ListNode(part2.val);
            	head = result;
            	result = result.next;
            }else {
            	result.next = new ListNode(part1.val);
            	result.next.next = new ListNode(part2.val);
            	result = result.next.next;
            }
        	part1 = part1.next;
            part2 = part2.next;
        }

        if(part1!=null) result.next = new ListNode(part1.val);
        else if(part2!=null) result.next = new ListNode(part2.val);

        return head;
    }
	
    public int len(ListNode A){
    	int len = 0;
    	while(A!=null) {
    		A = A.next;
    		len++;
    	}
    	return len;
    }
    
	public ListNode reverse(ListNode A) {
        ListNode next = null;
        ListNode prev = null;
        ListNode curr = A;
        return reverse(curr, next, prev);
    }
    
    public ListNode reverse(ListNode curr, ListNode next, ListNode prev){
        if(curr == null) return prev;
        else{
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return reverse(curr, next, prev);
    }

	public static void main(String[] args) {
		ListNode nodeA = new ListNode(1);
		nodeA.next = new ListNode(2);
		nodeA.next.next = new ListNode(3);
		nodeA.next.next.next = new ListNode(4);
		nodeA.next.next.next.next = new ListNode(5);
		//nodeA.next.next.next.next.next = new ListNode(6);
		
		ReorderLinkedList obj = new ReorderLinkedList();
		ListNode result = obj.reorderList(nodeA);
		
		while(result!=null) {
			System.out.print(result.val+"->");
			result = result.next;
		}
		System.out.print("null");

	}

}
