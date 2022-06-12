package convertsortedlisttobinarysearchtree;

import java.util.LinkedList;

public class ConvertSortedListToBinarySearchTree {
	
public LinkedList<Integer> nodes = new LinkedList<Integer>();
    
	public TreeNode sortedListToBST(ListNode a) {
            
        ListNode node = a;
        
        while(node!=null){
            nodes.add(node.val);
            node = node.next;
        }
        
        return buildTree(0, nodes.size()-1);
	}
    
    public TreeNode buildTree(int start, int end){
        if(start>end) return null;
        
        if(start==end) return new TreeNode(nodes.get(start));
        
        int mid = (start+end)/2;
        
        TreeNode node = new TreeNode(nodes.get(mid));
        
        node.left = buildTree(start, mid-1);
        node.right = buildTree(mid+1, end);
        
        return node;
    }

	public static void main(String[] args) {
		ListNode nodeA = new ListNode(1);
		nodeA.next = new ListNode(2);
		nodeA.next.next = new ListNode(3);
		nodeA.next.next.next = new ListNode(4);
		nodeA.next.next.next.next = new ListNode(5);
		nodeA.next.next.next.next.next = new ListNode(6);
		
		ConvertSortedListToBinarySearchTree obj = new ConvertSortedListToBinarySearchTree();
		TreeNode treeNode = obj.sortedListToBST(nodeA);
		
		System.out.print(treeNode.val);

	}

}


class TreeNode {
	int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode(int x) {
    	val = x;
    	left=null;
    	right=null;
    }
}

class ListNode {
	public int val;
	public ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}
