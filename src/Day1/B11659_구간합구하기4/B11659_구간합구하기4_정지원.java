package Day1.B11659_구간합구하기4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B11659_구간합구하기4_정지원 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n, m;
		int sum = 0;
		
		String[] strs = br.readLine().split(" ");
		
		n = Integer.parseInt(strs[0]);
		m = Integer.parseInt(strs[1]);
		
		strs = br.readLine().split(" ");
		
		int[] arr = new int[n];
		
		arr[0] = Integer.parseInt(strs[0]);
		
		for(int i=1;i<n;i++) {
			arr[i] = Integer.parseInt(strs[i])+arr[i-1];
		}

		
		for(int j=0;j<m;j++) {
			sum = 0;
			strs = br.readLine().split(" ");
			if(Integer.parseInt(strs[0])==1) {
				sum = arr[Integer.parseInt(strs[1])-1];
			}
			else {
				sum = arr[Integer.parseInt(strs[1])-1] - arr[Integer.parseInt(strs[0])-2];
			}
			
			System.out.println(sum);
			
		}
	
	}

}
