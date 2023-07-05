package Day3.B2750_삽입정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B2750_삽입정렬_박찬욱 {

	public static void insertSort(int [] arr, int N) {
		// 1. 삽입위치 탐색 (index 1번 부터 확인)
		for(int i = 1; i < N; i++) { // i : 삽입 index(1번~ N-1번)
			int num = arr[i]; // 삽입값, int temp = arr[i];
			int j = i-1; // 비교를 시작할 자리
			while(j >= 0 && arr[j] > num) { // 비교값이 있고, 비교값이 삽입값보다 큰경우
				// j < 0 or arr[j] < num : 비교값이 없거나, 비교값이 삽입값보다 작은경우
				arr[j+1] = arr[j]; // arr[i] = arr[j];
				j--; // 비교값 내리기
			}
			arr[j+1] = num; // arr[j] = temp;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 입력 처리 //
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(bf.readLine()); 
		int [] arr = new int [N];
		for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(bf.readLine());

		// 정렬
		insertSort(arr, N);

		System.out.println(Arrays.toString(arr));
	}

}


