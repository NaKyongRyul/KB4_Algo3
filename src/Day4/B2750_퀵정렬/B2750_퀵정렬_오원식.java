package Day4.B2750_퀵정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2750_퀵정렬_오원식 {
	
	public static void sort(int arr[], int i, int j) {
		if(i >= j)
			return;
		
		int mid = partition(arr, i, j);
		
		sort(arr, i, mid-1);
		sort(arr, mid, j);
	}
	
	public static int partition(int [] arr, int i, int j) {
		int pivot = arr[(i + j) / 2];
		while(i <= j) {
			while(arr[i] < pivot) 
				i++;
			while(arr[j] > pivot) 
				j--;
			
			if(i <= j) {
				swap(arr, i, j);
				i++;
				j--;
			}
		}
		return i;
	}
	
	public static void swap(int [] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int [] arr = new int[N];
		
		for(int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(br.readLine());
		
		sort(arr, 0, arr.length-1);
		
		for(int i = 0; i < N; i++)
			System.out.println(arr[i]);
	}

}
