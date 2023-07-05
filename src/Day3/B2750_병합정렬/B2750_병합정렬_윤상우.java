package Day3.B2750_병합정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2750_병합정렬_윤상우 {

	public static void swap(int [] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static int[] partition(int [] arr, int start, int end) {
		int res [] = new int [end - start];
		
		for(int i = start; i<end; i++) {
			res[i-start] = arr[i];
		}
		return res;
	}
	
	public static void mergeSort(int [] arr, int left, int right) {
		// 재귀는 종료 조건이 꼭 필요하다!
		if(left >= right) return;
		
		int center = (left + right) / 2;
		
		mergeSort(arr, left, center);
		mergeSort(arr, center+1, right);
		
		int [] res = new int [arr.length];
		
		int p = left;
		int q = center + 1;
		int idx = left;
		
		while(p <= center && q <= right) {
			
			if(arr[p] > arr[q]) {
				res[idx] = arr[q];
				q++;
			}else {
				res[idx] = arr[p];
				p++;
			}
			idx++;
		}
		
		if(p>center) {
			for(int i=q; i<right; i++) {
				res[idx] = arr[i];
				idx++;
			}
		}else {
			for(int i=p; i<center+1; i++) {
				res[idx] = arr[i];
				idx++;
			}
		}
		
		for(int i=left; i<=right; i++) {
			arr[i] = res[i];
		}
		
		
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int arr [] = new int [n];
	
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(bf.readLine());
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int start = 0;
		int end = n-1;
		
		mergeSort(arr, start, end);
		
		for(int i=0; i<n; i++) {
			System.out.println(arr[i]);
		}
	}
}
