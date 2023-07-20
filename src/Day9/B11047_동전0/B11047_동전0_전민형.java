package Day9.B11047_동전0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B11047_동전0_전민형 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String str = reader.readLine();
		String com [] = str.split(" ");

		int num = Integer.parseInt(com[0]);
		int money = Integer.parseInt(com[1]);

		int [] kind = new int [num];
		int cnt = 0;

		for(int i = 0; i<num; i++) {
			str = reader.readLine();
			kind[i] = Integer.parseInt(str);
		}
		
		for(int i = num-1; i>=0; i--) {
			while(kind[i]<=money) {
				money = money - kind[i];
				cnt++;					
			}
		}

		System.out.println(cnt);

	}
}