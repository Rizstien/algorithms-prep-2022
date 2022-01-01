package findpermutation;

import java.util.ArrayList;

public class FindPermutation {
	
	public ArrayList<Integer> findPerm(final String A, int B) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int rangeMin = 1;
        int rangeMax = B;

        if(A.charAt(0) == 'I' && rangeMin<=B){
            result.add(rangeMin);
            rangeMin++;
        }else if(A.charAt(0) == 'D' && rangeMax>=1){
            result.add(rangeMax);
            rangeMax--;
        }

        for(int i=1;i<A.length(); i++){
            if(A.charAt(i) == 'I' && rangeMin<=B){
                result.add(rangeMin);
                rangeMin++;
            }else if(A.charAt(i) == 'D' && rangeMax>=1){
                result.add(rangeMax);
                rangeMax--;
            }
        }

        if(rangeMin==rangeMax) result.add(rangeMax);
        return result;
    }
	
	public static void main(String[] args) {
		
		FindPermutation obj = new FindPermutation();
		obj.findPerm("IID", 4).forEach(e->System.out.print(e+" "));

	}

}
