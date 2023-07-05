package Day3.B2750_병합정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2750_병합정렬_길민지 {
	public static void swap(int [] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
    
	public static void mergeSort(int[] arr, int left, int right) {
		if(left>=right) return;
		int center = (left+right)/2;
		
		// Divide
		mergeSort(arr, left, center);
		mergeSort(arr, center+1, right);
		
		// Conquer
		int leftIdx = left;
		int rightIdx = center+1;
		int currIdx = left;
		int tmp[] = new int[right-left+1];
		
		for (int i=0; i<right-left+1;i++) {
			tmp[i] = arr[left+i];
		}
		
		while(currIdx<right+1) {
			if (leftIdx>center) 
				arr[currIdx++] = tmp[(rightIdx++)-left]; 
			else if (rightIdx>right) 
				arr[currIdx++] = tmp[(leftIdx++) - left]; 
			else if (tmp[leftIdx-left]<tmp[rightIdx-left]) 
				arr[currIdx++] = tmp[(leftIdx++)-left]; 
			else
				arr[currIdx++] = tmp[(rightIdx++)-left]; 
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		
		int [] arr = new int [N];
		
		for (int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(bf.readLine());
		}
		mergeSort(arr, 0, N-1);
		
		for (int i=0; i<N; i++) {
			System.out.println(arr[i]);
		}
	}
}