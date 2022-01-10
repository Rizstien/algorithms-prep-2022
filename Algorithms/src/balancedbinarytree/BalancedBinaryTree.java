package balancedbinarytree;

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

public class BalancedBinaryTree {
	
	public int isBalanced(TreeNode A) {
        if(A==null) return 1;
        if(A.left==null && A.right==null) return 1;

        int hL = maxHeight(A.left);
        int hR = maxHeight(A.right);
        if(Math.abs(hL-hR)==1 || Math.abs(hL-hR)==0){
            return isBalanced(A.left) & isBalanced(A.right);
        }
        return 0;
    }
	
    public int maxHeight(TreeNode A){
        if(A==null) return 0;
        else return Math.max(maxHeight(A.left), maxHeight(A.right))+1;        
    }

	public static void main(String[] args) {
		TreeNode nodeA = new TreeNode(1);
		nodeA.left = new TreeNode(2);
		nodeA.right = new TreeNode(3);
		nodeA.left.left = new TreeNode(4);
		nodeA.right.left = new TreeNode(5);
		nodeA.right.right = new TreeNode(6);
		
		BalancedBinaryTree obj = new BalancedBinaryTree();
		System.out.println(obj.isBalanced(nodeA));

	}

}
