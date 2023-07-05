package Day3.B2750_버블정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2750_버블정렬_서은효 {

	public static void swap(int [] arr, int i, int j ) {
	
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	
	}
	
	public static void bubbleSort(int[] new_arr, int n) {
		for(int j =0; j<n-1;j++) {
			for(int i =0; i<n-1 ;i++) {
				if(new_arr[i] > new_arr[i+1])
					swap(new_arr, i, i+1);
				
			
			}
		}

		
	}
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(bf.readLine());
		int [] sortArr = new int[N];
		

		for(int i =0; i<N;i++) {
			sortArr[i] = Integer.parseInt(bf.readLine());
		}
		
		// 정렬
		bubbleSort(sortArr, N);
		for(int x : sortArr)
			System.out.println(x);
	}

}

