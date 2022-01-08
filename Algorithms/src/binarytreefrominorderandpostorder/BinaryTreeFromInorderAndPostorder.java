package binarytreefrominorderandpostorder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

public class BinaryTreeFromInorderAndPostorder {
	
	public TreeNode buildTree(List<Integer> in, List<Integer> post) {
        if(in==null || in.size()==0) return null;
        TreeNode root = new TreeNode(post.get(post.size()-1));
        if(post.size()==1) return root;

        int indexRoot = in.indexOf(root.val);

        List<Integer> inL = in.subList(0,indexRoot);
        List<Integer> inR = in.subList(indexRoot+1, in.size());

        List<Integer> postL = post.subList(0,indexRoot);
        List<Integer> postR = post.subList(indexRoot, post.size()-1);

        root.left = buildTree(inL, postL);
        root.right = buildTree(inR, postR);

        return root;

    }
	
	public static void main(String[] args) {
		Integer[] in = { 2, 1, 3 };
		List<Integer> A = new ArrayList<Integer>(Arrays.asList(in));

		Integer[] pre = { 2, 3, 1 };
		List<Integer> B = new ArrayList<Integer>(Arrays.asList(pre));

		BinaryTreeFromInorderAndPostorder obj = new BinaryTreeFromInorderAndPostorder();
		TreeNode root = obj.buildTree(A, B);
		if(root.left!=null) System.out.println(root.left.val);
		if(root!=null) System.out.println(root.val);
		if(root.right!=null) System.out.println(root.right.val);

	}

}
