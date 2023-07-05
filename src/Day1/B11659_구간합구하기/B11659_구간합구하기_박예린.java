package Day1.B11659_구간합구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11659_구간합구하기_박예린 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String s = bf.readLine();
		
		StringTokenizer token = new StringTokenizer(s , " ");
		int N = Integer.parseInt(token.nextToken());
		int M = Integer.parseInt(token.nextToken());
		
		int [] arr = new int [N];
		int [] sum = new int [N];

		int res = 0;

	    String[] line = bf.readLine().split(" "); // 첫 번째 라인을 받고 공백을 기준으로 나누기

		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(line[i]);
			if(i > 0) {
				sum[i] = sum[i-1] + arr[i];
			} else {
				sum[i] += arr[i];
			}
			
		}
		

		for(int i=0; i<M; i++) {
			
		    String[] line2 = bf.readLine().split(" "); // 첫 번째 라인을 받고 공백을 기준으로 나누기

			int a = Integer.parseInt(line2[0]);
			int b = Integer.parseInt(line2[1]);
			
			if(b>a) {
				if(a>1) {
					res = sum[b-1] - sum[a-2];
				} else {
					res = sum[b-1];
				}
				
			} else {
				res = arr[a-1];
			}
				
			System.out.println(res);
			res = 0;
		}
		
	}

}
