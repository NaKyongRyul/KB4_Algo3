package Day1.B11659_구간합구하기4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B11659_구간의합구하기4_전민형 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int a,b,c,d,sum;
		
		String [] str = reader.readLine().split(" ");
		a = Integer.parseInt(str[0]);
		b = Integer.parseInt(str[1]);
		
		str = reader.readLine().split(" ");
		
		int [] arr = new int[a];
		
		for(int i = 0; i<a; i++) {
			arr[i] = Integer.parseInt(str[i]);
		}
		
		for(int i = 0; i<b; i++) {
			
			sum=0;
			str = reader.readLine().split(" ");
			c = Integer.parseInt(str[0]);
			d = Integer.parseInt(str[1]);
			
			for(int j = c-1; j<d; j++) {
				
				sum += arr[j];
				
			}
			
			System.out.println(sum);
		}
		

	}

}
