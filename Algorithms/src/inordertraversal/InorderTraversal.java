package inordertraversal;

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

public class InorderTraversal {
	
	public ArrayList<Integer> inorderTraversal(TreeNode A) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        while(A!=null || !stack.isEmpty()){
            while(A!=null){
                stack.push(A);
                A=A.left;
            }

            if(A==null && !stack.isEmpty()){
                A = stack.pop();
                result.add(A.val);
                A = A.right;
            }
        }
        return result;
    }

	public static void main(String[] args) {
		TreeNode nodeA = new TreeNode(1);
		nodeA.left = new TreeNode(2);
		nodeA.right = new TreeNode(3);
		
		nodeA.left.left = new TreeNode(4);
		
		nodeA.right.left = new TreeNode(5);
		nodeA.right.right = new TreeNode(6);
		
		InorderTraversal obj = new InorderTraversal();
		obj.inorderTraversal(nodeA).forEach(e->System.out.println(e+ " "));

	}

}
