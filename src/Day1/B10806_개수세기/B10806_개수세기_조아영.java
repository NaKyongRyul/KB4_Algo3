package Day1.B10806_개수세기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B10806_개수세기_조아영 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		//bf.readLine() 문자열을 정수형으로 변환
		int n = Integer.parseInt(bf.readLine());		
		
		//StringTokenizer(,구분자)
		StringTokenizer token = new StringTokenizer(bf.readLine());
		
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(token.nextToken());
		}
		
		int v = Integer.parseInt(bf.readLine());
		
		int ans = 0;
		for(int i = 0; i<n; i++) {
			if(v == arr[i]) {
				ans++;
			}		
		}		
		System.out.println(ans);

	}

}
