package Day4.B2961_도영이가만든맛있는음식;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2961_도영이가만든맛있는음식_조성환 {
	static int[] arr;
	static int N;
	int bitter;
	int sour;
	static boolean[] isSelected;

	static int[] B;
	static int[] S;
	
	static int a,b, min;
	static void subset(int num) {
		int a = 1;
		int b = 0;
		if(num == N) {
			for(int i =0;i<N;i++) {
				if(isSelected[i]) {
					a *= B[i];
					b += S[i];
				}
			}
			
			if (a != 0 && b != 0 && (Math.abs(a - b)) < min) {	
				min = Math.abs(a - b);
			}
			return;
		}
		
		isSelected[num] = true;
		subset(num+1);
		
		isSelected[num] = false;
		subset(num+1);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		
		B = new int[N];
		S = new int[N];
		
		arr = new int[N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			arr[i] = i;
			B[i] = Integer.parseInt(st.nextToken());
			S[i] = Integer.parseInt(st.nextToken());
		}
		isSelected = new boolean [N];
		min = 1000000000;
		subset(0);
		
		System.out.println(min);
	}

}
