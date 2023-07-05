package Day3.B2750_삽입정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2750_삽입정렬_길민지 {
	public static void insertionSort(int [] arr, int N) {
		for (int i=1; i<N; i++) {
			int now = arr[i];
			int leftIdx = i-1;
			while (leftIdx>=0 && arr[leftIdx]>now) {
				arr[leftIdx+1] = arr[leftIdx];
				leftIdx--;
			}
			arr[leftIdx + 1]=now;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		
		int [] arr = new int [N];
		
		for (int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(bf.readLine());
		}
		
		// 정렬 실행
		insertionSort(arr, N);
		
		//출력
		for (int i=0; i<N; i++) {
			System.out.println(arr[i]);
		}
	}
	
	

}
