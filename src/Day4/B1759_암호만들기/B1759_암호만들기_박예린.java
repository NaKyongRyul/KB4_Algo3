package Day4.B1759_암호만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1759_암호만들기_박예린 {
	
	static String[] arr;
	static int L;
	static int C;
	static int [] selection;
	static boolean [] isSelected;
	
	static void combination(int r, int start) {
		if(r == C) {
			for(int i = 0; i < L; i++) {
				System.out.print(arr[selection[i]]);
			}
			System.out.println();
			return;
		}
		
		for(int i = start; i < arr.length; i++) {
			if(isSelected[i]) continue;
			isSelected[i] = true;
			selection[r] = i;
			combination(r+1, i);
			isSelected[i] = false;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1, st2;
		
		st1 = new StringTokenizer(bf.readLine());
		L = Integer.parseInt(st1.nextToken());
		C = Integer.parseInt(st1.nextToken());
		
		ArrayList<Integer> vowel = new ArrayList<Integer> ();
		arr = new String[C];

		st2 = new StringTokenizer(bf.readLine());
		
		for(int i = 0; i < C; i++) {
			
			arr[i] = st2.nextToken();
			
			if(arr[i].equals("a") || arr[i].equals("e") || arr[i].equals("i") || arr[i].equals("o") || arr[i].equals("u")) {
				vowel.add(i);
			}
		}
		
		selection = new int[C];
		isSelected = new boolean[arr.length];
		System.out.println(Arrays.toString(arr));
		System.out.println(vowel);
		
		combination(0, 0);

	}
}