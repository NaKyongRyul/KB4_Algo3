package Day1.B11659_구간합구하기4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B11659_구간합구하기4_김현지 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		// M, N
		String str = reader.readLine();
		String [] strs = str.split(" ");
		int N = Integer.parseInt(strs[0]);
		int M = Integer.parseInt(strs[1]);
		
		// 주어진 N개의 수
		String number = reader.readLine();
		String [] numberString = number.split(" ");
		
		int [] arr = new int [N];
		for (int i=0; i<numberString.length; i++) {
			arr[i] = Integer.parseInt(numberString[i]);
		}
		
		// from to
		int [][] arr2 = new int [M][2];
		for (int j=0; j<M; j++) {
			String fromTo = reader.readLine();
			String [] fromTo1String = fromTo.split(" ");
			arr2[j][0] = Integer.parseInt(fromTo1String[0]);
			arr2[j][1] = Integer.parseInt(fromTo1String[1]);
		}
		
		for (int j=0; j<M; j++) {
			int sum = 0;
			for (int k=arr2[j][0]-1; k<arr2[j][1]; k++) {
				sum += Integer.parseInt(numberString[k]);
			}
			System.out.println(sum);
		}
	
		
		

	}

}
