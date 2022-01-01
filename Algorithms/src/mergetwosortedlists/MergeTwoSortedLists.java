package mergetwosortedlists;

class ListNode {
	public int val;
	public ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}

public class MergeTwoSortedLists {

	public ListNode mergeTwoLists(ListNode A, ListNode B) {
        ListNode result = null, resultHead = null;
    
        while(A!=null && B!=null){
            if(A.val<=B.val){
                if(result==null){
                    result = new ListNode(A.val);
                    resultHead = result;
                }else{
                    result.next = new ListNode(A.val);
                    result = result.next;
                }
                A = A.next;
            }else{
                if(result==null){
                    result = new ListNode(B.val);
                    resultHead = result;
                }else{
                    result.next = new ListNode(B.val);
                    result = result.next;
                }
                B = B.next;
            }
        }

        if(A==null && B!=null){
            result.next = B;
        }else if(B==null && A!=null){
            result.next = A;
        }

        return resultHead;
    }
	
	
	public static void main(String[] args) {
		ListNode nodeA = new ListNode(5);
		nodeA.next = new ListNode(8);
		nodeA.next.next = new ListNode(20);
		
		ListNode nodeB = new ListNode(4);
		nodeB.next = new ListNode(11);
		nodeB.next.next = new ListNode(15);
		
		MergeTwoSortedLists obj = new MergeTwoSortedLists();
		ListNode result = obj.mergeTwoLists(nodeA, nodeB);
		
		while(result!=null) {
			System.out.print(result.val+"->");
			result = result.next;
		}
		System.out.print("null");

	}

}
