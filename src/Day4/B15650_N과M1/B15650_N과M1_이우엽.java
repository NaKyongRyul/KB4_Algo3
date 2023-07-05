package Day4.B15650_N과M1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B15650_N과M1_이우엽 {
	static int[] arr;
	static int R;
	static int[] selection;
	static boolean[] isSelected;
	public static void combination(int r, int start) {
		if(r == R) {
			for(int i = 0; i < R; i++) {
				System.out.print(arr[selection[i]] + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i = start; i < arr.length; i++) {
			if(isSelected[i]) {
				continue;
			}
			isSelected[i] = true;
			selection[r] = i;
			combination(r+1, i);
			isSelected[i] = false;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(token.nextToken());
		int M = Integer.parseInt(token.nextToken());
		
		arr = new int[N];
		R = M;
		selection = new int[M];
		isSelected = new boolean[arr.length];
		
		// arr 1 ~ N까지 초기화
		for(int i = 1; i <= arr.length; i++) {
			arr[i-1] = i;
		}
//		System.out.println(Arrays.toString(arr));
		
		combination(0,0);
	}
}
