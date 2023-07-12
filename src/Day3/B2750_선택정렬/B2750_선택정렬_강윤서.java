package Day3.B2750_선택정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2750_선택정렬_강윤서 {
	public static void swap(int [] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static void selectionSort(int [] arr, int n) {
		for (int i=0; i<n-1; i++) {
			int minValue = i;
			for (int j=i+1; j<n; j++) {
				if (arr[j]<arr[minValue]) { // 작은 값으로 계속 업데이트 
					minValue = j;
				}
			}
			swap(arr, i, minValue);
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
		
		// 선택 정렬
		selectionSort(numList, n);
		
		// 결과 출력
		for (int i=0; i<n; i++) {
			System.out.println(numList[i]);
		}
	}
}
