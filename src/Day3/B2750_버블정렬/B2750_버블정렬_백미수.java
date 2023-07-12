package Day3.B2750_��������;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2750_��������_��̼� {
	public static void swap(int[] arr, int i, int j) {
			
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
		
		public static void main(String[] args) throws NumberFormatException, IOException {
		
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			
			int N = Integer.parseInt(reader.readLine());
			
			int[] arr = new int[N];
			for(int i =0; i<N; i++) {
				arr[i] = Integer.parseInt(reader.readLine());
			}
			
			for(int i =0; i<N; i++) {
				
				for(int j =0; j<N-i-1; j++) {
					if(arr[j]>arr[j+1]) {
						swap(arr, j, j+1);
					}
				}
			}
			
			for(int i =0; i<N; i++) {
				System.out.println(arr[i]);
			}
		}
}
