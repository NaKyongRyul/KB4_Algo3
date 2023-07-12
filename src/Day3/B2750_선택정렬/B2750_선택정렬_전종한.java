package Day3.B2750_선택정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2750_선택정렬_전종한 {
	public static void swap(int[] arr, int minIdx, int j) {
		int tmp = arr[minIdx];
		arr[minIdx] = arr[j];
		arr[j] = tmp;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int [] arr = new int [N];

		for(int i=0;i<N;i++) arr[i]= Integer.parseInt(bf.readLine());


		for(int i=0; i<N-1; i++) {
			int minIdx = i;
			for(int j=i+1; j<N; j++) {
				if(arr[minIdx] > arr[j]) {
					swap(arr, minIdx, j);
				}
			}
		}
		for(int a : arr) System.out.println(a);
	}
}
