package Day3.B2750_선택정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2750_선택정렬_나웅기 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());

		int [] arr = new int [n];
		

		for (int i = 0; i<n; i++) {
			arr[i] = Integer.parseInt(reader.readLine());
		}
		int temp;
		for (int i = 0; i<n-1; i++) {
			int minIdx = i;
			int minNum = arr[i];
			for (int j = i+1; j<n; j++) {
				if (arr[j] < minNum) {
					minIdx = j;
					minNum = arr[j];
				}
			}
			if (minNum != arr[i]) {
				temp = arr[i];
				arr[i] = minNum;
				arr[minIdx] = temp;
			}
		}
		
		for (int i : arr) {
			System.out.println(i);
		}
		
	}
}
