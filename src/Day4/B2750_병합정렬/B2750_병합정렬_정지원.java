package Day4.B2750_병합정렬;

import java.util.Scanner;

public class B2750_병합정렬_정지원 {
public static void mergesort(int[] arr, int left, int right) {
		
		if(left>=right) {return;}
		
		int center = (left+right)/2;
		
		mergesort(arr, left, center);
		mergesort(arr, center+1, right);
		
		int[] tempArr = new int[right-left+1];
		
		int leftIdx = left;
		int rightIdx = center+1;
		
		if(left<right) {
			for(int i=0;i<(right-left+1);i++){
				if(leftIdx<=center&&rightIdx<=right) {
					if(arr[leftIdx]>arr[rightIdx]) {
						tempArr[i] = arr[rightIdx];
						rightIdx++;
					}
					else {
						tempArr[i] = arr[leftIdx];
						leftIdx++;
					}
				}
				else if(leftIdx>center) {
					tempArr[i] = arr[rightIdx];
					rightIdx++;
				}
				else{
					tempArr[i] = arr[leftIdx];
					leftIdx++;
				}
			}
			for(int i=0;i<(right-left+1);i++) {
				arr[left+i] = tempArr[i];
			}
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] arr = new int [n];
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		
		
		mergesort(arr, 0, n-1);
		
		for(int i=0;i<n;i++) {
			System.out.println(arr[i]);
		}
		
	}
}
