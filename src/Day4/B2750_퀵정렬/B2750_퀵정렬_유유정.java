package Day4.B2750_퀵정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B2750_퀵정렬_유유정 {
	
	public static int N;
	public static void swap(int [] arr, int i, int j) {
		int temp = arr[i];
		arr[i]= arr[j];
		arr[j]=temp;
	}
	
	
	public static int partition(int [] arr, int left, int right) {
		int pivotIndex = left;
		int pivot = arr[pivotIndex];
		left ++;
		while(left <= right) {
			
			while(left <= right && arr[left] <= pivot)
				left++;
			while(left <= right && arr[right] >= pivot)
				right--;
			if(left <= right) {
				swap(arr,left,right);
			}
			else {
					swap(arr,pivotIndex,right);
					pivotIndex = right;
			}
		}

		return pivotIndex;
	}
	
	public static void quicksort(int []arr,int left, int right) {
		if(left >= right)
			return;
		int pivotIndex = partition(arr,left,right);
		quicksort(arr,left,pivotIndex-1);
		quicksort(arr,pivotIndex+1,right);
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		int [] arr = new int [N];
		
		for(int i=0;i<N;i++) 
			arr[i]= Integer.parseInt(bf.readLine());
		

		quicksort(arr,0,arr.length-1);
		for(int i=0;i<N;i++)
			System.out.println(arr[i]);
	}

}
