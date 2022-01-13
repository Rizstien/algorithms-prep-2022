package flattenbinarytreetolinkedlist;

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

public class FlattenBinaryTreetoLinkedList {
	
	public TreeNode flatten(TreeNode A) {
        if(A==null) return null;
        TreeNode right = A.right;
        A.right = flatten(A.left);
        A.left = null;
        TreeNode curr = A;
        while(curr.right!=null) curr = curr.right;
        curr.right = flatten(right);
        return A;
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
		
		FlattenBinaryTreetoLinkedList obj = new FlattenBinaryTreetoLinkedList();
		
		TreeNode A = obj.flatten(nodeA);
		while(A.right!=null) {
			System.out.println(A.val);
			A = A.right;
		}

	}

}
