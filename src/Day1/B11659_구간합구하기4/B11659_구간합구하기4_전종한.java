package Day1.B11659_구간합구하기4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B11659_구간합구하기4_전종한 {
	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		String [] arr = reader.readLine().split(" ");
		int N = Integer.parseInt(arr[0]); int M = Integer.parseInt(arr[1]);

		arr = reader.readLine().split(" ");
		int [] numArr = new int [N+1];
		numArr[0] = 0;
		for(int i = 1; i< N+1; i++) {
			numArr[i] = numArr[i-1] + Integer.parseInt(arr[i-1]);
		}


		for(int j = 0; j<M; j++) {
			arr = reader.readLine().split(" ");

			System.out.println(numArr[Integer.parseInt(arr[1])] - numArr[Integer.parseInt(arr[0])-1]);
		}		
	}
}
