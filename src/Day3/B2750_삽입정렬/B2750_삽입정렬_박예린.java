package Day3.B2750_삽입정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B2750_삽입정렬_박예린 {
	
	public static void swap(int [] arr, int i, int j) {
				
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;		
	}
	
	public static void insertionSort(int [] arr) {
		
		int len = arr.length;
		int target_idx = 0;
		int target = 0;
		
		for(int i = 0; i < len-1; i++) {
			target_idx = i+1;
			target = arr[target_idx];
			
			for(int j = i+1; j > 0; j--) {
				if(arr[j-1] > target) {
					arr[target_idx] = arr[j-1];
					target_idx--;
				}
			}
			arr[target_idx] = target;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 입력 처리 //
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(bf.readLine());
		int [] arr = new int[N];

		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(bf.readLine());
		}

		// 정렬
		insertionSort(arr);
		
		for(int i = 0; i < N; i++) {
			System.out.println(arr[i]);
		}
	}
}