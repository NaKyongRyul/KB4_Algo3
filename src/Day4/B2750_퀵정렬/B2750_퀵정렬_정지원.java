package Day4.B2750_퀵정렬;

import java.util.Scanner;

public class B2750_퀵정렬_정지원 {
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static int partition(int[] arr, int left, int right){
		int pivot = arr[left];
		int lp = left; int rp = right;
		
		
		while(lp<rp) {
			while(arr[rp]>=pivot&&rp>lp) {
				rp--;
			}
			while(arr[lp]<=pivot&&lp<rp) {
				lp++;
			}
			
			swap(arr, lp, rp);
		}
		
		
		swap(arr, left, rp);
		
		
		
		return rp;
		
	}
	
	public static void quicksort(int[] arr, int left, int right) {
		if(left>=right) {return;}
		
		else {
			int pivot = partition(arr, left, right);
			
			
			quicksort(arr, left, pivot-1);
			quicksort(arr, pivot+1, right);
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] arr = new int [n];
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		
		
		quicksort(arr, 0, n-1);
		
		for(int i=0;i<n;i++) {
			System.out.println(arr[i]);
		}
		
	}
}
