package sortbinarylinkedlist;

class ListNode {
	public int val;
	public ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}

public class SortBinaryLinkedList {
	
	public ListNode solve(ListNode A) {

        if(A==null) return null;
        ListNode result0 = null, result1 = null;
        ListNode result0Head = null, result1Head = null;
        while(A!=null){
            if(A.val==0){
                if(result0==null) {
                    result0 = new ListNode(0);
                    result0Head = result0;
                }else {
                    result0.next = new ListNode(0);
                    result0 = result0.next;
                }
            }else{
                if(result1==null) {
                    result1 = new ListNode(1);
                    result1Head = result1;
                }else {
                    result1.next = new ListNode(1);
                    result1 = result1.next;
                }
            }
            A=A.next;
        }

        if(result0!=null) result0.next = result1Head;
        else return result1Head;
        return result0Head;
    }

	public static void main(String[] args) {
		ListNode nodeA = new ListNode(0);
		nodeA.next = new ListNode(0);
		nodeA.next.next = new ListNode(1);
		nodeA.next.next.next = new ListNode(1);
		nodeA.next.next.next.next = new ListNode(0);
		
		SortBinaryLinkedList obj = new SortBinaryLinkedList();
		ListNode result = obj.solve(nodeA);
		
		while(result!=null) {
			System.out.print(result.val+"->");
			result = result.next;
		}
		System.out.print("null");
	}

}
