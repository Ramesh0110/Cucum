package db;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class arraylist {

	public static void main(String[] args) {
		
		// convert array if int to list.
		
		int[] arrayInt=new int[] {1,2,3,4,5};
		
		
		
		
		List<int[]> a=Arrays.asList(arrayInt);
		
		
		List<Integer> ar=new ArrayList();
		
		for(int a1:arrayInt) {
			ar.add(a1);
		}

	}

}
