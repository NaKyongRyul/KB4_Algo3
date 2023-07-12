package Day3.B2750_선택정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2750_선택정렬_나경률 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i=0; i<N-1; i++) {
			int min = i;
			for(int j=i+1; j<N; j++) {
				if(arr[min] > arr[j]) {
					min = j;
				}
			}
			swap(arr, i, min);
		}
		
		for(int i=0; i<N; i++) {
			sb.append(arr[i] + "\n");
		}
		System.out.println(sb);
	}
	
	public static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
}
