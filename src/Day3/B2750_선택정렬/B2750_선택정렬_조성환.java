package Day3.B2750_선택정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2750_선택정렬_조성환 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int [] arr = new int [N];
		
		for(int i =  0 ; i < N ; i++) {
			arr[i] = Integer.parseInt(bf.readLine());
		}
		
		for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i; j < N; j++) {
                if (arr[min]>arr[j]) min = j;
            }
            int temp = arr[i]; 
            arr[i] = arr[min]; 
            arr[min] = temp;  
        }
		

		for(int i =  0 ; i < N ; i++) {
			System.out.println(arr[i]);
		}
	}

}
