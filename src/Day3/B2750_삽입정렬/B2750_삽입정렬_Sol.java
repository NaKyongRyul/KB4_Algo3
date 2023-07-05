package Day3.B2750_삽입정렬;

import java.util.Arrays;
import java.util.Scanner;

public class B2750_삽입정렬_Sol {
	
	static void swap(int [] arr , int i , int j ) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	static void insertSort(int [] arr) {
		int N = arr.length;
		for(int i=1; i<N; i++) {
			int insertIdx = i;
			int insertValue = arr[i];
			
			int j = i-1;
			while(true) {
				if(j==-1 || arr[j] < insertValue) {
					insertIdx = j+1;
					break;
				}
				arr[j+1] = arr[j];
				j--;
			}
			arr[insertIdx] = insertValue;
		}
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int [] arr = new int [N];
		for(int i=0; i<N; i++) arr[i] = sc.nextInt();
		
		insertSort(arr);
		
		for(int i=0; i<N; i++) System.out.println(arr[i]);
		
		
	}

}

