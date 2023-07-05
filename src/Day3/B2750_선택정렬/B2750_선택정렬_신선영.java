package Day3.B2750_선택정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2750_선택정렬_신선영 {
	
	 public static void swap(int [] arr, int i, int j) {
		 int temp = arr[i];
		 arr[i] = arr[j];
		 arr[j] = temp;
	 }
	 
	 public static void selectionSort(int[] arr) {
		 int len = arr.length;

		 for (int i = 0; i < len - 1; i++) {
			 int min_idx = i;
			 for (int j = i + 1; j < len; j++) {
				 if (arr[j] < arr[min_idx]) min_idx = j;
			 }
			 if (min_idx != i) swap(arr, i, min_idx);
		 }
	 }


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 입력 처리
		int N = Integer.parseInt(st.nextToken());
		int [] arr = new int[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// 정렬
		selectionSort(arr);
		for (int a : arr) {
			System.out.println(a);
		}

	}

}
