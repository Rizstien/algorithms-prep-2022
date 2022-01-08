package binarytreefrominorderandpreorder;

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

public class BinaryTreeFromInorderAndPreorder {
	
	public TreeNode buildTree(List<Integer> pre, List<Integer> in) {
        if(in==null || in.size()==0) return null;
        TreeNode root = new TreeNode(pre.get(0));
        if(pre.size()==1) return root;

        int indexRoot = in.indexOf(root.val);

        List<Integer> inL = in.subList(0, indexRoot);
        List<Integer> inR = in.subList(indexRoot+1, in.size());

        List<Integer> preL = pre.subList(1, indexRoot+1);
        List<Integer> preR = pre.subList(indexRoot+1, pre.size());

        root.left = buildTree(preL, inL);
        root.right = buildTree(preR, inR);

        return root;
    }

	public static void main(String[] args) {
		Integer[] in = { 1, 2, 3 };
		List<Integer> A = new ArrayList<Integer>(Arrays.asList(in));

		Integer[] pre = { 2, 1, 3 };
		List<Integer> B = new ArrayList<Integer>(Arrays.asList(pre));

		BinaryTreeFromInorderAndPreorder obj = new BinaryTreeFromInorderAndPreorder();
		TreeNode root = obj.buildTree(A, B);
		if(root.left!=null) System.out.println(root.left.val);
		if(root!=null) System.out.println(root.val);
		if(root.right!=null) System.out.println(root.right.val);
	}

}
