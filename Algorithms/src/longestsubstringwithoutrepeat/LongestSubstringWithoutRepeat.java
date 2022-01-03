package longestsubstringwithoutrepeat;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeat {

	public int lengthOfLongestSubstring(String A) {
        char[] charArr = A.toCharArray();
        Set<Character> set = new HashSet<Character>();
        int max = 1;
        for(int i=0; i<charArr.length; i++){
            for(int j=i; j<charArr.length; j++){
                if(!set.contains(charArr[j])){
                    set.add(charArr[j]);
                }else{
                    max = Math.max(max,set.size());
                    set.clear();
                    break;
                }
            }
        }
        return max;
    }
	
	public static void main(String[] args) {
		//String A = "abcabcbb";
		String A = "u24EJG0y5OSeiMAM6aFCIGXp92hLQ7iCH0QAqTc5Q7j5aVKzoVEcnT1dKvt8uFEmQNJ8n1G91vawXnqc3z40dLO89XNlMDGOIVsoDwZtfECWeaP4aydBPyY6XTBWH1XbUq5i94waN2on9BcGvOYSJEE1bRb6jtc33y7JSDO7uwlfpohFJgK7G1BBmpDtYXtn3VeVug4y4IFqrvJa2hqbfIL1SqrJoflD1Ff2hmy6PuqZYUYII4Bq8pYZ17o7erkvj7Qf8z8nn8RngwOKMAyhB3p8BLGPxTvUcBgMrv8RezOxy3TXH9Dqas3leTO2aeDfztg99vT7DzkPbRMBND6K5KT37793PyD53MZPF9OHF9OEoo742fIPRpVfD3UhfGCXfvyA43Tx7o8Xug2dNKo7Hw5aMnZ0vxbpickXvEm4VGd6GP6WQwePXFOR6rmzk8iwimzIqfOsV2OEtwsZmW9pcWLxt1iD9HW6BSpBbJXYUNG1OK5Knijzlp2sSPbD1lcWdMRlbFtQhKCvU7ua4AsPZo5Uiya9Lhm7zZ5c27Vth3wUzByGTf17WtdT1RxwPNdByDBZQu9fPvPQsfFSGOKumN44jrWeUrkyYDycTvfVb37CVbRn4cwsiUhfm4bc2VrXR4eWgv63L6sRhNa1vf6dkH5HKfFDBnU9WbA3oi0R6i70KImD2wJNUrgES51afmX6rBDPhY8zaHmsTvhWIMLYg3hFiElXiA8tMDCBXIJ4eqQNxD9iIpdfQ3hhHYniN4n6WlKYGI3PcIuNCxHmhUPUQ7rXeoC8nQAuEDCuVeT4Rsyq1enCqVfqeJlNzOyfMAMbCzopY73LRXCDPZPEKrPqu4AlqVmgxregPwNR3UF7tWUoS9mFuKuJS6X8YhgqoOYBkEwCBe4rRlpTORNuuGoOkxURr6tnK3Hl26TaoZfy0nMxP4Gj1lOxPoUA8Kif70Y56a3ip7ID1D3ukT54xVKihA4O2Dj5CFcYeiqNQGJ7vyQQbhNcOJul8tw1rdjNeafxCMa4fWyzhjhJI3IG1uMUGGXAO31ka7DCz8cq0bw32ILj7wfPFzbaHOVHOaXYRg6eb0kn0HhAwrnM8OdKRkvv9sGSyYJlhmc";
		
		LongestSubstringWithoutRepeat obj = new LongestSubstringWithoutRepeat();
		System.out.println(obj.lengthOfLongestSubstring(A));
	}

}
