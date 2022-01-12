package zigzagordertraversal;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

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

public class ZigZagOrderTraversal {
	
	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode A) {
		ArrayList<Integer> local = null;
		ArrayList<ArrayList<Integer>> result  = new ArrayList<ArrayList<Integer>>();
		Deque<TreeNode> deQueue1 = new LinkedList<TreeNode>();
        Deque<TreeNode> deQueue2 = new LinkedList<TreeNode>();
        
        if(A!=null) deQueue1.add(A);
        TreeNode node = null;

        while(!deQueue2.isEmpty() || !deQueue1.isEmpty()) {
        	local = new ArrayList<Integer>();
        	while(!deQueue1.isEmpty()) {
        		node = deQueue1.removeLast();
        		if(node.left!=null) deQueue2.add(node.left);
        		if(node.right!=null) deQueue2.add(node.right);
        		local.add(node.val);
        	}
        	
        	result.add(local);
        	local = new ArrayList<Integer>();
        	
        	while(!deQueue2.isEmpty()) {
        		node = deQueue2.removeLast();
        		if(node.right!=null) deQueue1.add(node.right);
        		if(node.left!=null) deQueue1.add(node.left);
        		local.add(node.val);
        	}
        	
        	result.add(local);
        	
        }
        
        if(result.get(result.size()-1).size()==0) result.remove(result.size()-1);
        return result;
    }

	public static void main(String[] args) {
		TreeNode nodeA = new TreeNode(1);
		nodeA.left = new TreeNode(2);
		nodeA.right = new TreeNode(3);
		nodeA.left.left = new TreeNode(4);
		nodeA.left.right = new TreeNode(5);
		nodeA.right.left = new TreeNode(6);
		nodeA.right.right = new TreeNode(7);
		
		nodeA.right.left.left = new TreeNode(8);
		nodeA.right.right.right = new TreeNode(9);
		
		ZigZagOrderTraversal obj = new ZigZagOrderTraversal();
		obj.levelOrder(nodeA).forEach(e->System.out.println(e+ " "));
	}

}
