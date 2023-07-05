package Day3.B2750_버블정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2750_버블정렬_길민지 {
	public static void swap(int [] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		
		int [] arr = new int [N];
		
		for (int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(bf.readLine());
		}
		
		// 버블 정렬
		bubbleSort (arr, N);
		
		for (int i=0; i<N; i++) {
			System.out.println(arr[i]);
		}
	}
	
	public static void bubbleSort(int [] arr, int N) {
		for(int i=N-1; i>0; i--) {
			for (int j=0; j<i; j++) {
				if(arr[j]>arr[j+1]) swap(arr, j, j+1);
			}
		}
	}

}
