package Day1.B10807_개수세기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class B10807_개수세기_전민형 {

	public static void main(String[] args) throws NumberFormatException, IOException {
//		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(reader.readLine());
//		System.out.println(N);

		int [] arr = new int [N];
		
		String str = reader.readLine();
		String [] strs = str.split(" ");  //.split -> 문자열 기준으로 쪼갬
		int a = Integer.parseInt(reader.readLine());
		int cnt = 0;
		
		for(int i = 0; i<strs.length; i++) {
			arr[i] = Integer.parseInt(strs[i]);
			if(arr[i]==a) {
				cnt++;
			}
		}
		
		System.out.println(cnt);

	}

}
