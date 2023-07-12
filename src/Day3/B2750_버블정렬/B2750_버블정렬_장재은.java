package Day3.B2750_버블정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2750_버블정렬_장재은 {
	
	public static void swap(int [] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		int arr [] = new int[n];
		
		for(int i=0; i<n; i++) arr[i] = Integer.parseInt(bf.readLine());
		
		for(int i=0; i<n-1; i++)
			for(int j=0; j<=n-2; j++)
				if(arr[j] > arr[j+1])
					swap(arr, j, j+1);

		for(int a:arr) System.out.println(a);
	}
}