package postordertraversal;

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

public class PostorderTraversal {

	public ArrayList<Integer> postorderTraversal(TreeNode A) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if(A!=null) stack.push(A);
        TreeNode node = null;
        while(!stack.isEmpty()){
            node = stack.pop();
            if(node.left==null && node.right==null) result.add(node.val);
            else{
                stack.push(node);

                if(node.right!=null){
                    stack.push(node.right);
                    node.right=null;
                }

                if(node.left!=null){
                    stack.push(node.left);
                    node.left=null;
                }
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
		
		PostorderTraversal obj = new PostorderTraversal();
		obj.postorderTraversal(nodeA).forEach(e->System.out.println(e+ " "));

	}

}
