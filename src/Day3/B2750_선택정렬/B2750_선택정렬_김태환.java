+package Day3.B2750_선택정렬;
import java.util.Scanner;

public class B2750_선택정렬_김태환 {
	
	public static void SelectSort(int [] arr) {
		
		for(int i=0;i<arr.length-1;i++) {
			int k=i;
			for(int j=i+1;j<arr.length;j++) {
				if(arr[k]>arr[j]) {
					k=j;
					}
				}
			int c=arr[k];
			arr[k]=arr[i];
			arr[i]=c;
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N=sc.nextInt();
		
		int arr [] = new int[N];
		for(int i=0;i<N;i++) {
			arr[i]=sc.nextInt();
		}
		SelectSort(arr);
		
		
		for(int i=0;i<arr.length;i++) {
			
		System.out.println(arr[i]);
		}
		
	}

}

