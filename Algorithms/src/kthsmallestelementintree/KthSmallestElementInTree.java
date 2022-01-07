package kthsmallestelementintree;

import java.util.ArrayList;
import java.util.Stack;

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

public class KthSmallestElementInTree {
	
	public int kthsmallest(TreeNode A, int B) {
        ArrayList<Integer> result = inOrderTraversal(A);
        return result.get(B-1);
    }

    public ArrayList<Integer> inOrderTraversal(TreeNode A){
        Stack<TreeNode> stack = new Stack<TreeNode>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        while(A!=null || !stack.isEmpty()) {
        	while(A!=null) {
        		stack.push(A);
        		A=A.left;
        	}
        	
        	if(A==null && !stack.isEmpty()) {
        		A = stack.pop();
        		result.add(A.val);
        		A = A.right;
        	}
        }
        return result;
    }

	public static void main(String[] args) {
		TreeNode nodeA = new TreeNode(100);
		nodeA.left = new TreeNode(98);
		nodeA.right = new TreeNode(102);
		
		nodeA.left.left = new TreeNode(96);
		nodeA.left.right = new TreeNode(99);
		
		nodeA.left.left.right = new TreeNode(97);
		
		KthSmallestElementInTree obj = new KthSmallestElementInTree();
		System.out.println(obj.kthsmallest(nodeA, 3));
	}

}
