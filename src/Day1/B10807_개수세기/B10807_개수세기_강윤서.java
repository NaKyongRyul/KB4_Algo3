package Day1.B10807_개수세기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B10807_개수세기_강윤서 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int count = 0;
		
		// 정수 개수
		int n =	Integer.parseInt(reader.readLine());
		
		// 정수 목록
		String [] strs = reader.readLine().split(" ");
		
		int [] arr = new int [n];
		
		for(int i=0; i<strs.length; i++) {
			arr[i] = Integer.parseInt(strs[i]);
		}
		
		// 찾으려고 하는 정수
		int v = Integer.parseInt(reader.readLine());
		
		// 개수 세기
		for (int i=0; i<strs.length; i++) {
			if(arr[i]==v) {
				count += 1;
			}
		}
		System.out.println(count);
	}
}
