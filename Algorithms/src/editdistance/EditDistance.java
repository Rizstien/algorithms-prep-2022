package editdistance;

import java.util.Arrays;

public class EditDistance {
	int memo[][];
	
    public int minDistance(String A, String B) {
        memo = new int[A.length()][B.length()];
        for(int[] row : memo) Arrays.fill(row, -1);
        return editDistance(A, 0, B, 0);
    }

    int editDistance(String S1, int index1, String S2, int index2) {
        if(index1==S1.length() && index2==S2.length()) return 0;
        if(index1==S1.length()) return S2.length()-index2;
        if(index2==S2.length()) return S1.length()-index1;
        if(memo[index1][index2] !=-1) return memo[index1][index2];
        int res = Integer.MAX_VALUE;
        if (S1.charAt(index1) == S2.charAt(index2)) res = editDistance(S1, index1 + 1, S2, index2 + 1);
        res = Math.min(res, 1 + editDistance(S1, index1+1, S2, index2+1));
        res = Math.min(res, 1 + editDistance(S1, index1+1, S2, index2));
        res = Math.min(res, 1 + editDistance(S1, index1, S2, index2+1));
        return memo[index1][index2] = res;
    }
	
	public static void main(String[] args) {
		EditDistance obj = new EditDistance();
		System.out.println(obj.minDistance("Anshuman","Antihuman"));

	}

}
