package Day3.B2750_삽입정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2750_삽입정렬_김태선 {

	public static void insertionSort(int [] arr, int N) {
		
		for(int i = 0; i < N; i++) {
			int j = i - 1;
			int tmp = arr[i];
			
			for(j = i; j > 0 && arr[j - 1] > tmp; j--) {
				arr[j] = arr[j - 1];
			}
			arr[j] = tmp;
		}
	}
		
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int [] arr = new int [N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		
		insertionSort(arr, N);
		for(int i = 0; i < N; i++) {
			System.out.println(arr[i]);
		}
		

	}

}
