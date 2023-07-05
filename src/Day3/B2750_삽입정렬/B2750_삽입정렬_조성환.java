package Day3.B2750_삽입정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2750_삽입정렬_조성환 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int [] arr = new int [N];
		
		for(int i =  0 ; i < N ; i++) {
			arr[i] = Integer.parseInt(bf.readLine());
		}
		
		for (int i = 0; i < N - 1; i++) {
            int j = i;
            while(j >= 0 && arr[j] > arr[j+1]) {
            	int temp = arr[j]; 
            	arr[j] = arr[j+1]; 
            	arr[j+1] = temp;  
            	j--;
            }
        }
		
		for(int i =  0 ; i < N ; i++) {
			System.out.println(arr[i]);
		}
	}
}
