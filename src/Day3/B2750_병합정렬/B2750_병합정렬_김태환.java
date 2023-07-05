package Day3.B2750_병합정렬;

import java.util.Arrays;
import java.util.Scanner;

public class B2750_병합정렬_김태환 {

		public static void swap(int [] arr, int i , int j) {
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;		
		}
		
		public static void merge(int [] arr,int left, int mid,int right) {
			int[] leftArr=Arrays.copyOfRange(arr, left, mid+1);
			int[] rightArr=Arrays.copyOfRange(arr, mid+1, right+1);
			int i = 0;
			int j = 0;
			int k =left;
			
			while(leftArr.length>i && rightArr.length>j) {
				if(leftArr[i]<rightArr[j]) {
					arr[k]=leftArr[i];
					i++;
					k++;
				}
				else {
					arr[k]=rightArr[j];
					j++;
					k++;
				}
			}
			while(i<leftArr.length) {
				arr[k]=leftArr[i];
				i++;
				k++;
			}
			while(j<rightArr.length) {
				arr[k]=rightArr[j];
				j++;
				k++;
			}
		}

		public static void mergeSort(int [] arr,int left, int right) {
			
			//종료조건
			if(left>=right) return;
			
			int mid=(left+right)/2;
			
			mergeSort(arr,left,mid);
			mergeSort(arr,mid+1,right);
			merge(arr,left,mid,right);
			
		}
			


		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			
			int N=sc.nextInt();
			
			int arr [] = new int[N];
			
			for(int i=0;i<N;i++) {
				arr[i]=sc.nextInt();
			}
			sc.close();
			mergeSort(arr,0,arr.length-1);
			
			
			for(int i=0;i<arr.length;i++) {
				
			System.out.println(arr[i]);
			}
			
		}

	}
