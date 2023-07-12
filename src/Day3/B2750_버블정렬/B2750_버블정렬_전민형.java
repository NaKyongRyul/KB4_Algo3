package Day3.B2750_버블정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B2750_버블정렬_전민형 {

	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		String str = reader.readLine();
		int num = Integer.parseInt(str);
		
		int [] arr = new int[num];
		
		for(int i = 0; i<num; i++) {
			str = reader.readLine();
			arr[i] = Integer.parseInt(str);
		}
		
		buble(arr, num);
		for(int i = 0; i<num; i++) {
			System.out.println(arr[i]);
		}
		

	}
	
	public static void swap (int [] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static void buble (int [] arr, int n) {
		for(int i = 0; i<n-1; i++) {
			for(int j = 0; j<n-i-1; j++) {
				if(arr[j]>arr[j+1]) {
					swap(arr, j, j+1);
				}
			}
		}
		
	}

}
