package Day3.B2750_병합정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2750_병합정렬_김태선 {
	
	public static void merge(int h, int m, int [] S, int [] E, int [] arr) {
		
		int i = 1, j = 1, k = 1;
		
		while(i <= h && j <= m) {
			if(S[i - 1] < E[j - 1]) {
				arr[k - 1] = S[i - 1];
				i++;
			}
			else {
				arr[k - 1] = E[j - 1];
				j++;
			}
			k++;
		}
		
		if(i > h) {
			for(int t = 0; t < m - j + 1; t++) {
				arr[t + k - 1] = E[j + t - 1];
			}
		}
		else {
			for(int t = 0; t < h - i + 1; t++) {
				arr[t + k - 1] = S[i + t - 1];
			}
		}
	}
	
	
	public static void mergeSorting(int n, int [] arr) {
		
		if(n > 1) {
			int h = n / 2;
			int m = n - h;
			int [] S = new int[h];
			int [] E = new int[n - (h + 1) + 1];
			
			for(int t = 0; t < h; t++) {
				S[t] = arr[t];
			}
			
			for(int t = 0; t < n - (h + 1) + 1; t++) {
				E[t] = arr[h + t];
			}
			
			mergeSorting(h, S);
			mergeSorting(m, E);
			merge(h, m, S, E, arr);
		}
		
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int [] arr = new int [N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		
		mergeSorting(N, arr);
		for(int i = 0; i < N; i++) {
			System.out.println(arr[i]);
		}
		

	}

}
