package Day3.B2750_퀵정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B2750_퀵정렬_박찬욱 {
	
	public static void swap (int [] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static int partition(int [] arr, int start, int end) {
		int pivot = start; // 맨 처음 값을 기존 값을으로 둔다.
		int left = start + 1; // 기존 값 기준으로 가장 작은 값의 자리, 맨 처음 값을 기존 값으로 두었으므로, 그 다음 값이 가장 작은 값으로 된다.
		int right = end; // 기존 값 기준으로 가장 큰 값의 자리, 가장 오른쪽에 있는 값이 가장 큰 값으로 둔다.
		
		while(left <= right) { // 엇갈리지 않을 동안 작동
			
			while(left <= right && arr[left] <= arr[pivot]) left++; 
			// 엇갈리지 않고, 기존값이 가장 작은 값보다 클 경우, 오른쪽으로 한칸이동하여 확인한다.
			
			while(left <= right && arr[right] >= arr[pivot]) right--;
			// 엇갈리지 않고, 기존값이 가장 큰 값보다 작을 경우, 왼쪽으로 한칸이동하여 확인한다.
			
			if(left>right) //엇갈린 경우
				swap(arr, right, pivot); // 기존값과 가장 큰 값의 자릴르 교체한다.
			else 
				swap(arr, left, right); // 
		}
		
		return right;
	}
	
	public static void quickSort(int [] arr, int start , int end) { // 배열, 시작점(왼쪽), 끝점(오른쪽)
		if(start >= end) return; // 엇갈리지 않기 전까지 반복(종료조건)
		
		int pivot = partition(arr, start, end);
		
		quickSort(arr, start, pivot-1); // 재귀, pivot 기준으로 왼쪽(작은 부분)
		quickSort(arr, pivot+1, end); // 재귀, 기준으로 오른쪽(큰 부분) 
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 입력 처리 //
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(bf.readLine()); 
		int [] arr = new int [N];
		for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(bf.readLine());

		// 정렬
		quickSort(arr, 0 , N-1);

		System.out.println(Arrays.toString(arr));
	}

}
