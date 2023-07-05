package Day3.B2750_선택정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2750_선택정렬_김태선 {
	
	public static void swap(int [] arr, int i, int j) {
	
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		
	}		
	
	public static void selectionSort(int [] arr) {
		
		for(int i = 0; i < arr.length - 1; i++) {
			int idx = i;
			for(int j = i; j < arr.length; j++) {
				if(arr[j] < arr[idx]) idx = j; 
			}
			swap(arr, i, idx);
			
		}
	}
		
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int [] arr = new int [N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		selectionSort(arr);
		for(int i = 0; i < N; i++) {
			System.out.println(arr[i]);
		}
		

	}

}
