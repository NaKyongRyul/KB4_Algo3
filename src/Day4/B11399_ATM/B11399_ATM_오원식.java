package Day4.B11399_ATM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B11399_ATM_오원식 {
	
	public static void main(String[] args) throws NumberFormatException, IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String s = br.readLine();
		String [] str = s.split(" ");
		
		int[] arr = new int[N];
		for(int i=0; i < N; i++)
			arr[i] = Integer.parseInt(str[i]);
		
		Arrays.sort(arr);
		
		int ans = 0;
		
		for(int i = 0; i < N; i++) {
			int sum = 0;
			for(int j = 0; j < i+1; j++)
				sum += arr[j];
			ans += sum;
		}
		
		System.out.println(ans);
		
	}

}
