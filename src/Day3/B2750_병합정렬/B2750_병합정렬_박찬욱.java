package Day3.B2750_병합정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B2750_병합정렬_박찬욱 {
	
	public static void mergeSort(int [] arr, int [] temp, int start , int end) { // 배열, 시작점(왼쪽), 끝점(오른쪽)
		if(start >= end) return; // 엇갈리지 않기 전까지 반복(종료조건)
		int mid = (start + end) / 2; // 왼쪽과 오른쪽으로 나누는 분기점
		
		// 분할 코드 //
		mergeSort(arr, temp, start, mid); // 재귀, 절반만큼 왼쪽 부분 분할
		mergeSort(arr, temp, mid + 1, end); // 재귀, 절반만큼 오른쪽 부분 분할
		
		// 병합코드 //
		int left = start; // 왼쪽 부분의 인덱스
		int right = mid + 1; // 오른쪽 부분의 인덱스
		int index = start; // 
		
		 // index++는 배열내용을 차지하면, temp의 다음 index로 넘어간다.
		 // left++, right++는 arr의 내용이 temp에 추가되면 다음 넘어가는 것이다.
		while(left <= mid || right <= end) { // 인덱스가 범위를 넘지 않도록 하기 위한 장치 
			if(left > mid) // 왼쪽 부분의 배열이 없는 경우
				temp[index++] = arr[right++]; // 오른쪽 부분을 temp 배열에 추가한다.
			
			else if(right > end) // 오른쪽 부분의 배열이 없는 경우
				temp[index++] = arr[left++]; // 왼쪽 부분을 temp 배열에 추가한다.
			
			else if(arr[left] > arr[right]) // 왼쪽 값이 오른쪽보다 큰 경우
				temp[index++] = arr[right++]; // 오른쪽 부분을 temp 배열에 추가한다.
			
			else if(arr[left] < arr[right]) // 왼쪽 값이 오른쪽보다 작은 경우
				temp[index++] = arr[left++]; // 왼쪽 부분을 temp 배열에 추가한다.
		}
		
		for(int i = start; i < end + 1; i++) arr[i] = temp[i]; // 정렬된 배열 temp를 arr로 이송
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 입력 처리 //
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(bf.readLine()); 
		int [] arr = new int [N]; // 정렬할 배열
		for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(bf.readLine());
		
		int [] temp = new int [arr.length]; // 졍렬된 배열을 넣기 위한 배열
		
		// 정렬
		mergeSort(arr, temp, 0 , arr.length-1);

		System.out.println(Arrays.toString(arr));
	}

}
