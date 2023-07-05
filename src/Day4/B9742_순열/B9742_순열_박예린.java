package Day4.B9742_순열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class B9742_순열_박예린 {

	static char [] arrChar;
	static int R;
	static int N;
	static int [] selection;
	static boolean [] isSelected;
	
	static char [] arrTemp;
	static int count;
	
	// [a, b, c]
	/*
	 *  2 3 5 0 1 2 
		2 5 3 0 2 1
		3 2 5 1 0 2
		3 5 2 1 2 0
		5 2 3 2 0 1
		5 3 2 2 1 0
	 * 
	 * 
	 * */
	
	static void permutation(int r) {
		if(r == R) {		
			for(int i = 0; i < R; i++) {
				arrTemp[i] = arrChar[selection[i]];
			}
			
			count++;
			if(count == N) return;
		}
		
		for(int i = 0; i < R; i++) {
			if(isSelected[i]) continue;
			isSelected[i] = true;
			selection[r] = i;
			permutation(r+1);
			isSelected[i] = false;
		}
	}
	
	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String [] arr = {};
		
		// EOF에 유의
		while(arr != null) {			
			arr = bf.readLine().split(" ");
			arrChar = arr[0].toCharArray();
			R = arrChar.length;
			N = Integer.parseInt(arr[1]);
			selection = new int[R];
			isSelected = new boolean[R];
			
			arrTemp = new char[R];
			count = 0;
			
			permutation(0);
			
			System.out.println(arr[0] + " " + arr[1] + " = " + Arrays.toString(arrTemp));
			
			
		}
		// end of input

	}

}
