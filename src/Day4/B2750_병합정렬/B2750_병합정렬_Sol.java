
package Day4.B2750_병합정렬;

import java.util.Arrays;
import java.util.Scanner;

public class B2750_병합정렬_Sol {
	
	public static void mergeSort(int [] arr , int [] tmp , int start , int end) {
		
		System.out.println(Arrays.toString(arr));
		// 종료조건
		if(start >= end) return;
		
		// 중앙값 계산
		int mid = (start + end)/2;
		
		// 확장
		mergeSort(arr , tmp , start , mid);
		mergeSort(arr, tmp , mid + 1 , end);
		
		
		// 병합로직 //
		
		// 왼쪽 부분배열 포인터
		int p = start;
		
		// 오른쪽 부분배열 포인터
		int q = mid+1;
		
		// 병합시키는데 사용할 포인터
		int idx = start;
		
		// idx 를 기준으로 탐색
		while(idx <= end) {
			
			// 오른쪽 포인터가 가르키는 값이 더 작은 경우
			if(arr[p] >= arr[q]) {
				tmp[idx] = arr[q];
				q++;
			}
			
			// 왼쪽 포인터가 가르키는 값이 더 작은 경우
			else if(arr[p] < arr[q]){
				tmp[idx] = arr[p];
				p++;
			}
			
			// 왼쪽 배열을 전부 사용한 경우
			else if(p > mid) {
				tmp[idx] = arr[q];
				q++;
			}
			
			// 오른쪽 배열을 전부 사용한 경우
			else if(q > end) {
				tmp[idx] = arr[p++];
			}
			
			idx++;
		}
		
		for(int i = start; i <end+1; i++)
			arr[i] = tmp[i];
		
		////////////
		
	}
	
	
	public static void main(String[] args) {
		
//		int [] arr = {4, 2 , 9 ,1, 7, 8 , 0,3};

		
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
		int [] arr = new int [N];
        int [] tmp = new int [N];
        for(int i=0; i<N; i++) arr[i] = sc.nextInt();
        
		mergeSort(arr , tmp , 0, arr.length-1);
		

	}
}