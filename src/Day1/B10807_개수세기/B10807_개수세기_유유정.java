package Day1.B10807_개수세기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B10807_개수세기_유유정 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		String [] strs = str.split(" ");// string 배열로 나옴
		int v = Integer.parseInt(br.readLine());
		int a;
		int count =0;
		for(int i=0; i<strs.length;i++) {
			a = Integer.parseInt(strs[i]);
			if(a == v)
				count ++;
		}
	System.out.println(count);	
	}
}
