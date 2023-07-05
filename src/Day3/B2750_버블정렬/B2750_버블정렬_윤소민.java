package Day3.B2750_버블정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2750_버블정렬_윤소민 {

	public static void swap(int []arr, int a, int b) {
		int temp = arr[a];
		arr[a]=arr[b];
		arr[b]= temp;
	}
	public static void bubbleSort(int [] arr) {
		int N=arr.length;
		for(int j=0;j<N;j++) {
			for(int i=0;i<N-1-j;i++) {
				if(arr[i]>arr[i+1]) {
					swap(arr,i,i+1);
				}
			}
		}
		
	}
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(bf.readLine());
		
		int [] arr = new int[N];

		for(int i=0;i<N;i++) {
			arr[i]= Integer.parseInt(bf.readLine());
		}
		bubbleSort(arr);
		for(int i:arr) {
			System.out.println(i);
		}
		
	}

}