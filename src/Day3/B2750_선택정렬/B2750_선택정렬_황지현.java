
import java.util.Scanner;


public class B2750_선택정렬_황지현 {
	
	static void swap(int [] arr , int i , int j ) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	static void selectionSort(int [] arr) {
		int N=arr.length;
		
		for(int i=0;i<N-1;i++) {
			int minIdx=i;// 최소값 위치 초기화
			for (int j=i+1;j<N;j++) {
				if (arr[j]<arr[minIdx]) { 
					minIdx=j;
					}
				swap(arr,minIdx,i);
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int [] arr=new int[n];
		for(int i=0;i<n;i++) {arr[i]=sc.nextInt();}
		selectionSort(arr);
		
		for(int i=0;i<n;i++) {System.out.println(arr[i]);}
	}
}
