package rainwatertrapped;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RainWaterTrapped {
	
	public int trap(final List<Integer> A) {
        int n = A.size();
        if(n<=2) return 0;
        
        int startingIndexOfPossibleTrap = 0;
        int startingHeightOfPossibleTrap = A.get(0);
        int waterInCurrentPossibleTrap = 0;
        int confirmedWaterInTrap = 0;
        
        for(int i = 1; i<n; i++) {
        	int currHeight = A.get(i);
        	if(currHeight>=startingHeightOfPossibleTrap) {
        		confirmedWaterInTrap += waterInCurrentPossibleTrap;
        		waterInCurrentPossibleTrap = 0;
        		startingHeightOfPossibleTrap = currHeight;
        		startingIndexOfPossibleTrap = i;
        	}else{
        		waterInCurrentPossibleTrap += startingHeightOfPossibleTrap-currHeight;
        	}
        }
        
        if(startingIndexOfPossibleTrap>=n-2) {
        	return confirmedWaterInTrap;
        }
        
        int reverseTill = startingIndexOfPossibleTrap;
        startingIndexOfPossibleTrap = n-1;
        startingHeightOfPossibleTrap = A.get(n-1);
        waterInCurrentPossibleTrap = 0;
        
        for(int i = n-2; i>=reverseTill; i--) {
        	int currHeight = A.get(i);
        	if(currHeight>=startingHeightOfPossibleTrap) {
        		confirmedWaterInTrap += waterInCurrentPossibleTrap;
        		waterInCurrentPossibleTrap = 0;
        		startingHeightOfPossibleTrap = currHeight;
        		startingIndexOfPossibleTrap = i;
        	}else{
        		waterInCurrentPossibleTrap += startingHeightOfPossibleTrap-currHeight;
        	}
        }
        
        return confirmedWaterInTrap;
        
    }
	
	public static void main(String[] args) {
		Integer[] array = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
		ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(array));

		RainWaterTrapped obj = new RainWaterTrapped();
		System.out.println(obj.trap(A));

	}

}
