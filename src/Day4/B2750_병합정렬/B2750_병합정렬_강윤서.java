package Day4.B2750_병합정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2750_병합정렬_강윤서 {
	public static int[] mergeSort(int [] arr, int start, int end) {
		if (start>=end) {
			int [] result = {arr[start]};
			return result;
		}
		
		// Divide-분할
		int center = (start+end)/2;
		int[] leftList = mergeSort(arr, start, center); // 왼쪽 리스트
		int[] rightList = mergeSort(arr, center+1, end); // 오른쪽 리스트
		
		// Conquer-정복(병합)
		int left = 0;
		int right = 0;
		int [] result = new int[end-start+1]; // 병합 결과
		
		for (int i=0; i<end-start+1; i++) {
			if (left>=leftList.length) { // 왼쪽 리스트가 모두 병합된 경우->오른쪽 리스트 값 삽입
				result[i] = rightList[right];
				right++;
			} else if (right>=rightList.length) { // 오른쪽 리스트가 모두 병합된 경우->왼쪽 리스트 값 삽입
				result[i] = leftList[left];
				left++;
			} else if (left<leftList.length && leftList[left]<=rightList[right]) { // 왼쪽 리스트의 값이 더 작거나 같은 경우->왼쪽 리스트 값 삽입
				result[i] = leftList[left];
				left++;
			} else if (right<rightList.length && leftList[left]>rightList[right]){ // 오른쪽 리스트의 값이 더 작은 경우->오른쪽 리스트 값 삽입
				result[i] = rightList[right];
				right++;
			}
		}
		return result; // 병합 결과
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		// 수 입력
		int [] numList = new int[n];
		for (int i=0; i<n; i++) {
			numList[i] = Integer.parseInt(br.readLine());
		}
		
		// 병합 정렬
		numList = mergeSort(numList, 0, n-1);
		
		// 결과 출력
		for (int i=0; i<n; i++) {
			System.out.println(numList[i]);
		}
	}
}
