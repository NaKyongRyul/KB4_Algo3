package Day4.B15650_N과M1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B15650_N과M2_박상희 {
	static int [] arr;
	static int R;
	static int [] selection;
	static boolean [] isSelected;
	
	static void combination(int r, int start) {
		if (r == R) {
			for (int i = 0; i < R; i++) {
				System.out.print(arr[selection[i]] + " ");
			}
			
			System.out.println();
			
			return;
		}
		
		for (int j = start; j < arr.length; j++) {
			if (isSelected[j]) {
				continue;
			}
			
			isSelected[j] = true;
			selection[r] = j;
			combination(r + 1, j);
			isSelected[j] = false;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(bf.readLine(), " ");
		
		int N = Integer.parseInt(token.nextToken());
		int M = Integer.parseInt(token.nextToken());
		
		arr = new int[N];
		for (int n = 0; n < N; n++) {
			arr[n] = n + 1;
		}
		R = M;
		selection = new int[R];
		isSelected = new boolean[arr.length];
		
		combination(0, 0);
	}
}
