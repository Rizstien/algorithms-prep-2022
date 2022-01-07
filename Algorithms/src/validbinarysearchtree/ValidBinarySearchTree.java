package validbinarysearchtree;

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

public class ValidBinarySearchTree {

	 public int isValidBST(TreeNode A) {
		 return isValidBST(A, Integer.MIN_VALUE, Integer.MAX_VALUE);
	 }
	 
	 public int isValidBST(TreeNode A, int min, int max) {
        if(A==null) return 1;

        if(A.val>min && A.val<max){
            return isValidBST(A.left, min, A.val) & isValidBST(A.right, A.val, max);
        }else{
            return 0;
        }
	}
	 
	public static void main(String[] args) {
		TreeNode nodeA = new TreeNode(11);
		nodeA.left = new TreeNode(2);
		nodeA.right = new TreeNode(13);
		
		nodeA.left.left = new TreeNode(1);
		nodeA.left.right = new TreeNode(9);
		nodeA.left.right.left = new TreeNode(3);
		
		nodeA.right.right = new TreeNode(57);
		
		nodeA.right.right.left = new TreeNode(25);
		nodeA.right.right.right = new TreeNode(90);
		
		nodeA.right.right.left.left = new TreeNode(17);
		
		ValidBinarySearchTree obj = new ValidBinarySearchTree();
		System.out.println(obj.isValidBST(nodeA));
	}

}
