package Day1.B10807_개수세기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B10807_개수세기_장재은 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		
		String str = reader.readLine();
		String [] strs = str.split(" ");
		
		String v = reader.readLine();
		int cnt = 0;
		
		for(String i:strs) {
			if(i.equals(v)) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}

}
