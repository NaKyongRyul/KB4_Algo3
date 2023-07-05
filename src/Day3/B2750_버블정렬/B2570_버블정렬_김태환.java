package Day3.B2750_버블정렬;

import java.util.Arrays;
import java.util.Scanner;

public class B2570_버블정렬_김태환 {
	
	public static void bubbleSort(int [] arr) {
		
		for(int i=0;i<arr.length;i++) {
		for(int j=0;j<arr.length-1;j++) {
			if(arr[j]>arr[j+1]) {
				int temp =arr[j];
				arr[j]=arr[j+1];
				arr[j+1]=temp;
			}
		}
		
	}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N=sc.nextInt();
		
		int arr [] = new int[N];
		for(int i=0;i<N;i++) {
			arr[i]=sc.nextInt();
		}
		bubbleSort(arr);
		
		
		for(int i=0;i<arr.length;i++) {
			
		System.out.println(arr[i]);
		}
		
	}

}
