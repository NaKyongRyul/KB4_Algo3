package Day4.B2750_병합정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B2750_병합정렬_유유정 {
	
	public static void mergeSort(int []arr,int left,int right) {
		if(left >= right) 
			return ;
		int center = (left+right)/2;	

		mergeSort(arr,left,center);
		mergeSort(arr,center+1,right);
		int [] copy = new int [arr.length];
		int i=left;
		int index01 = left;
		int index02 = center+1;
		while(index01 <= center && index02 <= right) {
			
			if(arr[index01] <= arr[index02])
				copy[i++]= arr[index01++];
			
			else if(arr[index01] > arr[index02])
				copy[i++]= arr[index02++];	
			
			
		}
		if(index02 > right) {
			while (index01 <= center)
				copy[i++] = arr[index01++];
			
		}
		else {
			while (index02 <= right) 
				copy[i++] =arr[index02++];	
		}
		for(int n= left; n<=right;n++)
			arr[n]= copy[n];
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int [] arr = new int [N];
		
		for(int i=0;i<N;i++)
			arr[i]= Integer.parseInt(bf.readLine());
		
		mergeSort(arr,0,N-1);
		
		for(int i=0;i<N;i++)
			System.out.println(arr[i]);
	}
}
