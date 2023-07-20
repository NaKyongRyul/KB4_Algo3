package Day9.B2839_설탕배달;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2839_설탕배달_나웅기 {
	static int n;
	static int result;
	static boolean flag;
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(reader.readLine());
		
		flag = false;
		while (n>=0) {
			if (n%5 == 0) {
				result += n/5;
				flag = true;
				System.out.println(result);
				break;
			} else {
				result += 1;
				n -= 3;
			}
		}
		if (!flag) {
			System.out.println(-1);
		}
		
		
	}
}
