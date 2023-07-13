package Day4.B2750_병합정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B2750_병합정렬_전종한 {
	public static int [] arr;
	public static int [] tmp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		arr = new int [N];
		tmp = new int [N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(bf.readLine());
		}

		mergeSort(0, N-1);

		System.out.println(Arrays.toString(arr));

	}

	public static void mergeSort(int start, int end) {
		if(start >= end) return;

		int mid = (start + end)/2;

		mergeSort(start, mid);
		mergeSort(mid+1, end);

		// 병합
		int left = start;
		int right = mid+1;
		int idx = start;

		// 정렬
		while(left <= mid && right <= end) {
			if(arr[left] < arr[right])  {
				tmp[idx++] = arr[left++];
			}else {
				tmp[idx++] = arr[right++];
			}
		}
		// 왼쪽이 정렬 끝났을떄
		if(left > mid) {
			for(int i=right; i<=end; i++) {
				tmp[idx++]=arr[right++];
			}
		}else { // 오른쪽이 정렬 끝났을떄
			for(int i=left; i<=mid; i++) {
				tmp[idx++] = arr[left++];
			}
		}

		for(int i=start;i<=end;i++) {
			arr[i] = tmp[i];
		}

	}
}	
