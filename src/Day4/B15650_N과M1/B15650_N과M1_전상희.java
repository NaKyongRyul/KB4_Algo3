package Day4.B15650_N과M1;

import java.util.Scanner;

public class B15650_N과M1_전상희 {
	static int[] arr;
	static int[] selection;
	static int M;
	static boolean[] isSelected;
	
	static void combination(int r, int start) {
		if(r==M) {
			for(int i=0; i<M; i++) System.out.print(arr[selection[i]] + " ");
			System.out.println();
			return;
		}
		
		for(int i=start; i<arr.length; i++) {
			if(isSelected[i]) continue;
			
			isSelected[i] = true;
			selection[r] = i;
			combination(r+1, i);
			isSelected[i] = false;
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N];
		selection = new int[M];
		isSelected = new boolean[arr.length];
		
		for(int i=0; i<N; i++) {
			arr[i] = i+1;
		}
		
		combination(0, 0);
		
		
	}
}
