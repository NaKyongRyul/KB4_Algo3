package Day3.B2750_퀵정렬;

import java.util.Scanner;

public class B2750_퀵정렬_김태환 {

		public static void swap(int [] arr, int i , int j) {
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;		
		}
		
		public static int partition(int [] arr,int start, int end) {
			int pivot = start;
			int left=start+1;
			int right = end;
			
			while(left<=right) {
				while(left<=right && arr[left]<=arr[pivot]) left++;
				while(left<=right && arr[right]>=arr[pivot]) right--;
				
				if(left>right) {
					swap(arr,right,pivot);
				}
				else {
					swap(arr,left,right);
				}
			}
			return right;
		}
		
		public static void quickSort(int [] arr,int start, int end) {
			
	
			//종료조건
			if(start>=end) return;
			
			int pivot=partition(arr,start,end);
			
			quickSort(arr,start,pivot-1);
			quickSort(arr,pivot+1,end);
		}
			


		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			
			int N=sc.nextInt();
			
			int arr [] = new int[N];
			
			for(int i=0;i<N;i++) {
				arr[i]=sc.nextInt();
			}
			sc.close();
			quickSort(arr,0,arr.length-1);
			
			
			for(int i=0;i<arr.length;i++) {
				
			System.out.println(arr[i]);
			}
			
		}

	}
