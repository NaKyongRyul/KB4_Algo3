package Day3.B2750_선택정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2750_선택정렬_백미수 {

public static void swap(int[] arr, int i, int j) {
		
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
	
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(reader.readLine());
		
		int[] arr = new int[N];
		for(int i =0; i<N; i++) {
			arr[i] = Integer.parseInt(reader.readLine());
		}
		for(int i =0; i<N; i++) {
			int minIdx = i;
			for(int j=i+1; j<N; j++) {
				if(arr[minIdx]>arr[j]) {
					 minIdx = j;
				}
			}
			swap(arr,i,minIdx);
		}
		
		for(int i =0; i<N; i++) {
			System.out.println(arr[i]);
		}
	}
}
