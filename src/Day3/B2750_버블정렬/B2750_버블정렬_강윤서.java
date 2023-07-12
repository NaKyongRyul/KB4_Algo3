package Day3.B2750_버블정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2750_버블정렬_강윤서 {
	public static void swap(int [] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static void bubbleSort(int [] arr, int n) {
		for (int i=0; i<n-1; i++) { // 확인할 수 하나씩 감소
			for (int j=0; j<n-1-i; j++) {
				if (arr[j]>arr[j+1]) {
					swap(arr, j, j+1);
				}
			}
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		// 수 입력
		int [] numList = new int[n];
		for (int i=0; i<n; i++) {
			numList[i] = Integer.parseInt(br.readLine());
		}
		
		// 버블 정렬
		bubbleSort(numList, n);
		
		// 결과 출력
		for (int i=0; i<n; i++) {
			System.out.println(numList[i]);
		}
	}
}
