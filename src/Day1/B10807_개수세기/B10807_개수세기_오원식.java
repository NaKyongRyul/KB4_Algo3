package Day1.B10807_개수세기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B10807_개수세기_오원식 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		
		String str = reader.readLine();
		String []  strs =  str.split(" ");
		
		int [] arr = new int[N];
		
		for(int i = 0; i < strs.length; i++) {
			arr[i] = Integer.parseInt(strs[i]);
		}
		
		str = reader.readLine();
		int v = Integer.parseInt(str);
		
		int cnt = 0;
		
		for(int i = 0; i<N; i++) {
			if(arr[i] == v) {
				cnt += 1;
			}
		}
		
		System.out.println(cnt);
	}
}
