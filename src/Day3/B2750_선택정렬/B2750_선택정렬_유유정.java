package Day3.B2750_선택정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2750_선택정렬_유유정 {
	
	public static void swap(int [] arr, int i, int j) {
		int temp = arr[i];
		arr[i]= arr[j];
		arr[j]=temp;
	}
	
	public static void selectsort(int []arr) {
		for(int i=0;i<arr.length;i++) {
			int minNum =i;
			for(int j=minNum;j<arr.length;j++) {
				if(arr[minNum]>arr[j])
					minNum = j;
					
			}
			swap(arr,i,minNum);
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int [] arr = new int [N];
		
		for(int i=0;i<N;i++)
			arr[i]= Integer.parseInt(bf.readLine());
		
		selectsort(arr);
		
		for(int i=0;i<N;i++)
			System.out.println(arr[i]);
	}

}
