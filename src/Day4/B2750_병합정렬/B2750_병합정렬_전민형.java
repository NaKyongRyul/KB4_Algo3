package Day4.B2750_병합정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2750_병합정렬_전민형 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(reader.readLine());
		
		int [] arr = new int [num];
		int [] tmp = new int [num];
		
		for(int i = 0; i<num; i++) {
			arr[i] = Integer.parseInt(reader.readLine());
		}
		
		mergeSort(arr, tmp, 0, num-1);
		for(int i = 0; i<arr.length; i++) {
			System.out.println((arr[i]));
		}
	}
	
	public static void Conquer (int arr[],int tmp[], int left, int right, int center) {
		
		int p = left;
		int q = right;
		int mid = center;
		int idx = left;
		
		
		while(idx<=q) {
			
			if(p>mid) {
					tmp[idx] = arr[mid+1];
					mid++;
			}
			
			else if(mid+1>q) {
					tmp[idx] = arr[p];
					p++;
			}
			
			else if(arr[p]<arr[mid+1]) {
				tmp[idx] = arr[p];
				p++;
				
			}
			
			else if(arr[p]>arr[mid+1]) {
				tmp[idx] = arr[mid+1];
				mid++;
				
			}
			idx++;
		}
		
		for(int i = left; i<=right; i++) {
			arr[i] = tmp[i];
		}
		
		
	}
	
	public static void mergeSort(int arr[], int tmp[], int left, int right) {
		
		if(left >= right) return;
		
		int center = (left + right)/2;
		
		mergeSort(arr, tmp, left, center);
		mergeSort(arr, tmp, center+1, right);
		
		Conquer(arr, tmp, left, right, center);
		
	}

}
