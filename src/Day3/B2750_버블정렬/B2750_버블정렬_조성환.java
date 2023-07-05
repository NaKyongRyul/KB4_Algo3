package Day3.B2750_버블정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2750_버블정렬_조성환 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int [] arr = new int [N];
		
		for(int i =  0 ; i < N ; i++) {
			arr[i] = Integer.parseInt(bf.readLine());
		}
		for(int i =  0 ; i < N ; i++) {
			for(int j =  0 ; j < N-1 ; j++) {
				if(arr[j] > arr[j+1]) {
					int temp = arr[j+1];
					arr[j+1] = arr[j];
					arr[j] = temp;
				}
			}
		}
		for(int i =  0 ; i < N ; i++) {
			System.out.println(arr[i]);
		}
	}

}
