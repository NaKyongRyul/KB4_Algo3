package Day1.B2018_수들의합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2018_수들의합_전상희 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int a=1, b=1, sum=1, count=1;	
		
		
		while(b != N) {
			if(sum>N) {
				sum -= a;
				a++;
			}
			else if(sum < N) {
				b++;
				sum+=b;
			}
			else {
				b++;
				sum += b;
				count++;
			}
			
		}
		System.out.println(count);
	}

	

}
