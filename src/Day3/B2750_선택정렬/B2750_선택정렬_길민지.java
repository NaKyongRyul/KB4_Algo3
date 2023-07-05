package Day3.B2750_선택정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2750_선택정렬_길민지 {
	public static void swap(int [] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static void selectionSort(int [] arr, int N) {
		
		for (int i=0; i<N-1; i++) {
			int min = i;
			for (int j=i+1; j<N; j++) {
				if (arr[min]>arr[j]) min = j;
			}
			swap(arr, i, min);
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		
		int [] arr = new int [N];
		
		for (int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(bf.readLine());
		}
		
		// 정렬 실행
		selectionSort(arr, N);
		
		// 출력
		for (int i=0; i<N; i++) {
			System.out.println(arr[i]);
		}
	}
	
	

}
