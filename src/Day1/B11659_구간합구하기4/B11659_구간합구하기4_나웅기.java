package Day1.B11659_구간합구하기4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B11659_구간합구하기4_나웅기 {
	public static void main(String[] args) throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		String str = reader.readLine();
		String [] arr = str.split(" ");
		int N = Integer.parseInt(arr[0]), M = Integer.parseInt(arr[1]);
		
		str = reader.readLine();
		arr = str.split(" ");
		int [] intArr = new int [N];
		int [] sumArr = new int [N+1];
		int sum_arr = 0;
		for (int i = 0; i<N; i++) {
			intArr[i] = Integer.parseInt(arr[i]);
			sum_arr += intArr[i];
			sumArr[i+1] = sum_arr;
		}
		for (int i = 0; i<M; i++) {
			String ran = reader.readLine();
			String [] arr1 = ran.split(" ");
			int x = Integer.parseInt(arr1[0]), y = Integer.parseInt(arr1[1]);
			System.out.println(sumArr[y]- sumArr[x-1]);
			
		}
	}
}
