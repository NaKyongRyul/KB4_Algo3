package Day3.B2750_삽입정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2750_삽입정렬_곽승규 {
	public static void swap(int [] arr, int i, int j) {

		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;

	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 입력 처리 //
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());

		int [] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(bf.readLine());
		}


		// 삽입정렬
		for(int i = 1; i < N; i++) {

			int targetValue = arr[i]; // 타겟값

			int j = i - 1;

			// 타겟값이 이전 값들보다 크기 전까지 
			while(j >= 0 && targetValue < arr[j]) {
				arr[j+1] = arr[j];
				swap(arr, j, j+1);
				
				j--;
			}

			arr[j+1] = targetValue;


		}
		for(int value : arr) {
			System.out.println(value);
		}

	}

}
