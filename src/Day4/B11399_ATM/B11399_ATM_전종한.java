package Day4.B11399_ATM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B11399_ATM_전종한 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		String [] strs = bf.readLine().split(" ");
		int [] arr = new int [N];
		arr[0] = 0;
		for(int i=0; i<N; i++) arr[i] = Integer.parseInt(strs[i]);
		
		quickSort(arr, 0, N-1);
		
		int total = 0;
		int result = 0;
		for(int i=0; i<N; i++) {
			total += arr[i];
			result += total;
		}
		
		System.out.println(result);
		
	}
	public static void swap(int [] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	
	public static void quickSort(int [] arr, int start, int end) {
		if(start >= end) return ;
		
		int pivot = start;
		int left = start + 1;
		int right = end;
		
		while(left <= right) {
			
			while(left <= right && arr[left] <= arr[pivot]) left ++;
			while(left <= right && arr[right] >= arr[pivot]) right --;
			if(left >= right) {
				swap(arr, right, pivot);
				break;
			}else {
				swap(arr, left, right);
			}
		}
		quickSort(arr, start, right-1);
		quickSort(arr, right+1, end);
	}
}
