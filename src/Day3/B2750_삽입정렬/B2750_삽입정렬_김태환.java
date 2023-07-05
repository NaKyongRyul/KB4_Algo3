package Day3.B2750_삽입정렬;

import java.util.Scanner;

public class B2750_삽입정렬_김태환{

		public static void InsertSort(int [] arr) {

			
			for(int i=1;i<arr.length;i++) {
				int k=arr[i];
				int c =i-1;
				
			while(c>=0 && arr[c] > k) {
				arr[c+1]=arr[c];
				c-=1;
			}
			arr[c+1]=k;
				}
			
		}
		
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			
			int N=sc.nextInt();
			
			int arr [] = new int[N];
			for(int i=0;i<N;i++) {
				arr[i]=sc.nextInt();
			}
			InsertSort(arr);
			
			
			for(int i=0;i<arr.length;i++) {
				
			System.out.println(arr[i]);
			}
			
		}

	}
