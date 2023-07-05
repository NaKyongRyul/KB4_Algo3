package Day3.B2750_버블정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2750_버블정렬_신선영 {
	
	 public static void swap(int [] arr, int i, int j) {
		 int temp = arr[i];
		 arr[i] = arr[j];
		 arr[j] = temp;
	 }
	 
	 public static void bubblesort(int[] arr) {
		 int len = arr.length;

		 for (int j = len; j > 0; j--) {
			 for (int i = 0; i < j - 1; i++) {
				 if (arr[i + 1] < arr[i]) {
					 swap(arr, i, i + 1);
				 }
			 }
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

//		System.out.println(Arrays.toString(arr));
		
		// 정렬
		bubblesort(arr);
		for (int a : arr) {
			System.out.println(a);
		}

	}

}
