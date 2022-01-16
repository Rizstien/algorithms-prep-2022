package mergeksortedlists;

import java.util.ArrayList;

class ListNode {
	 public int val;
	 public ListNode next;
	 ListNode(int x) { val = x; next = null; }
}

public class MergeKSortedLists {
	
	public ListNode mergeKLists(ArrayList<ListNode> a) {
        ArrayList<Integer> A = new ArrayList<Integer>();
        ListNode result = null;
        ListNode head = null;
        for(int i=0;i<a.size();i++){
            ListNode node = a.get(i);
            while(node!=null){
                A.add(node.val);
                node=node.next;
            }
        }
        A = sort(A);

        result = new ListNode(A.get(0));
        head = result;

        for(int i=1; i<A.size(); i++){
            result.next = new ListNode(A.get(i));
            result = result.next;
        }

        return head;
	}

    public ArrayList<Integer> sort(ArrayList<Integer> A){
        int n = A.size();

        for(int i = n/2-1;i>=0;i--){
            heapify(A,n,i);
        }

        for(int i=n-1; i>=0;i--){
            int temp = A.get(0);
            A.set(0,A.get(i));
            A.set(i,temp);
            heapify(A,i,0);
        }

        return A;
    }

    public void heapify(ArrayList<Integer> A, int n, int i){
        int largest = i;
        int left_child = 2*i+1;
        int right_child = 2*i+2;

        if(left_child<n && A.get(left_child)>A.get(largest))
            largest = left_child;

        if(right_child<n && A.get(right_child)>A.get(largest))
            largest = right_child;

        if(largest!=i){
            int temp = A.get(i);
            A.set(i,A.get(largest));
            A.set(largest,temp);
            heapify(A,n,largest);
        }
    }

	public static void main(String[] args) {
		ArrayList<ListNode> A = new ArrayList<ListNode>();
		ListNode nodeA = new ListNode(1);
		nodeA.next = new ListNode(10);
		nodeA.next.next = new ListNode(20);
		A.add(nodeA);
		
		nodeA = new ListNode(4);
		nodeA.next = new ListNode(11);
		nodeA.next.next = new ListNode(13);
		A.add(nodeA);
		
		nodeA = new ListNode(3);
		nodeA.next = new ListNode(8);
		nodeA.next.next = new ListNode(9);
		A.add(nodeA);

		
		MergeKSortedLists obj = new MergeKSortedLists();
		ListNode result = obj.mergeKLists(A);
		while(result!=null){
			System.out.print(result.val+"->");
			result = result.next;
		}
		System.out.print("null");
	}

}
