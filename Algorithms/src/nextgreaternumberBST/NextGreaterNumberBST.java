package nextgreaternumberBST;

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

public class NextGreaterNumberBST {

	public TreeNode getSuccessor(TreeNode a, int b) {
        return inOrderTraversal(a, b);
	}

    public TreeNode inOrderTraversal(TreeNode A, int b){
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        while(A!=null || !stack.isEmpty()) {
        	while(A!=null) {
        		stack.push(A);
        		A=A.left;
        	}
        	
        	if(A==null && !stack.isEmpty()) {
        		A = stack.pop();
        		if(A.val>b) return A;
        		A = A.right;
        	}
        }
        return null;
    }
	
	public static void main(String[] args) {
		TreeNode nodeA = new TreeNode(100);
		nodeA.left = new TreeNode(98);
		nodeA.right = new TreeNode(102);
		
		nodeA.left.left = new TreeNode(96);
		nodeA.left.right = new TreeNode(99);
		
		nodeA.left.left.right = new TreeNode(97);
		
		NextGreaterNumberBST obj = new NextGreaterNumberBST();
		TreeNode A = obj.getSuccessor(nodeA, 97);
		if(A.left!=null) System.out.println(A.left.val);
		if(A!=null) System.out.println(A.val);
		if(A.right!=null) System.out.println(A.right.val);
	}
}
