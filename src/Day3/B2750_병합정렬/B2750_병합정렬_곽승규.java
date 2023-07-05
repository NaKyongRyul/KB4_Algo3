package Day3.B2750_병합정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B2750_병합정렬_곽승규 {

	public static int [] tmp;
	public static void mergeSort(int [] arr, int left, int right) {
		if(left >= right) return;
		
		int center = (left + right) / 2;
		
		// 분할 (divide)
		mergeSort(arr,left, center);
		mergeSort(arr, center+1, right);
		
		
		// 정복 (conquer)
		for (int i = left; i <= right; i++) {
			System.out.println("left :" + left + ", right :" + right);
			tmp[i] = arr[i];
		}
		System.out.println(Arrays.toString(tmp));
		
		int currentIndex = left;
		int index1 = left;
		int index2 = center+1;
		
		while(index1 <= center && index2 <= right) {
			if (tmp[index1] > tmp[index2]) {
				arr[currentIndex] = tmp[index2];
				currentIndex++;
				index2++;
			}else {
				arr[currentIndex] = tmp[index1];
				currentIndex++;
				index1++;
			}
		}
		
		while(index1 <= center) {
			arr[currentIndex] = tmp[index1];
			currentIndex++;
			index1++;
		}
		while(index2 <= center) {
			arr[currentIndex] = tmp[index2];
			currentIndex++;
			index2++;
		}
		
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		
		// 입력 처리 //
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());

		int [] arr = new int[N]; // 정렬할 배열
		tmp = new int[N]; // tmp 배열
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(bf.readLine());
		}
		
		
		// 병합 정렬
		mergeSort(arr, 0, N-1);

		for(int value : arr) {
			System.out.println(value);
		}
		
	}

}
