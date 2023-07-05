package Day3.B2750_퀵정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B2750_퀵정렬_김혜인 {

		public static void swap(int[] arr, int i, int j) {
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			
		}
		
	
		public static int partition(int[] arr, int left, int right) {
			int pivot = left;
			int l = left+1;
			int r = right;
			
			while(l <=r) { //left-right �������� ���� ���� ����
				while ( l<=r && arr[l]<=arr[pivot]) {
					l++;
				}
				while ( l<=r && arr[r]>=arr[pivot] ) {
					r--;
				}
				
				//�� �κ� �ٽ� ����
				if(l>r) 
					swap(arr, r, pivot); //���������, right�� left�ռ� ���
				else 
					swap(arr, l, r); //left, right ã�� ���
			}
			
			return r;
	}
		
		//��� �κ�(�ڱ� �Լ��� �ѹ� �� ���). �̺κ� �ٽ� ����
		public static void quickSort(int []arr, int left, int right) {
			//��Ϳ��� �������� �ʼ�
			if(left >=right ) return;
			
			int pivot = partition(arr, left, right);
			
			quickSort(arr, left, pivot-1);
			quickSort(arr, pivot+1, right);
			
		}
		
		
		public static void main(String[] args) throws IOException {
			/* �Է� ó�� */
			
		
			int [] arr = {5,2,7,1,9,6,8};
			System.out.println(Arrays.toString(arr));
			quickSort(arr, 0 , arr.length-1);
			System.out.println(Arrays.toString(arr));
		}

}
