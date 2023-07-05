package Day3.B2750_삽입정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2750_삽입정렬_박상희 {
	public static void swap(int [] arr, int i, int j) {		
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static void insertionSort(int [] arr) {
		int len = arr.length;
		
		for (int i = 1; i < len; i++) {			
			int current = arr[i];
			
			for (int j = i - 1; j >= 0; j--) {
				if (arr[j] > current) {
					swap(arr, j, j + 1);
				}
				else {
					break;
				}
			}			
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {			
		// 입력 처리
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		
		int numArr[] = new int[N];
		for (int n = 0; n < N; n++) {
			numArr[n] = Integer.parseInt(bf.readLine());
		}
		
		// 정렬
		insertionSort(numArr);
		
		for (int a : numArr) {
			System.out.println(a);
		}
	}
}
