package Day3.B2750_선택정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2750_선택정렬_윤소민 {

	public static void swap(int []arr, int a, int b) {
		int temp = arr[a];
		arr[a]=arr[b];
		arr[b]= temp;
	}
	
	public static void selectSort(int [] arr) {
		int N=arr.length;
		
		
		for(int j=0;j<N-1;j++) {
			int min =arr[j] ;
			int idx = j;
			for(int i=j;i<N;i++) {
				if(min>arr[i]) {
					min = arr[i];
					idx = i;
				}
			}swap(arr,j,idx);
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(bf.readLine());
		
		int [] arr = new int[N];

		for(int i=0;i<N;i++) {
			arr[i]= Integer.parseInt(bf.readLine());
		}
		selectSort(arr);
		for(int i:arr) {
			System.out.println(i);
		}

	}

}
