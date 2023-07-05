package Day3.B2750_선택정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B2750_선택정렬_서은효 {


		public static void swap(int [] arr, int i, int j ) {
			
			int tmp = arr[i];
			arr[i] = arr[j];
			arr[j] = tmp;
		
		}
		
		public static void selectionSort(int[] new_arr, int n) {

			int index = 0;
			
			for(int j = 0; j<n-1 ;j++) {
				
				int min = new_arr[j];
				
				for(int i =j+1; i<n; i++) {
					if (min > new_arr[i]) {
						min = new_arr[i];
						index = i;
						swap(new_arr, j, index);
					}	
				}
				
				
			}
			
		}
		
		
		public static void main(String[] args) throws IOException {
			
			BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
			
			int N = Integer.parseInt(bf.readLine());
			int [] sortArr = new int[N];
			

			for(int i =0; i<N;i++) {
				sortArr[i] = Integer.parseInt(bf.readLine());
			}
			
			// 정렬
			selectionSort(sortArr, N);
			for(int x : sortArr)
				System.out.println(x);
		}

	}

