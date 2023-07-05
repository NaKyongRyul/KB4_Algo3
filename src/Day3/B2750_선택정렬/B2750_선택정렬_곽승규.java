package Day3.B2750_선택정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2750_선택정렬_곽승규 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		// 입력 처리 //
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());

		int [] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(bf.readLine());
		}
		
		//선택정렬
		
		for(int i = 0; i < N; i++) {
			int min_index = i;
			for (int j = i; j < N; j++) {
				if (arr[min_index] > arr[j]) min_index = j;
			}
			if (arr[i] > arr[min_index]) {
				int temp = arr[i];
				arr[i] = arr[min_index];
				arr[min_index] = temp;
			}
			
		}
		
		for(int value : arr) {
			System.out.println(value);
		}
 
	}

}
