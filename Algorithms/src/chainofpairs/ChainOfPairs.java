package chainofpairs;

import java.util.ArrayList;
import java.util.Arrays;

public class ChainOfPairs {
	
	public int solve(ArrayList<ArrayList<Integer>> A) {
        
		int[] max = new int[A.size()];
        Arrays.fill(max,1);

        int incOrderGlobal=1;
        for(int j=1;j<A.size();j++){
            for(int i=0;i<j;i++){
                if(A.get(i).get(1)<A.get(j).get(0)){
                    max[j]=Math.max(max[j],max[i]+1);
                }
            }
			incOrderGlobal = Integer.max(incOrderGlobal, max[j]);
        }
        return incOrderGlobal;
    }

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> A = new ArrayList<ArrayList<Integer>>();
		
		Integer[] array = {98, 894};
		ArrayList<Integer> Asub = new ArrayList<Integer>(Arrays.asList(array));
		A.add(Asub);
		
		Asub = new ArrayList<Integer>();
		Asub.add(397);Asub.add(942);
		A.add(Asub);
		
		Asub = new ArrayList<Integer>();
		Asub.add(70);Asub.add(519);
		A.add(Asub);
		
		Asub = new ArrayList<Integer>();
		Asub.add(258);Asub.add(456);
		A.add(Asub);
		
		Asub = new ArrayList<Integer>();
		Asub.add(286);Asub.add(449);
		A.add(Asub);
		
		Asub = new ArrayList<Integer>();
		Asub.add(516);Asub.add(626);
		A.add(Asub);	
		
		Asub = new ArrayList<Integer>();
		Asub.add(370);Asub.add(873);
		A.add(Asub);	
		
		Asub = new ArrayList<Integer>();
		Asub.add(708);Asub.add(224);
		A.add(Asub);
		
		Asub = new ArrayList<Integer>();
		Asub.add(74);Asub.add(629);
		A.add(Asub);
		
		Asub = new ArrayList<Integer>();
		Asub.add(265);Asub.add(886);
		A.add(Asub);
		
		Asub = new ArrayList<Integer>();
		Asub.add(214);Asub.add(815);
		A.add(Asub);
		
		Asub = new ArrayList<Integer>();
		Asub.add(394);Asub.add(770);
		A.add(Asub);
		
		Asub = new ArrayList<Integer>();
		Asub.add(56);Asub.add(252);
		A.add(Asub);

		ChainOfPairs obj = new ChainOfPairs();
		System.out.println(obj.solve(A));

	}

}
